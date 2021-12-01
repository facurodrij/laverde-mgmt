package edu.unam.jte.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.Lote;
import edu.unam.jte.modelos.Productor;
import edu.unam.jte.paginas.ModeloLote;
import edu.unam.jte.paginas.ModeloLotes;

public class LotesControlador {
    private Repositorio repositorio;

    private Exception exception = null;

    public LotesControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) throws SQLException {
        var modelo = new ModeloLotes();
        modelo.lotes = repositorio.buscarTodos(Lote.class);
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("lote/listar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("lote/listar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void nuevo(Context ctx) throws SQLException {
        var modelo = new ModeloLote();
        modelo.productores = repositorio.buscarTodos(Productor.class);
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("lote/crear.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("lote/crear.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void crear(Context ctx) throws SQLException {
        double punto1[] = new double[2];
        double punto2[] = new double[2];
        punto1[0] = ctx.formParamAsClass("punto1X", Double.class).get();
        punto1[1] = ctx.formParamAsClass("punto1Y", Double.class).get();
        punto2[0] = ctx.formParamAsClass("punto2X", Double.class).get();
        punto2[1] = ctx.formParamAsClass("punto2Y", Double.class).get();
        var productor = this.repositorio.buscar(Productor.class,
                (ctx.formParamAsClass("productor", Integer.class).get()));

        Lote lote = new Lote(punto1, punto2, productor);

        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(lote);
            this.repositorio.confirmarTransaccion();
        } catch (Exception e) {
            System.out.println(e);
            exception = e;
            this.repositorio.descartarTransaccion();
        }

        ctx.redirect("/lotes");
    }

    public void modificar(Context ctx) throws SQLException {
        var modelo = new ModeloLote();
        modelo.lote = this.repositorio.buscar(Lote.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        modelo.productores = repositorio.buscarTodos(Productor.class);
        if (exception == null) {
            modelo.exception = exception;
            ctx.render("lote/editar.jte", Collections.singletonMap("modelo", modelo));
        } else {
            modelo.exception = exception;
            ctx.render("lote/editar.jte", Collections.singletonMap("modelo", modelo));
            exception = null;
        }
    }

    public void actualizar(Context ctx) throws SQLException {
        double punto1[] = new double[2];
        double punto2[] = new double[2];
        punto1[0] = ctx.formParamAsClass("punto1X", Double.class).get();
        punto1[1] = ctx.formParamAsClass("punto1Y", Double.class).get();
        punto2[0] = ctx.formParamAsClass("punto2X", Double.class).get();
        punto2[1] = ctx.formParamAsClass("punto2Y", Double.class).get();
        var productor = this.repositorio.buscar(Productor.class,
                (ctx.formParamAsClass("productor", Integer.class).get()));

        Lote lote = this.repositorio.buscar(Lote.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        if (lote != null) {
            lote.setPunto1(punto1);
            lote.setPunto2(punto2);
            lote.setProductor(productor);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.modificar(lote);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }

        ctx.redirect("/lotes");
    }

    public void borrar(Context ctx) throws SQLException {
        Lote lote = this.repositorio.buscar(Lote.class, (ctx.pathParamAsClass("id", Integer.class).get()));
        if (lote != null) {
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.eliminar(Lote.class, lote);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                System.out.println(e);
                exception = e;
                this.repositorio.descartarTransaccion();
            }
        }
    }
}
