package edu.unam.jte.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.util.Collections;

import edu.unam.jte.repositorios.ProductoresRepositorio;
import edu.unam.jte.modelos.Productor;
import edu.unam.jte.paginas.ModeloProductor;
import edu.unam.jte.paginas.ModeloProductores;

public class ProductoresControlador {

    private final ProductoresRepositorio productoresRepositorio;

    public ProductoresControlador(ProductoresRepositorio productoresRepositorio) {
        this.productoresRepositorio = productoresRepositorio;
    }

    public void listar(Context ctx) throws SQLException {
        var modelo = new ModeloProductores();
        modelo.productores = productoresRepositorio.listar();
        System.out.println(modelo.productores);      
        ctx.render("productores.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) throws SQLException {
        ctx.render("crearProductor.jte", Collections.singletonMap("modelo", null));        
    }

    public void crear(Context ctx) throws SQLException {

        // obtengo datos del formulario
        var cuit = ctx.formParamAsClass("cuit", Long.class).get();
        var apellidos = ctx.formParamAsClass("apellidos", String.class).get();
        var nombres = ctx.formParamAsClass("nombres", String.class).get();
        
        // creo objeto Productor
        var productor = new Productor(cuit, apellidos, nombres);

        // inserto en base de datos
        this.productoresRepositorio.crear(productor);
        
        // redirecciono
        ctx.redirect("/productores");        
    }

    public void borrar(Context ctx) throws SQLException {
        this.productoresRepositorio.borrar((ctx.pathParamAsClass("idProductor", Integer.class).get()));
    }

    public void modificar(Context ctx) throws SQLException {
        var modelo = new ModeloProductor();
        modelo.productor = this.productoresRepositorio.obtener((ctx.pathParamAsClass("idProductor", Integer.class).get()));
        ctx.render("editarProductor.jte", Collections.singletonMap("modelo", modelo));
    }

}
