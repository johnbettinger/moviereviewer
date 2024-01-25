package dev.jb.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // means instantiate the following class for us
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    // THIS WAS FOR FINDING BY OBJECTID BUT WE DONT WANT TO EXPOSE THAT SO WE USE IMDBID
//    public Optional<Movie> singleMovie(ObjectId id) {
//        return movieRepository.findById(id); //findById(id) may not find the movie we want and
//        // can return null. Therefore, we change the return type to Optional<Movie> in case its null
//    }

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
