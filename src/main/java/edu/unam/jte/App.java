package edu.unam.jte;

import static io.javalin.apibuilder.ApiBuilder.*;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;

import jakarta.persistence.*;

import java.util.Collections;

import edu.unam.jte.controladores.*;
import edu.unam.jte.paginas.*;
import edu.unam.jte.repositorios.*;



/**
 * Aplicación principal
 */
public class App {

    /**
     * Método que inicia la aplicación. Antes de ejecutar el método, asegúrese que
     * la base de datos tiene la extensión PostGIS creada.
     */
    //CREATE EXTENSION PostGIS;
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaVerdeSA");

        // repositorios y controladores
        var repositorio = new Repositorio(emf);
        var productoresControlador = new ProductoresControlador(repositorio);
        var lotesControlador = new LotesControlador(repositorio);
        var cuadrosControlador = new CuadrosControlador(repositorio);
        var empleadosControlador = new EmpleadosControlador(repositorio);
        var cosechasControlador = new CosechasControlador(repositorio);
        var secaderosControlador = new SecaderosControlador(repositorio);

        // creo servidor
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
            config.enforceSsl = true;
        }).exception(Exception.class, (e, ctx) -> {
            ctx.status(404);
        }).start(7000);

        // defino rutas
        app.routes(() -> {
            path("cosechas", () -> {
                get(cosechasControlador::listar);
                post(cosechasControlador::recuperar);
                path("nuevo", () -> {
                    get(cosechasControlador::nuevo);
                    post(cosechasControlador::crear);
                });
                path("{id}", () -> {
                    get(cosechasControlador::modificar);
                    post(cosechasControlador::actualizar);
                    delete(cosechasControlador::borrar);
                });
            });
            path("cuadros", () -> {
                get(cuadrosControlador::listar);
                post(cuadrosControlador::recuperar);
                path("nuevo", () -> {
                    get(cuadrosControlador::nuevo);
                    post(cuadrosControlador::crear);
                });
                path("{id}", () -> {
                    get(cuadrosControlador::modificar);
                    post(cuadrosControlador::actualizar);
                    delete(cuadrosControlador::borrar);
                });
            });
            path("empleados", () -> {
                get(empleadosControlador::listar);
                post(empleadosControlador::recuperar);
                path("nuevo", () -> {
                    get(empleadosControlador::nuevo);
                    post(empleadosControlador::crear);
                });
                path("{id}", () -> {
                    get(empleadosControlador::modificar);
                    post(empleadosControlador::actualizar);
                    delete(empleadosControlador::borrar);
                });
            });
            path("lotes", () -> {
                get(lotesControlador::listar);
                post(lotesControlador::recuperar);
                path("nuevo", () -> {
                    get(lotesControlador::nuevo);
                    post(lotesControlador::crear);
                });
                path("{id}", () -> {
                    get(lotesControlador::modificar);
                    post(lotesControlador::actualizar);
                    delete(lotesControlador::borrar);
                });
            });
            path("productores", () -> {
                get(productoresControlador::listar);
                post(productoresControlador::recuperar);
                path("nuevo", () -> {
                    get(productoresControlador::nuevo);
                    post(productoresControlador::crear);
                });
                path("{id}", () -> {
                    get(productoresControlador::modificar);
                    post(productoresControlador::actualizar);
                    delete(productoresControlador::borrar);
                });
            });
            path("secaderos", () -> {
                get(secaderosControlador::listar);
                post(secaderosControlador::recuperar);
                path("nuevo", () -> {
                    get(secaderosControlador::nuevo);
                    post(secaderosControlador::crear);
                });
                path("{id}", () -> {
                    get(secaderosControlador::modificar);
                    post(secaderosControlador::actualizar);
                    delete(secaderosControlador::borrar);
                });
            });
        });
        app.get("/", App::mostrarIndex); // muestra el index
        app.post("/", App::validarUsuario); // "valida usuario"
    }

    /**
     * @param ctx Contexto de la petición
     */
    protected static void mostrarIndex(Context ctx) {
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
    protected static void validarUsuario(Context ctx) {
        // obtengo valor enviado en el formulario
        var valor = ctx.formParam("nombreUsuario");
        // creo el cookie (antes se debe validar sobre la base de datos o alguna otra forma),
        // recibo el elemento y hago un trim para guardarlo en el cookie
        ctx.cookie("nombreUsuario", valor.trim());
        // redirecciono a /
        ctx.redirect("/");
    }
}
