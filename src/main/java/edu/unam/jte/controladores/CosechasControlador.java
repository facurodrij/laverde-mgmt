package edu.unam.jte.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.Cosecha;
import edu.unam.jte.modelos.Cuadro;
import edu.unam.jte.modelos.Empleado;
import edu.unam.jte.modelos.Secadero;
import edu.unam.jte.paginas.ModeloCosecha;
import edu.unam.jte.paginas.ModeloCosechas;

public class CosechasControlador {

    private Repositorio repositorio;

    private Exception exception = null;

    public CosechasControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) throws SQLException {
        var modelo = new ModeloCosechas();
        modelo.cosechas = repositorio.buscarTodos(Cosecha.class);
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("cosecha/listar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("cosecha/listar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void nuevo(Context ctx) throws SQLException {
        var modelo = new ModeloCosecha();
        modelo.empleados = repositorio.buscarTodos(Empleado.class);
        modelo.cuadros = repositorio.buscarTodos(Cuadro.class);
        modelo.secaderos = repositorio.buscarTodos(Secadero.class);
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("cosecha/crear.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("cosecha/crear.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void crear(Context ctx) throws SQLException {
        var pesoEntrega = ctx.formParamAsClass("pesoEntrega", Float.class).get();
        var tiempoEntrega = LocalDate.parse(ctx.formParamAsClass("tiempoEntrega", String.class).get());
        var pesoRegistro = ctx.formParamAsClass("pesoRegistro", Float.class).get();
        var tiempoRegistro = LocalDate.parse(ctx.formParamAsClass("tiempoRegistro", String.class).get());
        var secadero = this.repositorio.buscar(Secadero.class, (ctx.formParamAsClass("secadero", Integer.class).get()));
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
            System.out.println(e);
            exception = e;
            this.repositorio.descartarTransaccion();
        }

        ctx.redirect("/cosechas");
    }

    public void modificar(Context ctx) throws SQLException {
        var modelo = new ModeloCosecha();
        modelo.empleados = repositorio.buscarTodos(Empleado.class);
        modelo.cuadros = repositorio.buscarTodos(Cuadro.class);
        modelo.secaderos = repositorio.buscarTodos(Secadero.class);
        modelo.cosecha = this.repositorio.buscar(Cosecha.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("cosecha/editar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("cosecha/editar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void actualizar(Context ctx) throws SQLException {
        var pesoEntrega = ctx.formParamAsClass("pesoEntrega", Float.class).get();
        var tiempoEntrega = LocalDate.parse(ctx.formParamAsClass("tiempoEntrega", String.class).get());
        var pesoRegistro = ctx.formParamAsClass("pesoRegistro", Float.class).get();
        var tiempoRegistro = LocalDate.parse(ctx.formParamAsClass("tiempoRegistro", String.class).get());
        var secadero = this.repositorio.buscar(Secadero.class, (ctx.formParamAsClass("secadero", Integer.class).get()));
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
                (ctx.pathParamAsClass("id", Integer.class).get()));
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
                this.repositorio.modificar(cosecha);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }

        ctx.redirect("/cosechas");
    }

    public void borrar(Context ctx) throws SQLException {
        Cosecha cosecha = this.repositorio.buscar(Cosecha.class,
                (ctx.pathParamAsClass("id", Integer.class).get()));
        if (cosecha != null) {
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.eliminar(Cosecha.class, cosecha);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }
    }
}
