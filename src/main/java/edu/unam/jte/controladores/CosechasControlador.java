package edu.unam.jte.controladores;

import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.*;
import edu.unam.jte.paginas.*;

public class CosechasControlador {
    private Repositorio repositorio;

    private String excepcion = null;

    private int eliminado = 0;

    public CosechasControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) {
        var modelo = new ModeloCosechas();
        modelo.eliminado = eliminado;
        modelo.excepcion = excepcion;
        eliminado = 0;
        excepcion = null;
        modelo.cosechas = this.repositorio.buscarTodos(Cosecha.class);
        for (int i = 0; i < modelo.cosechas.size(); i++) {
            if (modelo.cosechas.get(i).esInvalido()) {
                modelo.cosechas.remove(i);
            }
        }
        ctx.render("cosecha/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) {
        var modelo = new ModeloCosecha();
        modelo.excepcion = excepcion;
        excepcion = null;
        modelo.empleados = this.repositorio.buscarTodos(Empleado.class);
        for (int i = 0; i < modelo.empleados.size(); i++) {
            if (modelo.empleados.get(i).esInvalido()) {
                modelo.empleados.remove(i);
            }
        }
        modelo.cuadros = this.repositorio.buscarTodos(Cuadro.class);
        for (int i = 0; i < modelo.cuadros.size(); i++) {
            if (modelo.cuadros.get(i).esInvalido()) {
                modelo.cuadros.remove(i);
            }
        }
        modelo.secaderos = this.repositorio.buscarTodos(Secadero.class);
        for (int i = 0; i < modelo.secaderos.size(); i++) {
            if (modelo.secaderos.get(i).esInvalido()) {
                modelo.secaderos.remove(i);
            }
        }
        ctx.render("cosecha/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws Exception {
        var pesoEntrega = Float.parseFloat(ctx.formParam("pesoEntrega"));
        var tiempoEntrega = LocalDate.parse(ctx.formParam("tiempoEntrega"));
        var pesoRegistro = Float.parseFloat(ctx.formParam("pesoRegistro"));
        var tiempoRegistro = LocalDate.parse(ctx.formParam("tiempoRegistro"));
        var secadero = this.repositorio.buscar(Secadero.class, Integer.parseInt(ctx.formParam("secadero")));
        String[] empleado = ctx.formParam("empleado").split(",");
        String[] cuadro = ctx.formParam("cuadro").split(",");
        var modelo = new ModeloCosecha();
        for (int i = 0; i < empleado.length; i++) {
            modelo.empleados.add(this.repositorio.buscar(Empleado.class, Integer.parseInt(empleado[i])));
        }
        for (int i = 0; i < cuadro.length; i++) {
            modelo.cuadros.add(this.repositorio.buscar(Cuadro.class, Integer.parseInt(cuadro[i])));
        }
        Cosecha cosecha = new Cosecha(pesoEntrega, tiempoEntrega, pesoRegistro, tiempoRegistro, modelo.cuadros, modelo.empleados, secadero);
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(cosecha);
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
        var modelo = new ModeloCosecha();
        modelo.cosecha = this.repositorio.buscar(Cosecha.class,
            Integer.parseInt(ctx.pathParam("id")));
        if (modelo.cosecha != null) {
            if (modelo.cosecha.esValido()) {
                modelo.excepcion = excepcion;
                excepcion = null;
                modelo.empleados = this.repositorio.buscarTodos(Empleado.class);
                for (int i = 0; i < modelo.empleados.size(); i++) {
                    if (modelo.empleados.get(i).esInvalido()) {
                        modelo.empleados.remove(i);
                    }
                }
                modelo.cuadros = this.repositorio.buscarTodos(Cuadro.class);
                for (int i = 0; i < modelo.cuadros.size(); i++) {
                    if (modelo.cuadros.get(i).esInvalido()) {
                        modelo.cuadros.remove(i);
                    }
                }
                modelo.secaderos = this.repositorio.buscarTodos(Secadero.class);
                for (int i = 0; i < modelo.secaderos.size(); i++) {
                    if (modelo.secaderos.get(i).esInvalido()) {
                        modelo.secaderos.remove(i);
                    }
                }
                ctx.render("cosecha/editar.jte", Collections.singletonMap("modelo", modelo));
                return;
            }
            excepcion = "La cosecha a la que intentó acceder fue eliminada anteriormente";
        } else {
            excepcion = "La cosecha a la que intentó acceder no existe"; 
        }
        ctx.redirect("/cosechas");
    }

    public void actualizar(Context ctx) throws Exception {
        var pesoEntrega = Float.parseFloat(ctx.formParam("pesoEntrega"));
        var tiempoEntrega = LocalDate.parse(ctx.formParam("tiempoEntrega"));
        var pesoRegistro = Float.parseFloat(ctx.formParam("pesoRegistro"));
        var tiempoRegistro = LocalDate.parse(ctx.formParam("tiempoRegistro"));
        var secadero = this.repositorio.buscar(Secadero.class, Integer.parseInt(ctx.formParam("secadero")));
        String[] empleado = ctx.formParam("empleado").split(",");
        String[] cuadro = ctx.formParam("cuadro").split(",");
        var modelo = new ModeloCosecha();
        for (int i = 0; i < empleado.length; i++) {
            modelo.empleados.add(this.repositorio.buscar(Empleado.class, Integer.parseInt(empleado[i])));
        }
        for (int i = 0; i < cuadro.length; i++) {
            modelo.cuadros.add(this.repositorio.buscar(Cuadro.class, Integer.parseInt(cuadro[i])));
        }
        Cosecha cosecha = this.repositorio.buscar(Cosecha.class,
                Integer.parseInt(ctx.pathParam("id")));
        if (cosecha != null) {
            this.repositorio.iniciarTransaccion();
            cosecha.setPesoEntrega(pesoEntrega);
            cosecha.setTiempoEntrega(tiempoEntrega);
            cosecha.setPesoRegistro(pesoRegistro);
            cosecha.setTiempoRegistro(tiempoRegistro);
            cosecha.setSecadero(secadero);
            cosecha.setEmpleados(modelo.empleados);
            cosecha.setCuadros(modelo.cuadros);
            try {
                this.repositorio.actualizar(cosecha);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            excepcion = "";
        } else {
            excepcion = "La cosecha a modificar no se ha encontrado o lo han eliminado";
            throw new Exception(excepcion);
        }
    }

    public void borrar(Context ctx) throws Exception {
        Cosecha cosecha = this.repositorio.buscar(Cosecha.class,
            Integer.parseInt(ctx.pathParam("id")));
        if (cosecha != null) {
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.eliminar(Cosecha.class, cosecha);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = cosecha.getIdCosecha();
            excepcion = "";
        } else {
            excepcion = "La cosecha a eliminar no se encuentra en el sistema";
            throw new Exception(excepcion);
        }
    }

    public void recuperar(Context ctx) throws Exception {
        Cosecha cosecha = this.repositorio.buscar(Cosecha.class,
            Integer.parseInt(ctx.formParam("id")));
        if (cosecha != null) {
            cosecha.recuperar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(cosecha);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = cosecha.getIdCosecha();
            excepcion = null;
        } else {
            excepcion = "No se puede recuperar la cosecha deseada";
            throw new Exception(excepcion);
        }
    }
}
