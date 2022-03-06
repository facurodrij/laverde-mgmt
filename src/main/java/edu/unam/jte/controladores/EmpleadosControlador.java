package edu.unam.jte.controladores;

import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.*;
import edu.unam.jte.paginas.*;

public class EmpleadosControlador {
    private Repositorio repositorio;

    private String excepcion = null;

    private int eliminado = 0;

    public EmpleadosControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) {
        var modelo = new ModeloEmpleados();
        modelo.eliminado = eliminado;
        modelo.excepcion = excepcion;
        eliminado = 0;
        excepcion = null;
        modelo.empleados = repositorio.buscarTodos(Empleado.class);
        for (int i = 0; i < modelo.empleados.size(); i++) {
            if (modelo.empleados.get(i).esInvalido()) {
                modelo.empleados.remove(i);
            }
        }
        ctx.render("empleado/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) {
        var modelo = new ModeloEmpleado();
        modelo.excepcion = excepcion;
        excepcion = null;
        ctx.render("empleado/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws Exception {
        var legajo = ctx.formParam("legajo");
        var dni = Long.parseLong(ctx.formParam("dni"));
        var cuil = Long.parseLong(ctx.formParam("cuil"));
        var apellidos = ctx.formParam("apellidos");
        var nombres = ctx.formParam("nombres");
        var ingreso = LocalDate.parse(ctx.formParam("ingreso"));
        var nacimiento = LocalDate.parse(ctx.formParam("nacimiento"));
        Empleado empleado = new Empleado(legajo, dni, apellidos, nombres, ingreso, nacimiento, cuil);
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(empleado);
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
        var modelo = new ModeloEmpleado();
        modelo.empleado = this.repositorio.buscar(Empleado.class, Integer.parseInt(ctx.pathParam("id")));
        if (modelo.empleado != null) {
            if (modelo.empleado.esValido()) {
                modelo.excepcion = excepcion;
                excepcion = null;
                ctx.render("empleado/editar.jte", Collections.singletonMap("modelo", modelo));
                return;
            }
            excepcion = "El empleado al que intentó acceder fue eliminado anteriormente";
        } else {
            excepcion = "El empleado al que intentó acceder no existe";
        }
        ctx.redirect("/empledos");
    }

    public void actualizar(Context ctx) throws Exception {
        var legajo = ctx.formParam("legajo");
        var dni = Long.parseLong(ctx.formParam("dni"));
        var cuil = Long.parseLong(ctx.formParam("cuil"));
        var apellidos = ctx.formParam("apellidos");
        var nombres = ctx.formParam("nombres");
        var ingreso = LocalDate.parse(ctx.formParam("ingreso"));
        var nacimiento = LocalDate.parse(ctx.formParam("nacimiento"));
        Empleado empleado = this.repositorio.buscar(Empleado.class,
            Integer.parseInt(ctx.pathParam("id")));
        if (empleado != null) {
            empleado.setLegajo(legajo);
            empleado.setDni(dni);
            empleado.setCuil(cuil);
            empleado.setApellidos(apellidos);
            empleado.setNombres(nombres);
            empleado.setIngreso(ingreso);
            empleado.setNacimiento(nacimiento);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            excepcion = "";
        } else {
            excepcion = "El empleado a modificar no se ha encontrado o lo han eliminado";
            throw new Exception(excepcion);
        }
    }

    public void borrar(Context ctx) throws Exception {
        Empleado empleado = this.repositorio.buscar(Empleado.class,
            Integer.parseInt(ctx.pathParam("id")));
        if (empleado != null) {
            var cosechas = repositorio.buscarTodos(Cosecha.class);
            for (int i = 0; i < cosechas.size(); i++) {
                if (cosechas.get(i).esValido()) {
                    for (var emple: cosechas.get(i).getEmpleados()) {
                        if (empleado == emple) {
                            excepcion = "Hay cosecha(s) que fueron realizada(s) por este empleado";
                            throw new Exception(excepcion);
                        }
                    }
                }
            }
            empleado.eliminar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = empleado.getIdEmpleado();
            excepcion = "";
        } else {
            excepcion = "El empleado a eliminar no se encuentra en el sistema";
            throw new Exception(excepcion);
        }
    }

    public void recuperar(Context ctx) throws Exception {
        Empleado empleado = this.repositorio.buscar(Empleado.class,
            Integer.parseInt(ctx.formParam("id")));
        if (empleado != null) {
            empleado.recuperar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = empleado.getIdEmpleado();
            excepcion = null;
        } else {
            excepcion = "No se puede recuperar el empleado deseado";
            throw new Exception(excepcion);
        }
    }
}
