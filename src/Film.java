// note - I have recorded a short (30 min) video while writing this code, so please have a look at that if you have
// any questions about what is covered below. I'll also repeat some of this in the Week 2 live lecture so feel free
// to ask questions in advance, and I can cover them there too
public class Film {

    // fields
    private String name;
    private int yearReleased;
    private int runTime;
    private String director;
    private String primaryGenre;
    private String secondaryGenre;

    // constructor
    public Film(String name, int yearReleased, int runTime, String director, String primaryGenre, String secondaryGenre){
        this.name = name;
        this.yearReleased = yearReleased;
        this.runTime = runTime;
        this.director = director;
        this.primaryGenre = primaryGenre;
        this.secondaryGenre = secondaryGenre;
    }

    // accessors/mutators
    public void setDirector(String newDirector){
        this.director = newDirector;
    }

    public String getDirector(){
        return this.director;
    }

    // class-specific methods - to go here later

    public String toString(){
        return "This film is called " + this.name + " and it is " + runTime + " minutes long. It was directed by " + director;

    }

    // test harness
    public static void main(String[] args){
        // The Godfather,1972,175,Francis Ford Coppola,Crime,Drama
        Film theFirstFilm = new Film("The Godfather", 1972, 175, "Francis Ford Coppola", "Crime", "Drama");
        System.out.println(theFirstFilm.toString());

        Film theSecondFilm = new Film("The Dark Knight",2008,152,"Christopher Nolan","Action","Thriller");
        System.out.println(theSecondFilm);
    }

}
