package DAO;

import entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;




public class EventsDAO {
    private final EntityManager em;
    public EventsDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    public void delete(String eventoId) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        Event found = entityManager.find(Event.class, UUID.fromString(eventoId));
//        if (found != null) {
//            entityManager.remove(found);
//            transaction.commit();
//            System.out.println("L'evento con ID " + eventoId + " è stato eliminato!");
//        } else {
//            transaction.commit();
//            throw new NotFoundException(eventoId);
//        }
//    }
}
