public class Movie {
    private String title;
    private String cast;
    private String director;
    private String overview;
    private int runtime;
    private int userRating;

    public Movie (String title, String cast, String director, String overview, int runtime, int userRating) {
        this.title = title;
        this.cast = cast;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.userRating = userRating;
    }

    public String getTitle () {
        return title;
    }

    public String cast () {
        return cast;
    }

    public String director () {
        return director;
    }

    public String getOverview () {
        return overview;
    }

    public int getRuntime () {
        return runtime;
    }

    public int getUserRating () {
        return userRating;
    }
}