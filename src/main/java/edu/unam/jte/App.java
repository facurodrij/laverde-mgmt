package edu.unam.jte;

import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.core.security.RouteRole;
import io.javalin.Javalin;
import io.javalin.http.*;
import io.javalin.http.staticfiles.Location;
import jakarta.persistence.*;

import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.*; 
import java.util.*;

import edu.unam.jte.controladores.*;
import edu.unam.jte.paginas.*;
import edu.unam.jte.repositorios.*;



/**
 * Aplicación principal
 */
public class App {
    /**
     * Roles que se pueden ejercer dentro del sistema
     */
    static enum rol implements RouteRole {
        autorizado,
        productor,
        secadero,
        cualquiera
    }

    protected static rol getRolUsuario(Context ctx) {
        if (ctx.fullUrl().contains("/admin/")) {
            if (ctx.cookie("usuario").equals("admin")) {
                return rol.autorizado;
            } else {
                return rol.cualquiera;
            }
        }
        if (ctx.fullUrl().contains("/productor/")) {
            if (ctx.cookie("usuario").equals("productor")) {
                return rol.productor;
            } else {
                return rol.cualquiera;
            }
        }
        if (ctx.fullUrl().contains("/secadero/")) {
            if (ctx.cookie("usuario").equals("secadero")) {
                return rol.secadero;
            } else {
                return rol.cualquiera;
            }
        }
        return rol.cualquiera;
    }

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
            config.accessManager((handler, ctx, routeRoles) -> {
                rol rolUsuario = getRolUsuario(ctx);
                if (routeRoles.contains(rolUsuario)) {
                    handler.handle(ctx);
                } else {
                    ctx.redirect("/");;
                }
            });
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
            config.enforceSsl = true;
        }).exception(Exception.class, (e, ctx) -> {
            ctx.status(404);
        }).start(7000);

        app.before((ctx) -> {
            System.out.println(ctx.cookie("usuario"));
            if (ctx.cookie("usuario") == null) {
                ctx.cookie("usuario", "cualquiera");
            }
        });

        app.routes(() -> {
            get(App::mostrarIndex, rol.cualquiera);
            post(App::cerrarSesion, rol.cualquiera);
            path("admin", () -> {
                get(App::menuAdmin, rol.cualquiera);
                post(App::validarUsuario, rol.cualquiera);
                path("perfil", () -> {
                    get(App::modificarAdministrador, rol.autorizado);
                    post(App::actualizarAdministrador, rol.autorizado);
                });
                path("cosechas", () -> {
                    get(cosechasControlador::listar, rol.autorizado);
                    post(cosechasControlador::recuperar, rol.autorizado);
                    path("nuevo", () -> {
                        get(cosechasControlador::nuevo, rol.autorizado);
                        post(cosechasControlador::crear, rol.autorizado);
                    });
                    path("{id}", () -> {
                        get(cosechasControlador::modificar, rol.autorizado);
                        post(cosechasControlador::actualizar, rol.autorizado);
                        delete(cosechasControlador::borrar, rol.autorizado);
                    });
                });
                path("cuadros", () -> {
                    get(cuadrosControlador::listar, rol.autorizado);
                    post(cuadrosControlador::recuperar, rol.autorizado);
                    path("nuevo", () -> {
                        get(cuadrosControlador::nuevo, rol.autorizado);
                        post(cuadrosControlador::crear, rol.autorizado);
                    });
                    path("{id}", () -> {
                        get(cuadrosControlador::modificar, rol.autorizado);
                        post(cuadrosControlador::actualizar, rol.autorizado);
                        delete(cuadrosControlador::borrar, rol.autorizado);
                    });
                });
                path("empleados", () -> {
                    get(empleadosControlador::listar, rol.autorizado);
                    post(empleadosControlador::recuperar, rol.autorizado);
                    path("nuevo", () -> {
                        get(empleadosControlador::nuevo, rol.autorizado);
                        post(empleadosControlador::crear, rol.autorizado);
                    });
                    path("{id}", () -> {
                        get(empleadosControlador::modificar, rol.autorizado);
                        post(empleadosControlador::actualizar, rol.autorizado);
                        delete(empleadosControlador::borrar, rol.autorizado);
                    });
                });
                path("lotes", () -> {
                    get(lotesControlador::listar, rol.autorizado);
                    post(lotesControlador::recuperar, rol.autorizado);
                    path("nuevo", () -> {
                        get(lotesControlador::nuevo, rol.autorizado);
                        post(lotesControlador::crear, rol.autorizado);
                    });
                    path("{id}", () -> {
                        get(lotesControlador::modificar, rol.autorizado);
                        post(lotesControlador::actualizar, rol.autorizado);
                        delete(lotesControlador::borrar, rol.autorizado);
                    });
                });
                path("productores", () -> {
                    get(productoresControlador::listar, rol.autorizado);
                    post(productoresControlador::recuperar, rol.autorizado);
                    path("nuevo", () -> {
                        get(productoresControlador::nuevo, rol.autorizado);
                        post(productoresControlador::crear, rol.autorizado);
                    });
                    path("{id}", () -> {
                        get(productoresControlador::modificar, rol.autorizado);
                        post(productoresControlador::actualizar, rol.autorizado);
                        delete(productoresControlador::borrar, rol.autorizado);
                    });
                });
                path("secaderos", () -> {
                    get(secaderosControlador::listar, rol.autorizado);
                    post(secaderosControlador::recuperar, rol.autorizado);
                    path("nuevo", () -> {
                        get(secaderosControlador::nuevo, rol.autorizado);
                        post(secaderosControlador::crear, rol.autorizado);
                    });
                    path("{id}", () -> {
                        get(secaderosControlador::modificar, rol.autorizado);
                        post(secaderosControlador::actualizar, rol.autorizado);
                        delete(secaderosControlador::borrar, rol.autorizado);
                    });
                });
            });
            path("productor", () -> {});
            path("secadero", () -> {});
        });
    }

    protected static void mostrarIndex(Context ctx) {
        if (ctx.cookie("usuario").equals("admin")) {
            ctx.redirect("/admin/cosechas");
            return;
        }
        if (ctx.cookie("usuario").equals("productor")) {
            ctx.redirect("/productor/{id}");
            return;
        }
        if (ctx.cookie("usuario").equals("secadero")) {
            ctx.redirect("/secadero/{id}");
            return;
        }
        ctx.render("index.jte");
    }

    protected static void cerrarSesion(Context ctx) {
        ctx.cookie("usuario", "cualquiera");
        ctx.redirect("/");
    }

    protected static byte[] getSHA(String input) throws NoSuchAlgorithmException { 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    protected static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash); 
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) { 
            hexString.insert(0, '0'); 
        } 
        return hexString.toString(); 
    }

    /**
     * @param ctx Contexto de la petición
     */
    protected static void menuAdmin(Context ctx) {
        var modelo = new ModeloIndex();
        modelo.registrado = (ctx.cookie("nombreUsuario") != null &&
            ctx.cookie("contrasenia") != null);
        modelo.excepcion = ctx.cookie("excepcion");
        ctx.removeCookie("excepcion");
        if (ctx.cookie("usuario").equals("admin")) {
            ctx.redirect("/admin/cosechas");
            return;
        }
        ctx.render("admin/index.jte", Collections.singletonMap("modelo", modelo));
    }

    /**
     * @param ctx Contexto de la petición
     */
    protected static void validarUsuario(Context ctx) {
        String nombreUsuario = null;
        String contrasenia = null;
        if (ctx.formParam("nombreUsuario").trim() != "") {
            try {
                nombreUsuario = toHexString(getSHA(ctx.formParam("nombreUsuario").trim()));
                contrasenia = toHexString(getSHA(ctx.formParam("contrasenia")));
            }
            catch (NoSuchAlgorithmException e) {} // el error no puede ocurrir
        } else {
            ctx.cookie("excepcion", "El nombre de usuario sólo tiene espacios");
            ctx.redirect("/admin");
        }
        if (ctx.cookie("nombreUsuario") != null && ctx.cookie("contrasenia") != null) {
            if (!(nombreUsuario.equals(ctx.cookie("nombreUsuario"))) ||
                !(contrasenia.equals(ctx.cookie("contrasenia"))))
            {
                System.out.println(ctx.cookie("nombreUsuario"));
                System.out.println(ctx.cookie("contrasenia"));
                ctx.cookie("excepcion", "El nombre de usuario o contraseña no coinciden");
                ctx.redirect("/admin");
            }
        } else {
            ctx.cookie("nombreUsuario", nombreUsuario);
            ctx.cookie("contrasenia", contrasenia);
        }
        ctx.cookie("usuario", "admin");
    }

    /**
     * @param ctx Contexto de la petición
     */
    protected static void modificarAdministrador(Context ctx) {
        if (!(ctx.cookie("usuario").equals("admin"))) {
            ctx.cookie("usuario", "cualquiera");
            ctx.redirect("/");
            return;
        }
        var modelo = new ModeloIndividual();
        modelo.excepcion = ctx.cookie("excepcion");
        ctx.removeCookie("excepcion");
        ctx.render("admin/perfil.jte", Collections.singletonMap("modelo", modelo));
    }

    /**
     * @param ctx Contexto de la petición
     */
    protected static void actualizarAdministrador(Context ctx) throws Exception {
        String nombreUsuario = null;
        String contrasenia = null;
        String excepcion = null;
        if (ctx.formParam("nombreUsuario").trim() != "") {
            try {
                nombreUsuario = toHexString(getSHA(ctx.formParam("nombreUsuario").trim()));
                contrasenia = toHexString(getSHA(ctx.formParam("contrasenia")));
            }
            catch (NoSuchAlgorithmException e) {} // el error no puede ocurrir
        } else {
            excepcion = "El nombre de usuario sólo tiene espacios";
            ctx.cookie("excepcion", excepcion);
            throw new Exception(excepcion);
        }
        ctx.removeCookie("excepcion");
        ctx.cookie("nombreUsuario", nombreUsuario);
        ctx.cookie("contrasenia", contrasenia);
    }
}
