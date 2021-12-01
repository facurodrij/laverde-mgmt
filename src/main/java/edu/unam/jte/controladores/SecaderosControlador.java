package edu.unam.jte.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.Secadero;
import edu.unam.jte.paginas.ModeloSecadero;
import edu.unam.jte.paginas.ModeloSecaderos;

public class SecaderosControlador {

    private Repositorio repositorio;

    private Exception exception = null;

    public SecaderosControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) throws SQLException {
        var modelo = new ModeloSecaderos();
        modelo.secaderos = repositorio.buscarTodos(Secadero.class);
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("secadero/listar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("secadero/listar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void nuevo(Context ctx) throws SQLException {
        var modelo = new ModeloSecadero();
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("secadero/crear.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("secadero/crear.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void crear(Context ctx) throws SQLException {
        var cuit = ctx.formParamAsClass("cuit", Long.class).get();
        var razonSocial = ctx.formParamAsClass("razonSocial", String.class).get();

        Secadero secadero = new Secadero(cuit, razonSocial);
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(secadero);
            this.repositorio.confirmarTransaccion();
        } catch (Exception e) {
            System.out.println(e);
            exception = e;
            this.repositorio.descartarTransaccion();
        }

        ctx.redirect("/secaderos");
    }

    public void modificar(Context ctx) throws SQLException {
        var modelo = new ModeloSecadero();
        modelo.secadero = this.repositorio.buscar(Secadero.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("secadero/editar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("secadero/editar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void actualizar(Context ctx) throws SQLException {
        var cuit = ctx.formParamAsClass("cuit", Long.class).get();
        var razonSocial = ctx.formParamAsClass("razonSocial", String.class).get();

        Secadero secadero = this.repositorio.buscar(Secadero.class,
                (ctx.pathParamAsClass("id", Integer.class).get()));
        if (secadero != null) {
            secadero.setCuit(cuit);
            secadero.setRazonSocial(razonSocial);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.modificar(secadero);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }

        ctx.redirect("/secaderos");
    }

    public void borrar(Context ctx) throws SQLException {
        Secadero secadero = this.repositorio.buscar(Secadero.class,
                (ctx.pathParamAsClass("id", Integer.class).get()));
        if (secadero != null) {
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.eliminar(Secadero.class, secadero);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }
    }
}
