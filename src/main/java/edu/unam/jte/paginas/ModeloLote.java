package edu.unam.jte.paginas;

import java.util.ArrayList;
import java.util.List;

import edu.unam.jte.modelos.Lote;
import edu.unam.jte.modelos.Productor;

public class ModeloLote extends ModeloIndividual {
    public Lote lote;

    public List<Productor> productores = new ArrayList<>();
}