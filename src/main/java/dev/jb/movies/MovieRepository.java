package dev.jb.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    // we need to create a method to search for a movie by only its imdbId
    // we will use automatic queries

    // still may return null so we use optional
    Optional<Movie> findMovieByImdbId(String imdbId); // just by naming findMovieByImdbId spring
    // mongodb will know what we are looking for.
    // You can do dynamic queries like this using any property name in the model class (if
    // they're unique).

}
