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
        var productoresRepositorio = new JPAProductoresRepositorio(emf);
        var productoresControlador = new ProductoresControlador(productoresRepositorio);
        
        // creo servidor
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
        })
        .exception(Exception.class, (e, ctx) -> { ctx.status(404); }) 
        .start(7000);


        // defino rutas
        app.get("/", App::mostrarIndex); // muestra el index
        app.post("/", App::validarUsuario); // "valida usuario"
        app.get("/productores", productoresControlador::listar); // lista los productores
        app.get("/productores/nuevo", productoresControlador::nuevo); // pantalla de nuevo curso
        app.post("/productores", productoresControlador::crear); // crea un curso
        app.get("/productores/{id}", productoresControlador::modificar); // devuelve datos del curso
        app.delete("/productores/{id}", productoresControlador::borrar); // borra un curso 

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

