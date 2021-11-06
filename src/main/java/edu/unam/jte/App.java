package edu.unam.jte;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;
//import jakarta.persistence.Persistence;
import java.util.Collections;

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

        //var emf = Persistence.createEntityManagerFactory("LaVerdeSA");
        
        // creo servidor
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
        })
        .exception(Exception.class, (e, ctx) -> { ctx.status(404); }) 
        .start(7000);


        // defino rutas
        app.get("/", App::mostrarIndex); // muestra el index       

    }

    
    /** 
     * @param ctx Contexto de la petición
     */
    private static void mostrarIndex(Context ctx) {
        ctx.render("index.jte", Collections.singletonMap("modelo", null));
    } 
}
