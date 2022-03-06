package edu.unam.jte.controladores;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.geolatte.geom.PositionSequenceBuilders.*;

import io.javalin.http.Context;

import java.util.Collections;

import edu.unam.jte.modelos.*;
import edu.unam.jte.paginas.*;
import edu.unam.jte.repositorios.Repositorio;

import org.geolatte.geom.*;

public class LotesControlador {
    private Repositorio repositorio;

    private String excepcion = null;

    private int eliminado = 0;

    public LotesControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Esta función permite crear un rectángulo de forma adecuada a través de dos
     * puntos.
     * 
     * @param punto1 es un vector que representa un punto, donde [0] sería
     *               la coordenada X y [1] se trata la coordenada Y.
     * @param punto2 es otro vector que representa un punto, donde [0] sería
     *               la coordenada X y [1] se trata la coordenada Y.
     * @return Devuelve la figura formada por las coordenadas creadas.
     */
    private LineString<G2D> crearCoordenadas(double[] punto1, double[] punto2) {
        double abajo = punto1[1] < punto2[1] ? punto1[1] : punto2[1];
        double izquierda = punto1[0] < punto2[0] ? punto1[0] : punto2[0];
        double arriba = punto1[1] > punto2[1] ? punto1[1] : punto2[1];
        double derecha = punto1[0] > punto2[0] ? punto1[0] : punto2[0];
        PositionSequenceBuilder<G2D> constructor = fixedSized(5, G2D.class);
        constructor.add(izquierda, abajo);
        constructor.add(derecha, abajo);
        constructor.add(derecha, arriba);
        constructor.add(izquierda, arriba);
        constructor.add(izquierda, abajo);
        return new LineString<>(constructor.toPositionSequence(), WGS84);
    }

    public void listar(Context ctx) {
        var modelo = new ModeloLotes();
        modelo.eliminado = eliminado;
        modelo.excepcion = excepcion;
        eliminado = 0;
        excepcion = null;
        modelo.lotes = this.repositorio.buscarTodos(Lote.class);
        for (int i = 0; i < modelo.lotes.size(); i++) {
            if (modelo.lotes.get(i).esInvalido()) {
                modelo.lotes.remove(i);
            }
        }
        ctx.render("lote/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) {
        var modelo = new ModeloLote();
        modelo.excepcion = excepcion;
        excepcion = null;
        modelo.productores = this.repositorio.buscarTodos(Productor.class);
        for (int i = 0; i < modelo.productores.size(); i++) {
            if (modelo.productores.get(i).esInvalido()) {
                modelo.productores.remove(i);
            }
        }
        ctx.render("lote/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws Exception {
        double punto1[] = new double[2];
        double punto2[] = new double[2];
        punto1[0] = Double.parseDouble(ctx.formParam("punto1X"));
        punto1[1] = Double.parseDouble(ctx.formParam("punto1Y"));
        punto2[0] = Double.parseDouble(ctx.formParam("punto2X"));
        punto2[1] = Double.parseDouble(ctx.formParam("punto2Y"));
        if (punto1[0] == punto2[0] || punto1[1] == punto2[1]) {
            excepcion = "Las coordenadas provistas no forman un lote, sino una línea";
            throw new Exception(excepcion);
        }
        LineString<G2D> coordenadas = crearCoordenadas(punto1, punto2);
        var productor = this.repositorio.buscar(Productor.class,
                Integer.parseInt(ctx.formParam("productor")));
        Lote lote = new Lote(coordenadas, productor);
        var lotes = this.repositorio.buscarTodos(Lote.class);
        Box<G2D> caja;
        for (var otro : lotes) {
            caja = lote.getCoordenadas().getBoundingBox().intersect(
                    otro.getCoordenadas().getBoundingBox());
            if (!caja.isEmpty() &&
                    (caja.lowerLeft().getLat() != caja.upperRight().getLat()) &&
                    (caja.lowerLeft().getLon() != caja.upperRight().getLon()) && otro.esValido()) {
                excepcion = "El lote a registrar cruza su territorio con otro existente";
                throw new Exception(excepcion);
            }
        }
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(lote);
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
        var modelo = new ModeloLote();
        modelo.lote = this.repositorio.buscar(Lote.class, Integer.parseInt(ctx.pathParam("id")));
        if (modelo.lote != null) {
            if (modelo.lote.esValido()) {
                modelo.excepcion = excepcion;
                excepcion = null;
                modelo.productores = this.repositorio.buscarTodos(Productor.class);
                for (int i = 0; i < modelo.productores.size(); i++) {
                    if (modelo.productores.get(i).esInvalido()) {
                        modelo.productores.remove(i);
                    }
                }
                ctx.render("lote/editar.jte", Collections.singletonMap("modelo", modelo));
                return;
            }
            excepcion = "El lote al que intentó acceder fue eliminado anteriormente";
        } else {
            excepcion = "El lote al que intentó acceder no existe";
        }
        ctx.redirect("/lotes");
    }

    public void actualizar(Context ctx) throws Exception {
        double punto1[] = new double[2];
        double punto2[] = new double[2];
        punto1[0] = Double.parseDouble(ctx.formParam("punto1X"));
        punto1[1] = Double.parseDouble(ctx.formParam("punto1Y"));
        punto2[0] = Double.parseDouble(ctx.formParam("punto2X"));
        punto2[1] = Double.parseDouble(ctx.formParam("punto2Y"));
        var productor = this.repositorio.buscar(Productor.class,
                Integer.parseInt(ctx.formParam("productor")));
        Lote lote = this.repositorio.buscar(Lote.class, Integer.parseInt(ctx.pathParam("id")));
        if (lote != null) {
            LineString<G2D> coordenadas = crearCoordenadas(punto1, punto2);
            var cuadros = repositorio.buscarTodos(Cuadro.class);
            for (int i = 0; i < cuadros.size(); i++) {
                if (cuadros.get(i).esValido() &&
                    lote.getIdLote() == cuadros.get(i).getLote().getIdLote() &&
                    !(coordenadas.getBoundingBox().contains(
                        cuadros.get(i).getPuntos().getBoundingBox())))
                {
                    excepcion = "El lote no abarca a todos sus cuadros";
                    throw new Exception(excepcion);
                }
            }
            var lotes = this.repositorio.buscarTodos(Lote.class);
            Box<G2D> caja;
            for (var otro : lotes) {
                if (otro.esValido() && lote.getIdLote() != otro.getIdLote()) {
                    caja = coordenadas.getBoundingBox().intersect(
                            otro.getCoordenadas().getBoundingBox());
                    if (!caja.isEmpty() &&
                            (caja.lowerLeft().getLat() != caja.upperRight().getLat()) &&
                            (caja.lowerLeft().getLon() != caja.upperRight().getLon())) {
                        excepcion = "El lote a modificar cruza su territorio con otro existente";
                        throw new Exception(excepcion);
                    }
                }
            }
            lote.setCoordenadas(coordenadas);
            lote.setProductor(productor);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(lote);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            excepcion = "";
        } else {
            excepcion = "El lote a modificar no se ha encontrado o lo han eliminado";
            throw new Exception(excepcion);
        }
    }

    public void borrar(Context ctx) throws Exception {
        Lote lote = this.repositorio.buscar(Lote.class, Integer.parseInt(ctx.pathParam("id")));
        if (lote != null) {
            var cuadros = repositorio.buscarTodos(Cuadro.class);
            for (int i = 0; i < cuadros.size(); i++) {
                if (cuadros.get(i).esValido() && lote == cuadros.get(i).getLote()) {
                    excepcion = "Hay cuadro(s) que pertenece(n) a este lote";
                    throw new Exception(excepcion);
                }
            }
            lote.eliminar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(lote);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                String error = e.getCause().getCause().getMessage();
                excepcion = error;
                throw new Exception(error);
            }
            eliminado = lote.getIdLote();
            excepcion = "";
        } else {
            excepcion = "El lote a eliminar no se encuentra en el sistema";
            throw new Exception(excepcion);
        }
    }

    public void recuperar(Context ctx) throws Exception {
        Lote lote = this.repositorio.buscar(Lote.class, Integer.parseInt(ctx.formParam("id")));
        if (lote != null) {
            lote.recuperar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(lote);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                String error = e.getCause().getCause().getMessage();
                excepcion = error;
                throw new Exception(error);
            }
            eliminado = lote.getIdLote();
            excepcion = null;
        } else {
            excepcion = "No se puede recuperar el lote deseado";
            throw new Exception(excepcion);
        }
    }
}
