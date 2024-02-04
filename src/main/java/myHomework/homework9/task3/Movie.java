package myHomework.homework9.task3;

public class Movie {
    private String name;
    private int rating;
    private String gerne;
    private String country;
    private String oscar;

    public Movie(String name, int rating, String gerne, String country, String oscar) {
        this.name = name;
        if (rating > 10) {
            this.rating = 10;
        } else {
            if (rating < 0) {
                this.rating = 0;
            } else this.rating = rating;
        }
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
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", gerne='" + gerne + '\'' +
                ", country='" + country + '\'' +
                ", oscar='" + oscar + '\'' +
                '}';
    }
}
