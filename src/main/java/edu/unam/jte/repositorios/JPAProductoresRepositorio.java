package edu.unam.jte.repositorios;

import edu.unam.jte.modelos.Productor;
import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class JPAProductoresRepositorio implements ProductoresRepositorio {

    private final EntityManagerFactory emf;

    public JPAProductoresRepositorio(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Productor> listar() {
        var em = emf.createEntityManager();
        var cb = em.getCriteriaBuilder();
        // se crea un objeto de consulta que devolvera objetos de Productor
        var consulta = cb.createQuery(Productor.class);
        // definimos el origen de la consulta (FROM)
        var origen = consulta.from(Productor.class);
        consulta.select(origen);
        TypedQuery<Productor> query = em.createQuery(consulta);
        var productores = query.getResultList();
        em.close();
        return productores;
    }

    @Override
    public Productor obtener(int id) {
        var em = emf.createEntityManager();
        var productor = em.find(Productor.class, id);
        em.close();
        return productor;
    }

    @Override
    public void crear(Productor productor) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(productor);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Productor productor) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(productor);
        em.getTransaction().commit();
        em.close();
    }    

    @Override
    public boolean borrar(int id) {

        var em = emf.createEntityManager();
        var productor = em.find(Productor.class, id);
        try {
            if (productor != null) {
                em.getTransaction().begin();
                em.remove(productor);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println("No se puede borrar productor");
        }
        em.close();
        return (productor != null);
    }

}
