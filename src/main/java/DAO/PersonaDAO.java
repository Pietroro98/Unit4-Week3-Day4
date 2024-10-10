package DAO;


import entities.Persona;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;





public class PersonaDAO {

    private final EntityManager entityManager;


    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Persona newPersona) {
        try{
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPersona);
        transaction.commit();

        System.out.println("La persona " + newPersona.getNome() + newPersona.getCognome() + "creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Persona findById(String id) {
        Persona found = entityManager.find(Persona.class, (id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
