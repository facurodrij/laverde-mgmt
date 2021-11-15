package edu.unam.jte;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Collections;
import edu.unam.jte.controladores.*;
import edu.unam.jte.paginas.*;
import edu.unam.jte.repositorios.*;

import static io.javalin.apibuilder.ApiBuilder.*;

// para usar routes
// import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * Aplicación de ejemplo usando jte y sql2o
 * 
 */
public class App {
    
    
    /** 
     * @param args argumento que recibe la aplicación
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaVerdeSA");

        // repositorios y controladores
        var Repositorio = new Repositorio(emf);
        var productoresControlador = new ProductoresControlador(Repositorio);
        
        // creo servidor
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
            config.enableCorsForAllOrigins();
        })
        .exception(Exception.class, (e, ctx) -> { ctx.status(404); })
        .start(7000);

        //defino rutas
        app.routes(() -> {
            path("productores", () -> {
                get(productoresControlador::listar);
                post(productoresControlador::crear);
                path("nuevo", () -> {
                    get(productoresControlador::nuevo);
                });
                path("{id}", () -> {
                    get(productoresControlador::modificar);
                    post(productoresControlador::actualizar);
                    delete(productoresControlador::borrar);
                });
            });
        });

        app.get("/", App::mostrarIndex); // muestra el index
        app.post("/", App::validarUsuario); // "valida usuario"
    }

    
    /** 
     * @param ctx Contexto de la petición
     */
    private static void mostrarIndex(Context ctx) {
        var modelo = new ModeloIndex();
        // controlo por cookie
        if (ctx.cookie("nombreUsuario") != null) {
            modelo.nombreUsuario = ctx.cookie("nombreUsuario");
        } else {
            modelo.nombreUsuario = "";
        }
        ctx.render("index.jte", Collections.singletonMap("modelo", modelo));
    }

    /** 
     * @param ctx Contexto de la petición
     */
    private static void validarUsuario(Context ctx) {
        // obtengo valor enviado en el formulario
        var valor = ctx.formParamAsClass("nombreUsuario", String.class).get();
        // creo el cookie (antes se debe validar sobre la base de datos o alguna otra forma)
        // recibo el elemento y hago un trim para guardarlo en el cookie
        ctx.cookie("nombreUsuario", valor.trim());
        // redirecciono a / 
        ctx.redirect("/");
    }
}

