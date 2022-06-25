package aula12;

public class Movie implements Comparable<Movie> {
    
    private String name;
    private double score;
    private String rating;
    private String genre;
    private int r_time;

    public Movie(String name, double score, String rating, String genre, int r_time) {
        this.name = name;
        this.score = score;
        this.rating = rating;
        this.genre = genre;
        this.r_time = r_time;
    }

    public String getName() {return this.name;}
    
    public double getScore() {return this.score;}
    
    public String getRating() {return this.rating;}
    
    public String getGenre() {return this.genre;}
    
    public int getR_time() {return this.r_time;}


    public void setName(String name) {this.name = name;}

    public void setScore(double score) {this.score = score;}

    public void setRating(String rating) {this.rating = rating;}

    public void setGenre(String genre) {this.genre = genre;}

    public void setR_time(int r_time) {this.r_time = r_time;}

    @Override 
    public int compareTo(Movie m) {
        return name.compareToIgnoreCase(m.getName());
    }

    @Override
    public String toString() { 
        return String.format("Name: %20s\tScore: %.2f\tRating: %s\tGenre: %s\tRunning Time: %d", this.name, this.score, this.rating, this.genre, this.r_time);
    }
}