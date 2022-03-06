package edu.unam.jte.modelos;

import java.util.*;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Serial")
    private int idEmpleado;

    @NotNull
    private boolean valido = true;

    @ManyToMany(targetEntity = Cosecha.class, mappedBy = "empleados")
    private List<Cosecha> cosechas;

    @Column(nullable = false, unique = true)
    private String legajo;

    @Column(nullable = false, unique = true)
    private long dni;

    @Column(nullable = false, unique = true)
    private long cuil;

    @NotNull
    @NotBlank
    @Size(max=50)
    private String apellidos;

    @NotNull
    @NotBlank
    @Size(max=50)
    private String nombres;

    @NotNull
    @PastOrPresent
    private LocalDate ingreso;

    @NotNull
    @Past
    private LocalDate nacimiento;

    public Empleado() {
        this.setLegajo("");
        this.setDni((long) 0);
        this.setApellidos("");
        this.setNombres("");
        this.setIngreso(LocalDate.now());
        this.setNacimiento(LocalDate.now());
        this.setCuil((long) 0);
    }

    public Empleado(String legajo, long dni, String apellidos, String nombres, LocalDate ingreso, LocalDate nacimiento,
            long cuil) {
        this.setLegajo(legajo);
        this.setDni(dni);
        this.setApellidos(apellidos);
        this.setNombres(nombres);
        this.setIngreso(ingreso);
        this.setNacimiento(nacimiento);
        this.setCuil(cuil);
    }

    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public List<Cosecha> getCosechas() {
        if (this.cosechas == null) {
            this.cosechas = new ArrayList<>();
        }
        return this.cosechas;
    }

    public String getLegajo() {
        return this.legajo;
    }

    public long getDni() {
        return this.dni;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getNombres() {
        return this.nombres;
    }

    public LocalDate getIngreso() {
        return this.ingreso;
    }

    public LocalDate getNacimiento() {
        return this.nacimiento;
    }

    public long getCuil() {
        return this.cuil;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public void setDni(long i) {
        this.dni = i;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setIngreso(LocalDate ingreso) {
        this.ingreso = ingreso;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setCuil(long i) {
        this.cuil = i;
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
        return Integer.toString(this.getIdEmpleado()) + ". " + Long.toString(this.getDni()) + " " + this.getApellidos()
                + ", " + this.getNombres();
    }
}
