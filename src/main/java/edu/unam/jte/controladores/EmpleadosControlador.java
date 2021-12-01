package edu.unam.jte.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.Empleado;
import edu.unam.jte.paginas.ModeloEmpleado;
import edu.unam.jte.paginas.ModeloEmpleados;

public class EmpleadosControlador {

    private Repositorio repositorio;

    private Exception exception = null;

    public EmpleadosControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) throws SQLException {
        var modelo = new ModeloEmpleados();
        modelo.empleados = repositorio.buscarTodos(Empleado.class);
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("empleado/listar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("empleado/listar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void nuevo(Context ctx) throws SQLException {
        var modelo = new ModeloEmpleado();
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("empleado/crear.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("empleado/crear.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void crear(Context ctx) throws SQLException {
        var legajo = ctx.formParamAsClass("legajo", String.class).get();
        var dni = ctx.formParamAsClass("dni", Long.class).get();
        var cuil = ctx.formParamAsClass("cuil", Long.class).get();
        var apellidos = ctx.formParamAsClass("apellidos", String.class).get();
        var nombres = ctx.formParamAsClass("nombres", String.class).get();
        var ingreso = LocalDate.parse(ctx.formParamAsClass("ingreso", String.class).get());
        var nacimiento = LocalDate.parse(ctx.formParamAsClass("nacimiento", String.class).get());

        Empleado empleado = new Empleado(legajo, dni, apellidos, nombres, ingreso, nacimiento, cuil);

        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(empleado);
            this.repositorio.confirmarTransaccion();
        } catch (Exception e) {
            System.out.println(e);
            exception = e;
            this.repositorio.descartarTransaccion();
        }

        ctx.redirect("/empleados");
    }

    public void modificar(Context ctx) throws SQLException {
        var modelo = new ModeloEmpleado();
        modelo.empleado = this.repositorio.buscar(Empleado.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("empleado/editar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("empleado/editar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void actualizar(Context ctx) throws SQLException {
        var legajo = ctx.formParamAsClass("legajo", String.class).get();
        var dni = ctx.formParamAsClass("dni", Long.class).get();
        var cuil = ctx.formParamAsClass("cuil", Long.class).get();
        var apellidos = ctx.formParamAsClass("apellidos", String.class).get();
        var nombres = ctx.formParamAsClass("nombres", String.class).get();
        var ingreso = LocalDate.parse(ctx.formParamAsClass("ingreso", String.class).get());
        var nacimiento = LocalDate.parse(ctx.formParamAsClass("nacimiento", String.class).get());

        Empleado empleado = this.repositorio.buscar(Empleado.class,
                (ctx.pathParamAsClass("id", Integer.class).get()));
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
                this.repositorio.modificar(empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }

        ctx.redirect("/empleados");
    }

    public void borrar(Context ctx) throws SQLException {
        Empleado empleado = this.repositorio.buscar(Empleado.class,
                (ctx.pathParamAsClass("id", Integer.class).get()));
        if (empleado != null) {
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.eliminar(Empleado.class, empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }
    }
}
