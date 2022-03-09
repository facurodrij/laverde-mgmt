package edu.unam.jte.controladores;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.geolatte.geom.PositionSequenceBuilders.*;

import io.javalin.http.Context;

import java.util.Collections;

import edu.unam.jte.modelos.*;
import edu.unam.jte.paginas.*;
import edu.unam.jte.repositorios.Repositorio;

import org.geolatte.geom.*;

public class CuadrosControlador {
    private Repositorio repositorio;

    private String excepcion = null;

    private int eliminado = 0;

    public CuadrosControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Esta función permite la creación de una figura cerrada a partir de puntos de
     * coordenadas
     * 
     * @param puntos es una matriz de puntos de una figura, donde [0][i] representa
     *               la coordenada X en el punto i y [1][i] es la coordenada Y.
     * @return Devuelve la figura creada.
     * @throws Exception puede ocurrir por parámetros inválidos o mala formación de
     *                   lote
     *                   (sea por formar una simple línea o porque la figura no se
     *                   cierra correctamente).
     */
    private LineString<G2D> crearPuntos(double[][] puntos) throws Exception {
        if (puntos[0].length != puntos[1].length) {
            throw new Exception("El conjunto de coordenadas posee un elemento que no es un par");
        }
        PositionSequenceBuilder<G2D> constructor = variableSized(G2D.class);
        if (puntos[1].length == 2) {
            if (puntos[0][0] == puntos[0][1] || puntos[1][0] == puntos[1][1]) {
                String error = "Las coordenadas provistas no forman un lote, sino una línea";
                excepcion = error;
                throw new Exception(error);
            }
            double abajo = puntos[1][0] < puntos[1][1] ? puntos[1][0] : puntos[1][1];
            double izquierda = puntos[0][0] < puntos[0][1] ? puntos[0][0] : puntos[0][1];
            double arriba = puntos[1][0] > puntos[1][1] ? puntos[1][0] : puntos[1][1];
            double derecha = puntos[0][0] > puntos[0][1] ? puntos[0][0] : puntos[0][1];
            constructor.add(izquierda, abajo);
            constructor.add(derecha, abajo);
            constructor.add(derecha, arriba);
            constructor.add(izquierda, arriba);
            constructor.add(izquierda, abajo);
        } else {
            for (int i = 0; i < puntos[0].length; i++) {
                constructor.add(puntos[0][i], puntos[1][i]);
            }
            constructor.add(puntos[0][0], puntos[1][0]);
        }
        LineString<G2D> figura = new LineString<>(constructor.toPositionSequence(), WGS84);
        if (figura.isRing()) {
            return figura;
        } else {
            throw new Exception("El conjunto de coordenadas no forma una figura adecuadamente");
        }
    }

    /**
     * Sirve para determinar si dos figuras tienen algún punto de común o
     * una de ellas de contiene dentro de la otra, a través de comparación
     * de las rectas que forman cada par de puntos adyacentes de los cuadros.
     * 
     * @param unos  es una matriz de puntos de una figura, donde [0][i] representa
     *              la coordenada X en el punto i y [1][i] es la coordenada Y.
     * @param otros es otra matriz de puntos de una figura, donde [0][i] representa
     *              la coordenada X en el punto i y [1][i] es la coordenada Y.
     * @return Se devuelve verdadero si las figuras se encuentran en solapamiento
     *         o una está dentro de la otra, sino se retorna falso.
     */
    private boolean seSolapanOContienen(double[][] unos, double[][] otros) {
        double[][] f0 = new double[unos[0].length - 1][2];
        double[][] f1 = new double[otros[0].length - 1][2];
        double x0, x1, y0, y1;
        boolean inversa;
        // Primero, se obtienen las pendientes y los origenes que forman las líneas de
        // "unos"
        for (int i = 1; i < unos[0].length; i++) {
            x0 = unos[0][i - 1];
            x1 = unos[0][i];
            y0 = unos[1][i - 1];
            y1 = unos[1][i];
            inversa = (x1 == x0);
            f0[i - 1][0] = inversa ? 0 : ((y1 - y0) / (x1 - x0)); // pendiente
            f0[i - 1][1] = inversa ? x0 : ((y1 == y0) ? y0 : (y1 - y0 - (f0[i - 1][0] * (x1 - x0)))); // origen
        }
        // Después, se obtienen las pendientes y los origenes que forman las líneas de
        // "otros"
        for (int i = 1; i < otros[0].length; i++) {
            x0 = otros[0][i - 1];
            x1 = otros[0][i];
            y0 = otros[1][i - 1];
            y1 = otros[1][i];
            inversa = (x1 == x0);
            f1[i - 1][0] = inversa ? 0 : ((y1 - y0) / (x1 - x0)); // pendiente
            f1[i - 1][1] = inversa ? x0 : ((y1 == y0) ? y0 : (y1 - y0 - (f1[i - 1][0] * (x1 - x0)))); // origen
        }
        // Luego, se evalúa el tipo de pendiente de las funciones lineales
        for (int i = 0; i < f0.length; i++) {
            // Se aplica un doble bucle para evaluar cada linea de "unos" y "otros"
            for (int j = 0; j < f1.length; j++) {
                x0 = unos[0][i + 1] - unos[0][i]; // f0 en inversa si x0==0
                x1 = otros[0][j + 1] - otros[0][j]; // f1 en inversa si x1==0
                // Se consulta si la línea de "unos" es vertical
                if (x0 == 0) {
                    // De ahí, si ambas líneas son verticales (en otras palabras, paralelas)
                    if (x1 == 0) {
                        /*
                         * Por lo tanto, las líneas sólo podrían solaparse si tienen
                         * el mismo valor en el eje X
                         */
                        if (f0[i][1] == f1[j][1]) { // Aquí, ambos valores son abscisas al origen
                            /*
                             * Conociendo el valor mayor y menor en el eje Y,
                             * se facilita la condición de solapamiento
                             */
                            y0 = (otros[1][j] < otros[1][j + 1]) ? otros[1][j] : otros[1][j + 1];
                            y1 = (otros[1][j] > otros[1][j + 1]) ? otros[1][j] : otros[1][j + 1];
                            /*
                             * En caso de existir al menos un punto que tenga valor del eje Y
                             * compartido entre ambas líneas, se concluye que hay solapamiento
                             */
                            if ((unos[1][i] >= y0 && unos[1][i + 1] <= y1) ||
                                    (unos[1][i + 1] >= y0 && unos[1][i + 1] <= y1)) {
                                return true;
                            }
                        }
                        // Acá se comprueba que la línea de "otros" tiene una pendiente válida
                    } else {
                        // Conocer los valores mayor y menor facilitan la comparación
                        x0 = (otros[0][j] < otros[0][j + 1]) ? otros[0][j] : otros[0][j + 1];
                        x1 = (otros[0][j] > otros[0][j + 1]) ? otros[0][j] : otros[0][j + 1];
                        /*
                         * Debe evaluarse si la línea de "otros" se cruza con
                         * la función lineal de "unos"
                         */
                        if (f0[i][1] >= x0 && f0[i][1] <= x1) { // f0[i][1] es abscisa al origen
                            x0 = f1[j][0] * f0[i][1] + f1[j][1]; // actua como f(x)
                            // Conocer los valores mayor y menor facilitan la comparación
                            y0 = (unos[1][i] < unos[1][i + 1]) ? unos[1][i] : unos[1][i + 1];
                            y1 = (unos[1][i] > unos[1][i + 1]) ? unos[1][i] : unos[1][i + 1];
                            /*
                             * Aquí ya se evalúa si el cruce de funciones lineales ocurre
                             * dentro de las líneas de "unos" y "otros"
                             */
                            if (x0 >= y0 && x0 <= y1) {
                                return true;
                            }
                        }
                    }
                } else {
                    /*
                     * Acá se consulta si la línea de "unos" tiene una pendiente válida
                     * y "otros" es una línea vertical
                     */
                    if (x1 == 0) {
                        // Conocer los valores mayor y menor facilitan la comparación
                        x0 = (unos[0][i] < unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                        x1 = (unos[0][i] > unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                        /*
                         * Debe evaluarse si la línea de "unos" se cruza con
                         * la función lineal de "otros"
                         */
                        if (f1[j][1] >= x0 && f1[j][1] <= x1) { // f1[j][1] es abscisa al origen
                            x0 = f0[i][0] * f1[j][1] + f0[i][1]; // actua como f(x)
                            // Conocer los valores mayor y menor facilitan la comparación
                            y0 = (otros[1][j] < otros[1][j + 1]) ? otros[1][j] : otros[1][j + 1];
                            y1 = (otros[1][j] > otros[1][j + 1]) ? otros[1][j] : otros[1][j + 1];
                            /*
                             * Aquí ya se evalúa si el cruce de funciones lineales ocurre
                             * dentro de las líneas de "unos" y "otros"
                             */
                            if (x0 >= y0 && x0 <= y1) {
                                return true;
                            }
                        }
                        // Si se llega a este bloque, significa que ambas pendientes son válidas
                    } else {
                        // Aquí, se consulta si las líneas son paralelas (pendientes iguales)
                        if (f0[i][0] == f1[j][0]) {
                            /*
                             * Las líneas sólo pueden solaparse si
                             * sus ordenadas al origen son iguales
                             */
                            if (f0[i][1] == f1[j][1]) {
                                /*
                                 * Conociendo el valor mayor y menor en el eje Y,
                                 * se facilita la condición de solapamiento
                                 */
                                y0 = (otros[1][j] < otros[1][j + 1]) ? otros[1][j] : otros[1][j + 1];
                                y1 = (otros[1][j] > otros[1][j + 1]) ? otros[1][j] : otros[1][j + 1];
                                /*
                                 * En caso de existir al menos un punto que tenga
                                 * valor del eje Y compartido entre ambas líneas,
                                 * se concluye que hay solapamiento
                                 */
                                if ((unos[1][i] >= y0 && unos[1][i + 1] <= y1) ||
                                        (unos[1][i + 1] >= y0 && unos[1][i + 1] <= y1)) {
                                    return true;
                                }
                            }
                            /*
                             * Aquí, debe comprobarse si el cruce ocurre dentro del
                             * alcance de las líneas
                             */
                        } else {
                            // Conocer los valores mayor y menor facilitan la comparación
                            x0 = (unos[0][i] < unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                            x1 = (unos[0][i] > unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                            // Temporalmente, ambos valores y representan valores en X
                            y0 = (otros[0][j] < otros[0][j + 1]) ? otros[0][j] : otros[0][j + 1];
                            y1 = (otros[0][j] > otros[0][j + 1]) ? otros[0][j] : otros[0][j + 1];
                            /*
                             * Debe existir al menos un punto que tenga valor X compartido
                             * entre ambas líneas
                             */
                            if (x0 <= y1 && y0 <= x1) {
                                // Ahora si se obtiene los X mayor y menor de ambas líneas
                                x0 = (x0 > y0) ? x0 : y0; // El valor es común a ambas líneas
                                x1 = (x1 < y1) ? x1 : y1; // El valor es común a ambas líneas
                                // y1 ya no se utilizará, por lo que no importa lo que vale
                                y0 = (f1[j][1] - f0[i][1]) / (f1[j][0] - f0[i][0]); // actua como f(y)
                                /*
                                 * Aquí ya se evalúa si el cruce de funciones lineales ocurre
                                 * dentro de las líneas de "unos" y "otros"
                                 */
                                if (y0 > x0 && y0 < x1) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        // Si no existen solapamientos, se procede a verificar la contención
        /*
         * Considerando el comentario anterior, sólo puede ocurrir que
         * un anillo contenga completamente al otro o no; por lo tanto,
         * comparando un punto de cada anillo es suficiente para probar
         * si un anillo contiene a otro o no
         */
        boolean abajo = false;
        boolean arriba = false;
        boolean izquierda = false;
        boolean derecha = false;
        int i = 0;
        // En esta parte, se probará si "unos" está dentro de "otros"
        while (i < f1.length &&
                !(abajo && arriba && izquierda && derecha)) {
            if (f1[i][0] == 0) { // si la línea es vertical u horizontal
                if (otros[0][i] == otros[0][i + 1]) { // si la línea es vertical
                    y0 = (otros[1][i] < otros[1][i + 1]) ? otros[1][i] : otros[1][i + 1];
                    y1 = (otros[1][i] > otros[1][i + 1]) ? otros[1][i] : otros[1][i + 1];
                    if (unos[1][0] >= y0 && unos[1][0] <= y1) { // si está en el rango vertical
                        if (unos[0][0] < f1[i][1]) { // si el punto está a la izquierda
                            izquierda = true;
                        } else { // si el punto está a la derecha
                            derecha = true;
                        }
                    }
                } else { // si la línea es horizontal
                    x0 = (otros[0][i] < otros[0][i + 1]) ? otros[0][i] : otros[0][i + 1];
                    x1 = (otros[0][i] > otros[0][i + 1]) ? otros[0][i] : otros[0][i + 1];
                    if (unos[0][0] >= x0 && unos[0][0] <= x1) { // si está en el rango horizontal
                        if (unos[1][0] < f1[i][1]) { // si el punto está abajo
                            abajo = true;
                        } else { // si el punto está arriba
                            arriba = true;
                        }
                    }
                }
            } else { // si la pendiente es válida y distinta de cero
                x0 = (otros[0][i] < otros[0][i + 1]) ? otros[0][i] : otros[0][i + 1];
                x1 = (otros[0][i] > otros[0][i + 1]) ? otros[0][i] : otros[0][i + 1];
                y0 = (otros[1][i] < otros[1][i + 1]) ? otros[1][i] : otros[1][i + 1];
                y1 = (otros[1][i] > otros[1][i + 1]) ? otros[1][i] : otros[1][i + 1];
                if (unos[0][0] >= x0 && unos[0][0] <= x1) { // si está en el rango horizontal
                    // si el punto está abajo
                    if (unos[1][0] < ((f1[i][0] * unos[0][0]) + f1[i][1])) {
                        abajo = true;
                    } else { // si el punto está arriba
                        arriba = true;
                    }
                }
                if (unos[1][0] >= y0 && unos[1][0] <= y1) { // si está en el rango vertical
                    // si el punto está a la izquierda
                    if (unos[0][0] < ((unos[1][0] - f1[i][1]) / f1[i][0])) {
                        izquierda = true;
                    } else { // si el punto está a la derecha
                        derecha = true;
                    }
                }
            }
            i++;
        }
        // Si "unos" está dentro de "otros"
        if (abajo && arriba && izquierda && derecha) {
            return true;
        }
        // Debe reiniciarse los valores que se utilicen de control
        abajo = false;
        arriba = false;
        izquierda = false;
        derecha = false;
        i = 0;
        // En esta parte, se probará si "otros" está dentro de "unos"
        while (i < f0.length &&
                !(abajo && arriba && izquierda && derecha)) {
            if (f0[i][0] == 0) { // si la línea es vertical u horizontal
                if (unos[0][i] == unos[0][i + 1]) { // si la línea es vertical
                    y0 = (unos[1][i] < unos[1][i + 1]) ? unos[1][i] : unos[1][i + 1];
                    y1 = (unos[1][i] > unos[1][i + 1]) ? unos[1][i] : unos[1][i + 1];
                    if (otros[1][0] >= y0 && otros[1][0] <= y1) { // si está en el rango vertical
                        if (otros[0][0] < f0[i][1]) { // si el punto está a la izquierda
                            izquierda = true;
                        } else { // si el punto está a la derecha
                            derecha = true;
                        }
                    }
                } else { // si la línea es horizontal
                    x0 = (unos[0][i] < unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                    x1 = (unos[0][i] > unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                    if (otros[0][0] >= x0 && otros[0][0] <= x1) { // si está en el rango horizontal
                        if (otros[1][0] < f0[i][1]) { // si el punto está abajo
                            abajo = true;
                        } else { // si el punto está arriba
                            arriba = true;
                        }
                    }
                }
            } else { // si la pendiente es válida y distinta de cero
                x0 = (unos[0][i] < unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                x1 = (unos[0][i] > unos[0][i + 1]) ? unos[0][i] : unos[0][i + 1];
                y0 = (unos[1][i] < unos[1][i + 1]) ? unos[1][i] : unos[1][i + 1];
                y1 = (unos[1][i] > unos[1][i + 1]) ? unos[1][i] : unos[1][i + 1];
                if (otros[0][0] >= x0 && otros[0][0] <= x1) { // si está en el rango horizontal
                    // si el punto está abajo
                    if (otros[1][0] < ((f0[i][0] * otros[0][0]) + f0[i][1])) {
                        abajo = true;
                    } else { // si el punto está arriba
                        arriba = true;
                    }
                }
                if (otros[1][0] >= y0 && otros[1][0] <= y1) { // si está en el rango vertical
                    // si el punto está a la izquierda
                    if (unos[0][0] < ((unos[1][0] - f0[i][1]) / f0[i][0])) {
                        izquierda = true;
                    } else { // si el punto está a la derecha
                        derecha = true;
                    }
                }
            }
            i++;
        }
        // Si "otros" está dentro de "unos"
        if (abajo && arriba && izquierda && derecha) {
            return true;
        }
        // Si los anillos no se solapan ni se contienen, entonces ambos son válidos
        return false;
    }

    public void listar(Context ctx) {
        var modelo = new ModeloCuadros();
        modelo.eliminado = eliminado;
        modelo.excepcion = excepcion;
        eliminado = 0;
        excepcion = null;
        modelo.cuadros = this.repositorio.buscarTodos(Cuadro.class);
        for (int i = 0; i < modelo.cuadros.size(); i++) {
            if (modelo.cuadros.get(i).esInvalido()) {
                modelo.cuadros.remove(i);
            }
        }
        ctx.render("cuadro/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) {
        var modelo = new ModeloCuadro();
        modelo.excepcion = excepcion;
        excepcion = null;
        modelo.lotes = this.repositorio.buscarTodos(Lote.class);
        for (int i = 0; i < modelo.lotes.size(); i++) {
            if (modelo.lotes.get(i).esInvalido()) {
                modelo.lotes.remove(i);
            }
        }
        ctx.render("cuadro/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws Exception {
        var lote = this.repositorio.buscar(Lote.class, Integer.parseInt(ctx.formParam("lote")));
        String[] puntosX = ctx.formParam("puntosX").split(",");
        String[] puntosY = ctx.formParam("puntosY").split(",");
        double[][] coordenadas = new double[2][puntosX.length];
        for (int i = 0; i < puntosY.length; i++) {
            coordenadas[0][i] = Double.parseDouble(puntosX[i]);
            coordenadas[1][i] = Double.parseDouble(puntosY[i]);
        }
        LineString<G2D> puntos = new LineString<>(WGS84);
        try {
            puntos = crearPuntos(coordenadas);
        } catch (Exception e) {
            e.printStackTrace();
            excepcion = e.getMessage();
            throw new Exception(excepcion);
        }
        var descripcion = ctx.formParam("descripcion");
        Cuadro cuadro = new Cuadro(lote, puntos, descripcion);
        if (!(cuadro.getPuntos().getBoundingBox().within(
            cuadro.getLote().getCoordenadas().getBoundingBox())))
        {
            excepcion = "El cuadro no está dentro del lote";
            throw new Exception(excepcion);
        }
        var cuadros = this.repositorio.buscarTodos(Cuadro.class);
        double[][] unos = new double[2][cuadro.getCantidadPuntos()];
        for (int i = 0; i < unos[0].length; i++) {
            unos[0][i] = cuadro.getPuntoN(i).getLon();
            unos[1][i] = cuadro.getPuntoN(i).getLat();
        }
        double[][] otros;
        for (var otro : cuadros) {
            if (otro.esValido()) {
                otros = new double[2][otro.getCantidadPuntos()];
                for (int i = 0; i < otros[0].length; i++) {
                    otros[0][i] = otro.getPuntoN(i).getLon();
                    otros[1][i] = otro.getPuntoN(i).getLat();
                }
                if (seSolapanOContienen(unos, otros)) {
                    excepcion = "El cuadro a registrar invade otro existente";
                    throw new Exception(excepcion);
                }
            }
        }
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(cuadro);
            this.repositorio.confirmarTransaccion();
        } catch (Exception e) {
            this.repositorio.descartarTransaccion();
            e.printStackTrace();
            excepcion = e.getCause().getCause().getMessage();
            throw new Exception(excepcion);
        }
        excepcion = "";
    }

    public void modificar(Context ctx) {
        var modelo = new ModeloCuadro();
        modelo.cuadro = this.repositorio.buscar(Cuadro.class, Integer.parseInt(ctx.pathParam("id")));
        if (modelo.cuadro != null) {
            if (modelo.cuadro.esValido()) {
                modelo.excepcion = excepcion;
                excepcion = null;
                modelo.lotes = this.repositorio.buscarTodos(Lote.class);
                for (int i = 0; i < modelo.lotes.size(); i++) {
                    if (modelo.lotes.get(i).esInvalido()) {
                        modelo.lotes.remove(i);
                    }
                }
                ctx.render("cuadro/editar.jte", Collections.singletonMap("modelo", modelo));
                return;
            }
            excepcion = "El cuadro al que intentó acceder fue eliminado anteriormente";
        } else {
            excepcion = "El cuadro al que intentó acceder no existe";
        }
        ctx.redirect("/cuadros");
    }

    public void actualizar(Context ctx) throws Exception {
        var descripcion = ctx.formParam("descripcion");
        String[] puntosX = ctx.formParam("puntosX").split(",");
        String[] puntosY = ctx.formParam("puntosY").split(",");
        double[][] coordenadas = new double[2][puntosX.length];
        for (int i = 0; i < puntosY.length; i++) {
            coordenadas[0][i] = Double.parseDouble(puntosX[i]);
            coordenadas[1][i] = Double.parseDouble(puntosY[i]);
        }
        LineString<G2D> puntos = new LineString<>(WGS84);
        try {
            puntos = crearPuntos(coordenadas);
        } catch (Exception e) {
            e.printStackTrace();
            excepcion = e.getMessage();
            throw new Exception(excepcion);
        }
        var lote = this.repositorio.buscar(Lote.class, Integer.parseInt(ctx.formParam("lote")));
        if (!(puntos.getBoundingBox().within(
            lote.getCoordenadas().getBoundingBox())))
        {
            excepcion = "El cuadro no está dentro del lote";
            throw new Exception(excepcion);
        }
        Cuadro cuadro = this.repositorio.buscar(Cuadro.class, Integer.parseInt(ctx.pathParam("id")));
        if (cuadro != null) {
            var cuadros = this.repositorio.buscarTodos(Cuadro.class);
            double[][] unos = new double[2][puntos.getNumPositions()];
            for (int i = 0; i < unos[0].length; i++) {
                unos[0][i] = puntos.getPositionN(i).getLon();
                unos[1][i] = puntos.getPositionN(i).getLat();
            }
            double[][] otros;
            for (var otro : cuadros) {
                if (otro.esValido() && cuadro.getIdCuadro() != otro.getIdCuadro()) {
                    otros = new double[2][otro.getCantidadPuntos()];
                    for (int i = 0; i < otros[0].length; i++) {
                        otros[0][i] = otro.getPuntoN(i).getLon();
                        otros[1][i] = otro.getPuntoN(i).getLat();
                    }
                    if (seSolapanOContienen(unos, otros)) {
                        excepcion = "El cuadro a registrar invade otro existente";
                        throw new Exception(excepcion);
                    }
                }
            }
            cuadro.setDescripcion(descripcion);
            cuadro.setPuntos(puntos);
            cuadro.setLote(lote);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(cuadro);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            excepcion = "";
        } else {
            excepcion = "El cuadro a modificar no se ha encontrado o lo han eliminado";
            throw new Exception(excepcion);
        }
    }

    public void borrar(Context ctx) throws Exception {
        Cuadro cuadro = this.repositorio.buscar(Cuadro.class,
                Integer.parseInt(ctx.pathParam("id")));
        if (cuadro != null) {
            var cosechas = repositorio.buscarTodos(Cosecha.class);
            for (int i = 0; i < cosechas.size(); i++) {
                if (cosechas.get(i).esValido()) {
                    for (var cuad: cosechas.get(i).getCuadros()) {
                        if (cuadro == cuad) {
                            excepcion = "Hay cosecha(s) que fueron realizada(s) en este cuadro";
                            throw new Exception(excepcion);
                        }
                    }
                }
            }
            cuadro.eliminar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(cuadro);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = cuadro.getIdCuadro();
            excepcion = "";
        } else {
            excepcion = "El cuadro a eliminar no se encuentra en el sistema";
            throw new Exception(excepcion);
        }
    }

    public void recuperar(Context ctx) throws Exception {
        Cuadro cuadro = this.repositorio.buscar(Cuadro.class,
                Integer.parseInt(ctx.formParam("id")));
        if (cuadro != null) {
            cuadro.recuperar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(cuadro);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = cuadro.getIdCuadro();
            excepcion = null;
        } else {
            excepcion = "No se puede recuperar el cuadro deseado";
            throw new Exception(excepcion);
        }
    }
}
