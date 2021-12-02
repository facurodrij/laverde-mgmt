package edu.unam.jte.paginas;

import java.util.List;

import edu.unam.jte.modelos.*;

public class ModeloCosecha extends ModeloExcepcion {
    public Cosecha cosecha;

    ModeloEmpleados emp = new ModeloEmpleados();
    public List<Empleado> empleados = emp.empleados;

    ModeloCuadros cua = new ModeloCuadros();
    public List<Cuadro> cuadros = cua.cuadros;

    ModeloSecaderos sec = new ModeloSecaderos();
    public List<Secadero> secaderos = sec.secaderos;
}