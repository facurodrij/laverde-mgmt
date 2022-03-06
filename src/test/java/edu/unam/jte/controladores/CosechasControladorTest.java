package edu.unam.jte.controladores;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.*;

import edu.unam.jte.*;
import edu.unam.jte.modelos.Cosecha;
import edu.unam.jte.modelos.Secadero;
import edu.unam.jte.repositorios.Repositorio;
import io.javalin.http.Context;

import org.junit.*;
import org.mockito.Mock;

import org.openqa.selenium.*;

public class CosechasControladorTest extends Testeo {
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
    public void crear_test() {
        Context ctx = mock(Context.class);
        Repositorio repo = mock(Repositorio.class);
        SecaderosControlador secaderoControlador = new SecaderosControlador(repo);
        EmpleadosControlador empleadoControlador = new EmpleadosControlador(repo);
        ProductoresControlador productorControlador = new ProductoresControlador(repo);
        LotesControlador loteControlador = new LotesControlador(repo);
        CuadrosControlador cuadroControlador = new CuadrosControlador(repo);
        String cuit = "30416330700";
        String razonSocial = "Algun secadero";
        String legajo = "LEG01";
        String cuil = "20416330701";
        String dni = "41633070";
        String apellidos = "Antoniak";
        String nombres = "Rodrigo Lionel";
        String ingreso = "2021-03-03"; //AAAA-MM-DD
        String nacimiento = "1999-09-27"; //AAAA-MM-DD
        given(ctx.formParam("cuit")).willReturn(cuit);
        given(ctx.formParam("razonSocial")).willReturn(razonSocial);
        given(ctx.formParam("legajo")).willReturn(legajo);
        given(ctx.formParam("cuil")).willReturn(cuil);
        given(ctx.formParam("dni")).willReturn(dni);
        given(ctx.formParam("apellidos")).willReturn(apellidos);
        given(ctx.formParam("nombres")).willReturn(nombres);
        given(ctx.formParam("ingreso")).willReturn(ingreso);
        given(ctx.formParam("nacimiento")).willReturn(nacimiento);
        try {
            secaderoControlador.crear(ctx);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
        try {
            empleadoControlador.crear(ctx);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
        // Aquí se modifican los datos para los productores
        cuit = "20416330701";
        apellidos = "Antoniak";
        nombres = "Rodrigo Lionel";
        // esta repetición de comandos se realiza por seguridad
        given(ctx.formParam("cuit")).willReturn(cuit);
        given(ctx.formParam("apellidos")).willReturn(apellidos);
        given(ctx.formParam("nombres")).willReturn(nombres);
        try {
            productorControlador.crear(ctx);
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        }
        assertTrue(true);
        /*
        String pesoEntrega = "5.4f";
        String tiempoEntrega = "15:45";
        String pesoRegistro = "5.4f";
        String tiempoRegistro = "15:45";
        given(ctx.formParam("pesoEntrega")).willReturn(pesoEntrega);
        given(ctx.formParam("tiempoEntrega")).willReturn(tiempoEntrega);
        given(ctx.formParam("pesoRegistro")).willReturn(pesoRegistro);
        given(ctx.formParam("tiempoEntrega")).willReturn(tiempoRegistro);
        */
    }

    @Test
    public void contiene_encabezado_Chrome() {
        WebDriver driver = super.driver_para_Chrome();
        driver.get("http://localhost:7000/cosechas/");
        super.interfaz_contiene_encabezado(driver);
    }

    @Test
    public void contiene_pie_Chrome() {
        WebDriver driver = super.driver_para_Chrome();
        driver.get("http://localhost:7000/cosechas/");
        super.interfaz_contiene_pie(driver);
    }

    @Test
    public void contiene_barra_lateral_Chrome() {
        WebDriver driver = super.driver_para_Chrome();
        driver.get("http://localhost:7000/cosechas/");
        super.interfaz_contiene_barra_lateral(driver);
    }

    @Test
    public void contiene_encabezado_Firefox() {
        WebDriver driver = super.driver_para_Firefox();
        driver.get("http://localhost:7000/cosechas/");
        super.interfaz_contiene_encabezado(driver);
    }

    @Test
    public void contiene_pie_Firefox() {
        WebDriver driver = super.driver_para_Firefox();
        driver.get("http://localhost:7000/cosechas/");
        super.interfaz_contiene_pie(driver);
    }

    @Test
    public void contiene_barra_lateral_Firefox() {
        WebDriver driver = super.driver_para_Firefox();
        driver.get("http://localhost:7000/cosechas/");
        super.interfaz_contiene_barra_lateral(driver);
    }
}
