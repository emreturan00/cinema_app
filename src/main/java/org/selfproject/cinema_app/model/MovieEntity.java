package org.selfproject.cinema_app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageLocation;
    private String cast;
    private String director;
    private String genre;
    private String releaseDate;
    private Float rating;
    private String duration;


    public MovieEntity(String name, String imageLocation, String cast, String director, String genre, String releaseDate, Float rating, String duration) {
        this.name = name;
        this.imageLocation = imageLocation;
        this.cast = cast;
        this.director = director;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.duration = duration;
    }

    public MovieEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }



    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                ", cast='" + cast + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", duration='" + duration + '\'' +
                '}';
    }
}
