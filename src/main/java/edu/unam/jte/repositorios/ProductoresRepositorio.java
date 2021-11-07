package edu.unam.jte.repositorios;

import java.util.List;
import edu.unam.jte.modelos.Productor;

public interface ProductoresRepositorio {

    List<Productor> listar();
    void crear (Productor productor);
    boolean borrar (int idProductor);
    Productor obtener (int id);
    
}