package edu.unam.jte.repositorios;

import java.util.List;
import edu.unam.jte.modelos.Productor;

public interface ProductoresRepositorio {

    List<Productor> listar();
    void crear (Productor productor);
    boolean borrar (int id);
    Productor obtener (int id);
    void actualizar (Productor productor);
    
}