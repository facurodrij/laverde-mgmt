package edu.unam.jte.modelos;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Cosecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Serial")
    private int idCosecha;

    @NotNull
    private boolean valido = true;

    @Positive
    @NotNull
    private float pesoEntrega;

    @PastOrPresent
    @NotNull
    private LocalDate tiempoEntrega;

    @Positive
    @NotNull
    private float pesoRegistro;

    @PastOrPresent
    @NotNull
    private LocalDate tiempoRegistro;

    @ManyToMany(targetEntity = Cuadro.class)
    private List<Cuadro> cuadros = new ArrayList<>();

    @ManyToMany(targetEntity = Empleado.class)
    private List<Empleado> empleados = new ArrayList<>();

    @ManyToOne(targetEntity = Secadero.class)
    @NotNull
    private Secadero secadero;

    public Cosecha(){
        this.pesoEntrega = 0;
        this.tiempoEntrega = LocalDate.now();
        this.pesoRegistro = 0;
        this.tiempoRegistro = LocalDate.now();
        this.secadero = null;
    }

    public Cosecha(float pesoEntrega, LocalDate tiempoEntrega, float pesoRegistro, LocalDate tiempoRegistro, List<Cuadro> cuadros, List<Empleado> empleados, Secadero secadero) {
        this.pesoEntrega = pesoEntrega;
        this.tiempoEntrega = tiempoEntrega;
        this.pesoRegistro = pesoRegistro;
        this.tiempoRegistro = tiempoRegistro;
        this.cuadros = cuadros;
        this.empleados = empleados;
        this.secadero = secadero;
    }

    public int getIdCosecha() {
        return this.idCosecha;
    }

    public float getPesoEntrega() {
        return this.pesoEntrega;
    }

    public LocalDate getTiempoEntrega() {
        return this.tiempoEntrega;
    }

    public float getPesoRegistro() {
        return this.pesoRegistro;
    }

    public LocalDate getTiempoRegistro() {
        return this.tiempoRegistro;
    }

    public List<Cuadro> getCuadros() {
        return this.cuadros;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public Secadero getSecadero() {
        return this.secadero;
    }

    public float getDiferenciaPeso() {
        return this.pesoEntrega - this.pesoRegistro;
    }

    public void setPesoEntrega(float pesoEntrega) {
        this.pesoEntrega = pesoEntrega;
    }

    public void setTiempoEntrega(LocalDate tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public void setPesoRegistro(float pesoRegistro) {
        this.pesoRegistro = pesoRegistro;
    }

    public void setTiempoRegistro(LocalDate tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }

    public void setCuadros(List<Cuadro> cuadros) {
        this.cuadros = cuadros;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setSecadero(Secadero secadero) {
        this.secadero = secadero;
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

    /*
     * @Override public String toString() { return "Cosecha [empleado=" + empleado +
     * ", fecha=" + fecha + ", idCosecha=" + idCosecha + ", cuadros=" + cuadros +
     * ", secadero=" + secadero + "]"; }
     */
}
