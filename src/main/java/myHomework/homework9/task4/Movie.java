package myHomework.homework9.task4;

public class Movie {
    private String name;
    private int rating;
    private String gerne;
    private String country;
    private String oscar;

    public Movie(String name, int rating, String gerne, String country, String oscar) {
        this.name = name;
        this.rating = rating;
        this.gerne = gerne;
        this.country = country;
        this.oscar = oscar;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getGerne() {
        return gerne;
    }

    public String getCountry() {
        return country;
    }

    public String getOscar() {
        return oscar;
    }

    @Override
    public String toString() {
        return "{"+name+"}";
    }
}
