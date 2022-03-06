package edu.unam.jte.controladores;

import io.javalin.http.Context;

import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.*;
import edu.unam.jte.paginas.*;

public class ProductoresControlador {
    private Repositorio repositorio;

    private String excepcion = null;

    private int eliminado = 0;

    public ProductoresControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) {
        var modelo = new ModeloProductores();
        modelo.eliminado = eliminado;
        modelo.excepcion = excepcion;
        eliminado = 0;
        excepcion = null;
        modelo.productores = repositorio.buscarTodos(Productor.class);
        for (int i = 0; i < modelo.productores.size(); i++) {
            if (modelo.productores.get(i).esInvalido()) {
                modelo.productores.remove(i);
            }
        }
        ctx.render("productor/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) {
        var modelo = new ModeloProductor();
        modelo.excepcion = excepcion;
        excepcion = null;
        ctx.render("productor/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws Exception {
        var cuit = Long.parseLong(ctx.formParam("cuit"));
        var apellidos = ctx.formParam("apellidos");
        var nombres = ctx.formParam("nombres");
        Productor productor = new Productor(cuit, apellidos, nombres);
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(productor);
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
        var modelo = new ModeloProductor();
        modelo.productor = this.repositorio.buscar(Productor.class, Integer.parseInt(ctx.pathParam("id")));
        if (modelo.productor != null) {
            if (modelo.productor.esValido()) {
                modelo.excepcion = excepcion;
                excepcion = null;
                ctx.render("productor/editar.jte", Collections.singletonMap("modelo", modelo));
                return;
            }
            excepcion = "El productor al que intentó acceder fue eliminado anteriormente";
        } else {
            excepcion = "El productor al que intentó acceder no existe"; 
        }
        ctx.redirect("/productores");
    }

    public void actualizar(Context ctx) throws Exception {
        var cuit = Long.parseLong(ctx.formParam("cuit"));
        var apellidos = ctx.formParam("apellidos");
        var nombres = ctx.formParam("nombres");
        Productor productor = this.repositorio.buscar(Productor.class,
                Integer.parseInt(ctx.pathParam("id")));
        if (productor != null) {
            productor.setCuit(cuit);
            productor.setApellidos(apellidos);
            productor.setNombres(nombres);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(productor);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            excepcion = "";
        } else {
            excepcion = "El productor a modificar no se ha encontrado o lo han eliminado";
            throw new Exception(excepcion);
        }
    }

    public void borrar(Context ctx) throws Exception {
        Productor productor = this.repositorio.buscar(Productor.class,
            Integer.parseInt(ctx.pathParam("id")));
        if (productor != null) {
            var lotes = repositorio.buscarTodos(Lote.class);
            for (int i = 0; i < lotes.size(); i++) {
                if (lotes.get(i).esValido() && productor == lotes.get(i).getProductor()) {
                    excepcion = "Hay lotes(s) que pertenece(n) a este productor";
                    throw new Exception(excepcion);
                }
            }
            productor.eliminar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(productor);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = productor.getIdProductor();
            excepcion = "";
        } else {
            excepcion = "El productor a eliminar no se encuentra en el sistema";
            throw new Exception(excepcion);
        }
    }

    public void recuperar(Context ctx) throws Exception {
        Productor productor = this.repositorio.buscar(Productor.class,
            Integer.parseInt(ctx.formParam("id")));
        if (productor != null) {
            productor.recuperar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(productor);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = productor.getIdProductor();
            excepcion = null;
        } else {
            excepcion = "No se puede recuperar el productor deseado";
            throw new Exception(excepcion);
        }
    }
}
