package edu.unam.jte.paginas;

import java.util.ArrayList;
import java.util.List;

import edu.unam.jte.modelos.*;

public class ModeloCosecha extends ModeloIndividual {
    public Cosecha cosecha;

    public List<Empleado> empleados = new ArrayList<>();

    public List<Cuadro> cuadros = new ArrayList<>();

    public List<Secadero> secaderos = new ArrayList<>();
}