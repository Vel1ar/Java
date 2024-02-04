package myHomework.homework9.task4;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String date;
    private List<Movie> films;

    public Company(String name, String date) {
        this.name = name;
        this.date = date;
        this.films = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Movie> addMovie(String name, int rating, String gerne, String country, String oscar) {
        films.add(new Movie(name, rating, gerne, country, oscar));
        return films;
    }

    @Override
    public String toString() {
        return "{" + name + "} : {" + films + "}";
    }
}
