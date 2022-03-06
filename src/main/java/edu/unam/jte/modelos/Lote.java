package edu.unam.jte.modelos;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import org.geolatte.geom.*;

@Entity
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Serial")
    private int idLote;

    @NotNull
    private boolean valido = true;

    @NotNull
    @Column(columnDefinition = "Geometry(LineString, 4326)")
    private LineString<G2D> coordenadas;

    @NotNull
    @ManyToOne
    private Productor productor;

    @OneToMany(targetEntity = Cuadro.class, mappedBy = "lote")
    private List<Cuadro> cuadros = new ArrayList<>();

    public Lote() {
        this.idLote = 0;
        this.coordenadas = new LineString<>(WGS84);
        this.productor = new Productor();
    }

    public Lote(LineString<G2D> coordenadas, Productor productor)
    {
        this.coordenadas = coordenadas;
        this.productor = productor;
    }

    public int getIdLote() {
        return this.idLote;
    }

    public LineString<G2D> getCoordenadas() {
        return this.coordenadas;
    }

    public G2D getAbajoIzquierda() {
        return this.coordenadas.getPositionN(0);
    }

    public String getAbajoIzquierda_toString() {
        G2D punto = this.coordenadas.getPositionN(0);
        return "(" + Double.toString(punto.getLon()) + "; " +
            Double.toString(punto.getLat()) + ")";
    }

    public G2D getAbajoDerecha() {
        return this.coordenadas.getPositionN(1);
    }

    public String getAbajoDerecha_toString() {
        G2D punto = this.coordenadas.getPositionN(1);
        return "(" + Double.toString(punto.getLon()) + "; " +
            Double.toString(punto.getLat()) + ")";
    }

    public G2D getArribaDerecha() {
        return this.coordenadas.getPositionN(2);
    }

    public String getArribaDerecha_toString() {
        G2D punto = this.coordenadas.getPositionN(2);
        return "(" + Double.toString(punto.getLon()) + "; " +
            Double.toString(punto.getLat()) + ")";
    }

    public G2D getArribaIzquierda() {
        return this.coordenadas.getPositionN(3);
    }

    public String getArribaIzquierda_toString() {
        G2D punto = this.coordenadas.getPositionN(3);
        return "(" + Double.toString(punto.getLon()) + "; " +
            Double.toString(punto.getLat()) + ")";
    }

    public Productor getProductor() {
        return productor;
    }

    public List<Cuadro> getCuadros() {
        return cuadros;
    }

    public void setCoordenadas(LineString<G2D> coordenadas)
    {
        this.coordenadas = coordenadas;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public boolean esValido() {
        return this.valido;
    }

    public boolean esInvalido() {
        return !this.valido;
    }

    public void eliminar() {
        this.valido = false;
    }

    public void recuperar() {
        this.valido = true;
    }

    @Override
    public final String toString() {
        return Integer.toString(this.idLote) + ": [" + this.getAbajoIzquierda_toString() + ", " +
            this.getArribaDerecha_toString() + "]";
    }
}