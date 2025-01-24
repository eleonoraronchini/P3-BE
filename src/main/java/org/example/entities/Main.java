package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class Main 
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto3");
    private static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {

    }
}
