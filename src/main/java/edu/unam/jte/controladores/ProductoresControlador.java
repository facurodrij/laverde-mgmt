package edu.unam.jte.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.util.Collections;

import edu.unam.jte.paginas.ModeloProductores;
import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.Productor;
import edu.unam.jte.paginas.ModeloProductor;


public class ProductoresControlador {

    private Repositorio repositorio;

    public ProductoresControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listar(Context ctx) throws SQLException {
        var modelo = new ModeloProductores();
        modelo.productores = repositorio.buscarTodos(Productor.class);     
        ctx.render("productor/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) throws SQLException {
        ctx.render("productor/crear.jte", Collections.singletonMap("modelo", null));        
    }

    public void crear(Context ctx) throws SQLException {
        var cuit = ctx.formParamAsClass("cuit", Long.class).get();
        var apellidos = ctx.formParamAsClass("apellidos", String.class).get();
        var nombres = ctx.formParamAsClass("nombres", String.class).get();
        
        Productor productor = new Productor(cuit, apellidos, nombres);

        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(productor);
            this.repositorio.confirmarTransaccion();
        } catch(Exception e) {
            System.out.println(e);
            this.repositorio.descartarTransaccion();
        }
        
        ctx.redirect("/productores");        
    }

    public void modificar(Context ctx) throws SQLException {
        var modelo = new ModeloProductor();
        modelo.productor = this.repositorio.buscar(Productor.class,(ctx.pathParamAsClass("id", Integer.class).get()));
        ctx.render("productor/editar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void actualizar(Context ctx) throws SQLException {

        var cuit = ctx.formParamAsClass("cuit", Long.class).get();
        var apellidos = ctx.formParamAsClass("apellidos", String.class).get();
        var nombres = ctx.formParamAsClass("nombres", String.class).get();
        
        Productor productor = this.repositorio.buscar(Productor.class,(ctx.pathParamAsClass("id", Integer.class).get()));
        if (productor != null) {
            productor.setCuit(cuit);
            productor.setApellidos(apellidos);
            productor.setNombres(nombres);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.modificar(productor);
                this.repositorio.confirmarTransaccion();
            } catch(Exception e) {
                System.out.println(e);
                this.repositorio.descartarTransaccion();
            }
        }

        ctx.redirect("/productores");        
    }

    public void borrar(Context ctx) throws SQLException {
        Productor productor = this.repositorio.buscar(Productor.class,(ctx.pathParamAsClass("id", Integer.class).get()));
        if (productor != null) {
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.eliminar(Productor.class, productor);
                this.repositorio.confirmarTransaccion();
            } catch(Exception e) {
                System.out.println(e);
                this.repositorio.descartarTransaccion();
            }
        }
    }
}
