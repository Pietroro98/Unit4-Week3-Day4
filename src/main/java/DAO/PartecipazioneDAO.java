package DAO;

import entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;




public class PartecipazioneDAO {
    private final EntityManager entityManager;


    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Partecipazione newPartecipazione) {
        try{
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPartecipazione);
        transaction.commit();
        System.out.println("Partecipazione all'evento " + newPartecipazione.getEvent() + " per la persona " + newPartecipazione.getPersona().getCognome() + ", creata");
    } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Partecipazione findById(long id) {
        return entityManager.find(Partecipazione.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = entityManager.getTransaction();
            t.begin();
            Partecipazione found = entityManager.find(Partecipazione.class, id);
            if (found != null) {
                entityManager.remove(found);
                t.commit();
                System.out.println("Partecipazione cancellata");
            } else System.out.println("Partecipazione non trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

