import java.util.ArrayList;

public class FilmCollection {

    private String name;
    private ArrayList<Film> films;

    public FilmCollection(String name){
        this.name = name;
        this.films = new ArrayList<>();
    }

}
