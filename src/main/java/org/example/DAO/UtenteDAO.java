package org.example.DAO;

import org.example.entities.ElementoCatalogo;
import org.example.entities.Utente;

import javax.persistence.EntityManager;

public class UtenteDAO {
    private static EntityManager em;

    public UtenteDAO(EntityManager em) { UtenteDAO.em = em;
    }

    public static void save_utente(Utente u) {
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
    public void get_utenteById (long id){
        em.find(Utente.class, id);
    }

    public void remove_utente (Utente u){
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }
}
