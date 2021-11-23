package edu.unam.jte.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.util.Collections;

import edu.unam.jte.paginas.ModeloCuadro;
import edu.unam.jte.paginas.ModeloCuadros;
import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.Cuadro;
import edu.unam.jte.modelos.Lote;

public class CuadrosControlador {
    private Repositorio repositorio;

    public CuadrosControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) throws SQLException {
        var modelo = new ModeloCuadros();
        modelo.cuadros = repositorio.buscarTodos(Cuadro.class);
        ctx.render("cuadro/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) throws SQLException {
        var modelo = new ModeloCuadro();
        modelo.lotes = repositorio.buscarTodos(Lote.class);
        ctx.render("cuadro/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws SQLException {
        var descripcion = ctx.formParamAsClass("descripcion", String.class).get();
        var lote = this.repositorio.buscar(Lote.class, (ctx.formParamAsClass("lote", Integer.class).get()));

        Cuadro cuadro = new Cuadro(descripcion, lote);

        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(cuadro);
            this.repositorio.confirmarTransaccion();
        } catch (Exception e) {
            System.out.println(e);
            this.repositorio.descartarTransaccion();
        }

        ctx.redirect("/cuadros");
    }

    public void modificar(Context ctx) throws SQLException {
        var modelo = new ModeloCuadro();
        modelo.cuadro = this.repositorio.buscar(Cuadro.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        modelo.lotes = repositorio.buscarTodos(Lote.class);
        ctx.render("cuadro/editar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void actualizar(Context ctx) throws SQLException {
        var descripcion = ctx.formParamAsClass("descripcion", String.class).get();
        var lote = this.repositorio.buscar(Lote.class, (ctx.formParamAsClass("lote", Integer.class).get()));

        Cuadro cuadro = this.repositorio.buscar(Cuadro.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        if (cuadro != null) {
            cuadro.setDescripcion(descripcion);
            cuadro.setLote(lote);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.modificar(cuadro);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                this.repositorio.descartarTransaccion();
            }
        }

        ctx.redirect("/cuadros");
    }

    public void borrar(Context ctx) throws SQLException {
        Cuadro cuadro = this.repositorio.buscar(Cuadro.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        if (cuadro != null) {
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.eliminar(Cuadro.class, cuadro);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                this.repositorio.descartarTransaccion();
            }
        }
    }
}
