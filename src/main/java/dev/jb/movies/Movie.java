package dev.jb.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data //from lombok, takes care of getter, setter, and toString methods
@AllArgsConstructor // for constructor that takes all the private fields as arguments
@NoArgsConstructor // constructor for no parameters (default constructor?)
public class Movie {

    @Id
    private ObjectId id; // instead of just having the imdbId, we have ObjectId as the actual
    // code for each movie
    private String imdbId; // we dont want to expose the actual ObjectId in the http request so
    // we use the imdbId to search for movies instead
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;

    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;

}
