package com.mymoviesdb.backend;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FavouriteDAO {
    private EntityManager entityManager;
    private final PersonService personService;
    // set up constructor injection
    @Autowired
    public FavouriteDAO(EntityManager theEntityManager, PersonService personService) {
        entityManager = theEntityManager;
        this.personService = personService;
    }

    public List<Favourite> findMoviesByPerson(Long id) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<Favourite> theQuery =
                currentSession.createQuery("from Favourite where pid=:personid", Favourite.class);
        theQuery.setParameter("personid", id);
        // execute query and get result list
        List<Favourite> favourites = theQuery.getResultList();

        // return the results
        return favourites;
    }

    public void markFavourite(Long pid, Long mid) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        Favourite f = new Favourite(personService.findPersonById(pid), mid);

        // save employee
        currentSession.saveOrUpdate(f);
    }
}
