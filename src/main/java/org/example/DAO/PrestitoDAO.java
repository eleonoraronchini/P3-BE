package org.example.DAO;

import org.example.entities.Prestito;

import javax.persistence.EntityManager;

public class PrestitoDAO {
    private static EntityManager em;

    public PrestitoDAO(EntityManager em) {
        PrestitoDAO.em = em;
    }

    public static void save_prestito(Prestito p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    public void get_prestitoById (long id){
        em.find(Prestito.class, id);
    }

    public void remove_prestito (Prestito p){
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
}
