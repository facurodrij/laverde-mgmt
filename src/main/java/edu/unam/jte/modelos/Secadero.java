package edu.unam.jte.modelos;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Secadero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Serial")
    private int idSecadero;

    @NotNull
    private boolean valido = true;

    @Column(nullable = false, unique = true)
    private long cuit;
    
    @Column(nullable = false)
    private String razonSocial;

    @OneToMany(targetEntity = Cosecha.class, mappedBy = "secadero")
    private List<Cosecha> cosechas;

    public Secadero() {
        this.setCuit(0);
        this.setRazonSocial("");
        ;
        this.cosechas = new ArrayList<>();
    }

    public Secadero(long cuit, String razonSocial) {
        this.setCuit(cuit);
        this.setRazonSocial(razonSocial);
        this.cosechas = new ArrayList<>();
    }

    public Secadero(long cuit, String razonSocial, List<Cosecha> cosechas) {
        this.setCuit(cuit);
        this.setRazonSocial(razonSocial);
        this.setCosechas(cosechas);
    }

    public int getIdSecadero() {
        return this.idSecadero;
    }

    public long getCuit() {
        return this.cuit;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public List<Cosecha> getCosechas() {
        return this.cosechas;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setCosechas(List<Cosecha> cosechas) {
        this.cosechas = cosechas;
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
        return Integer.toString(this.getIdSecadero()) + ". " + Long.toString(this.getCuit()) + ", "
                + this.getRazonSocial();
    }
}
