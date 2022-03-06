package edu.unam.jte.controladores;

import io.javalin.http.Context;

import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.*;
import edu.unam.jte.paginas.*;

public class SecaderosControlador {
    private Repositorio repositorio;

    private String excepcion = null;

    private int eliminado = 0;

    public SecaderosControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) {
        var modelo = new ModeloSecaderos();
        modelo.eliminado = eliminado;
        modelo.excepcion = excepcion;
        eliminado = 0;
        excepcion = null;
        modelo.secaderos = repositorio.buscarTodos(Secadero.class);
        for (int i = 0; i < modelo.secaderos.size(); i++) {
            if (modelo.secaderos.get(i).esInvalido()) {
                modelo.secaderos.remove(i);
            }
        }
        ctx.render("secadero/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) {
        var modelo = new ModeloSecadero();
        modelo.excepcion = excepcion;
        excepcion = null;
        ctx.render("secadero/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws Exception {
        var cuit = Long.valueOf(ctx.formParam("cuit"));
        var razonSocial = ctx.formParam("razonSocial");
        Secadero secadero = new Secadero(cuit, razonSocial);
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(secadero);
            this.repositorio.confirmarTransaccion();
        } catch (Exception e) {
            this.repositorio.descartarTransaccion();
            e.printStackTrace();
            excepcion = e.getCause().getCause().getMessage();
            throw new Exception(excepcion);
        }
        excepcion = "";
    }

    public void modificar(Context ctx) {
        var modelo = new ModeloSecadero();
        modelo.secadero = this.repositorio.buscar(Secadero.class, Integer.valueOf(ctx.pathParam("id")));
        if (modelo.secadero != null) {
            if (modelo.secadero.esValido()) {
                modelo.excepcion = excepcion;
                excepcion = null;
                ctx.render("secadero/editar.jte", Collections.singletonMap("modelo", modelo));
                return;
            }
            excepcion = "El secadero al que intentó acceder fue eliminado anteriormente";
        } else {
            excepcion = "El secadero al que intentó acceder no existe";      
        }
        ctx.redirect("/lotes");
    }

    public void actualizar(Context ctx) throws Exception {
        var cuit = Long.valueOf(ctx.formParam("cuit"));
        var razonSocial = ctx.formParam("razonSocial");
        Secadero secadero = this.repositorio.buscar(Secadero.class,
                Integer.valueOf(ctx.pathParam("id")));
        if (secadero != null) {
            secadero.setCuit(cuit);
            secadero.setRazonSocial(razonSocial);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(secadero);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            excepcion = "";
        } else {
            excepcion = "El lote a modificar no se ha encontrado o lo han eliminado";
            throw new Exception(excepcion);
        }
    }

    public void borrar(Context ctx) throws Exception {
        Secadero secadero = this.repositorio.buscar(Secadero.class,
            Integer.valueOf(ctx.pathParam("id")));
        if (secadero != null) {
            var cosechas = repositorio.buscarTodos(Cosecha.class);
            for (int i = 0; i < cosechas.size(); i++) {
                if (cosechas.get(i).esValido() && secadero == cosechas.get(i).getSecadero()) {
                    excepcion = "Hay cosecha(s) que fue(ron) enviada(s) a este secadero";
                    throw new Exception(excepcion);
                }
            }
            secadero.eliminar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(secadero);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = secadero.getIdSecadero();
            excepcion = "";
        } else {
            excepcion = "El secadero a eliminar no se encuentra en el sistema";
            throw new Exception(excepcion);
        }
    }

    public void recuperar(Context ctx) throws Exception {
        Secadero secadero = this.repositorio.buscar(Secadero.class,
            Integer.valueOf(ctx.formParam("id")));
        if (secadero != null) {
            secadero.recuperar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(secadero);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = secadero.getIdSecadero();
            excepcion = null;
        } else {
            excepcion = "No se puede recuperar el secadero deseado";
            throw new Exception(excepcion);
        }
    }
}
