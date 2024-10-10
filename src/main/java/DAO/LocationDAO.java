package DAO;

import entities.Location;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;




public class LocationDAO {

    private final EntityManager entityManager;


    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Location newlocation) {
        try {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newlocation);
        transaction.commit();
        System.out.println("La location " + newlocation.getNome() + " è stata creata!");
    } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Location findById(String locationId) {
        Location found = entityManager.find(Location.class, locationId);
        if (found == null) throw new NotFoundException(locationId);
        return found;
    }

}
