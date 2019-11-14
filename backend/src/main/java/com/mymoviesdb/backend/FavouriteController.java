package com.mymoviesdb.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class FavouriteController {
    private FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService thefavouriteService) {
        favouriteService = thefavouriteService;
    }

    @GetMapping("/{pid}")
    public List<Favourite> findMoviesByPerson(@PathVariable Long pid) {
        List<Favourite> favourites = favouriteService.findMoviesByPerson(pid);

        if (favourites == null) {
            throw new RuntimeException("Person id not found - " + pid);
        }

        return favourites;
    }

    @PostMapping("/{pid}/{mid}")
    public void markFavourite(@PathVariable Long pid, @PathVariable Long mid) {

        favouriteService.markFavourite(pid, mid);

    }
}
