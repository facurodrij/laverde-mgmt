package edu.unam.jte.paginas;

import java.util.ArrayList;
import java.util.List;

import edu.unam.jte.modelos.Lote;
import edu.unam.jte.modelos.Cuadro;

public class ModeloCuadro extends ModeloIndividual {
    public Cuadro cuadro;

    public List<Lote> lotes = new ArrayList<>();
}
