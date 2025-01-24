package org.example.DAO;

import org.example.entities.ElementoCatalogo;

import javax.persistence.EntityManager;
import java.util.List;

public class ElementoCatalogoDAO {
    private static EntityManager em;

    public ElementoCatalogoDAO(EntityManager em) {
        ElementoCatalogoDAO.em = em;
    }

    public static void save_elementoCatalogo(ElementoCatalogo e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    public static ElementoCatalogo get_elementoCatalogoById(int id){
        em.find(ElementoCatalogo.class, id);
        return null;
    }


    public void remove_elementoCatalogo (ElementoCatalogo e){
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
}
