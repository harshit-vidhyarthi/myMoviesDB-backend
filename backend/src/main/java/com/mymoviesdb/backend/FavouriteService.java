package com.mymoviesdb.backend;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FavouriteService {
    private FavouriteDAO favouriteDAO;

    @Autowired
    public FavouriteService(FavouriteDAO thefavouriteDAO) {
        favouriteDAO = thefavouriteDAO;
    }

    @Transactional
    public List<Favourite> findMoviesByPerson(Long id) {
        return favouriteDAO.findMoviesByPerson(id);
    }

    @Transactional
    public void markFavourite(Long pid, Long mid) {
        favouriteDAO.markFavourite(pid, mid);
    }
}
