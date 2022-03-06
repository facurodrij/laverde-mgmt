package edu.unam.jte.modelos;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import org.geolatte.geom.*;

@Entity
public class Cuadro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Serial")
    private int idCuadro;

    @NotNull
    private boolean valido = true;

    @NotNull
    @Column(columnDefinition = "Geometry(LineString, 4326)")
    private LineString<G2D> puntos;

    @NotNull
    @NotBlank
    private String descripcion;

    @ManyToOne
    @NotNull
    private Lote lote;

    @ManyToMany(targetEntity = Cosecha.class, mappedBy = "cuadros")
    private List<Cosecha> cosechas;

    /*
     * Aunque este constructor no deba usarse, es necesario para el funcionamiento del sistema;
     * sino se obtendrá un error a causa de la inexistencia del constructor sin argumentos.
     */
    public Cuadro() {
        this.lote = new Lote();
        this.puntos = new LineString<>(WGS84);
        this.descripcion = new String(); // Esto evita el uso indebido de este constructor
        this.cosechas = new ArrayList<>();
    }

    public Cuadro(Lote lote, LineString<G2D> puntos, @NotBlank String descripcion) {
        this.lote = lote;
        this.puntos = puntos;
        this.descripcion = descripcion;
        this.cosechas = new ArrayList<>();
    }

    public int getIdCuadro() {
        return this.idCuadro;
    }

    public int getCantidadPuntos() {
        return this.puntos.getNumPositions();
    }

    public G2D getPuntoN(int numero) {
        return this.puntos.getPositionN(numero);
    }

    public LineString<G2D> getPuntos() {
        return this.puntos;
    }

    public Lote getLote() {
        return this.lote;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public List<Cosecha> getCosechas() {
        return this.cosechas;
    }

    public void setPuntos(LineString<G2D> puntos) {
        this.puntos = puntos;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public final String toString() {
        return Integer.toString(this.idCuadro) + ". " + this.puntos.toString();
    }
}
