package edu.unam.jte.modelos;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Productor {

    /*
     * Un ID es necesario en caso de que el CUIT/CUIL ingresado haya sido erroneo,
     * el ID va a seguir permitiendo identificar de forma unica el registro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Serial")
    private int idProductor;

    @NotNull
    private boolean valido = true;

    @NotNull
    @Column(unique = true)
    private long cuit;

    @NotNull
    @NotBlank
    @Size(max=50)
    private String apellidos;

    @NotNull
    @NotBlank
    @Size(max=50)
    private String nombres;

    @OneToMany(targetEntity = Lote.class, mappedBy = "productor")
    private List<Lote> lotes = new ArrayList<>();

    public Productor() {
        this.setCuit((long) 0);
        this.setApellidos("");
        this.setNombres("");
    }

    /* Todos los argumentos son requeridos para dar de alta un Productor */
    public Productor(long cuit, String apellidos, String nombres) {
        this.setCuit(cuit);
        this.setApellidos(apellidos);
        this.setNombres(nombres);
    }

    public int getIdProductor() {
        return idProductor;
    }

    public void setIdProductor(int idProductor) {
        this.idProductor = idProductor;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }

    public long getCuit() {
        return this.cuit;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getNombres() {
        return this.nombres;
    }

    public List<Lote> getLotes() {
        return this.lotes;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public int hashCode() {
        long resultado = 0;
        for (int i = 10; i > 0; i--) {
            resultado += ((cuit % (10 ^ i)) / (10 ^ (i - 1)));
        }
        return (int) resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Productor other = (Productor) obj;
        if (cuit != other.cuit)
            return false;
        return true;
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
        return Integer.toString(this.getIdProductor()) + "- CUIT: " + Long.toString(this.getCuit())
                + ". Nombre completo: " + this.getApellidos() + ", " + this.getNombres();
    }
}
