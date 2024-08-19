package com.example.librarysystem;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private Status readStatus;
    private double rating; //out of 5
    private final ArrayList<String> genres;
    private String notes;

    public Book(String title, String author, Status readStatus, double rating, ArrayList<String> genres, String notes) {
        this.title = title;
        this.author = author;
        this.readStatus = readStatus;
        if(rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        }
        else {
            System.err.println("Rating must be between 0.0 and 5.0, please try again");
        }
        this.genres = genres;
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Status readStatus) {
        this.readStatus = readStatus;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if(rating <= 5.0 && rating >= 0.0) {
            this.rating = rating;
        }
        else {
            System.err.println("Rating must be between 5.0 and 0.0, please try again");
        }
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void addGenre(ArrayList<String> genres) {
        this.genres.addAll(genres);
    }

    public void removeGenre(ArrayList<String> genres) {
        this.genres.removeAll(genres);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
