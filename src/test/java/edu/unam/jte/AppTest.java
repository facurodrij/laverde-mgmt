package edu.unam.jte;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import org.junit.*;
import org.mockito.Mock;
import org.openqa.selenium.*;

import io.javalin.http.Context;
import kong.unirest.*;
import kong.unirest.Cookie;

public class AppTest extends Testeo {
    @Mock
    HttpResponse<String> response;

    /**
     * Se inicia la aplicación una sola vez para poder iniciar la página web en su
     * puerto,
     * por eso es un método estático; sino se tendría una excepción, la cual que se
     * trata de
     * iniciar una página sobre un puerto que ya está ocupado por otra instancia del
     * mismo
     * sitio. Este método no puede ser extendido porque provoca errores en la
     * ejecución de
     * pruebas, por lo tanto debe colocarse en todas las clases en test.
     */
    @BeforeClass
    public static void iniciarApp() {
        App.main(null);
    }

    @Test
    public void validarUsuario_guarda_cookie() {
        Context ctx = mock(Context.class);
        String nombre = "Usuario  Generico"; // Reemplazar con cualquier cadena
        // Dado el nombre de usuario que devolvera el parametro nombre
        given(ctx.formParam("nombreUsuario")).willReturn(nombre);
        // Cuando se valida el usuario en la App
        App.validarUsuario(ctx);
        // Entonces el contexto debe guardar el nombre de usuario dentro de las cookies
        then(ctx).should().cookie("nombreUsuario", nombre.trim());
    }

    @Test
    public void validarUsuario_redirecciona() {
        Context ctx = mock(Context.class);
        String nombre = "Usuario  Generico"; // Reemplazar con cualquier cadena
        // Dado el nombre de usuario que devolvera el parametro nombre
        given(ctx.formParam("nombreUsuario")).willReturn(nombre);
        // Cuando se valida el usuario en la App
        App.validarUsuario(ctx);
        // Entonces el contexto debe redireccionar la dirreccion actual a '/'
        then(ctx).should().redirect("/");
    }

    @Test
    public void mostrarIndex_sin_usuario() {
        HttpResponse<String> respuesta = Unirest.get("http://localhost:7000/").asString();
        assertEquals(respuesta.getStatus(), 200);
        assertTrue(respuesta.getBody().toString().contains("form"));
        Unirest.shutDown();
    }

    @Test
    public void mostrarIndex_con_usuario() {
        String nombre = "Usuario  Generico"; // Reemplazar con cualquier cadena
        String saludo = "Hola " + nombre.trim() + "!";
        Cookie cookie = new Cookie("nombreUsuario", nombre.trim());
        HttpResponse<String> response = Unirest.get("http://localhost:7000/").cookie(cookie).asString();
        assertEquals(response.getStatus(), 200);
        assertTrue(response.getBody().toString().contains(saludo));
        Unirest.shutDown();
    }

    @Test
    public void contiene_encabezado_Chrome() {
        WebDriver driver = super.driver_para_Chrome();
        driver.get("http://localhost:7000/");
        super.interfaz_contiene_encabezado(driver);
    }

    @Test
    public void contiene_pie_Chrome() {
        WebDriver driver = super.driver_para_Chrome();
        driver.get("http://localhost:7000/");
        super.interfaz_contiene_pie(driver);
    }

    @Test
    public void contiene_barra_lateral_Chrome() {
        WebDriver driver = super.driver_para_Chrome();
        driver.get("http://localhost:7000/");
        super.interfaz_contiene_barra_lateral(driver);
    }

    @Test
    public void contiene_encabezado_Firefox() {
        WebDriver driver = super.driver_para_Firefox();
        driver.get("http://localhost:7000/");
        super.interfaz_contiene_encabezado(driver);
    }

    @Test
    public void contiene_pie_Firefox() {
        WebDriver driver = super.driver_para_Firefox();
        driver.get("http://localhost:7000/");
        super.interfaz_contiene_pie(driver);
    }

    @Test
    public void contiene_barra_lateral_Firefox() {
        WebDriver driver = super.driver_para_Firefox();
        driver.get("http://localhost:7000/");
        super.interfaz_contiene_barra_lateral(driver);
    }
}
