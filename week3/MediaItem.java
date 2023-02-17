// exercise - MediaItem should be abstract since we will only want to make subclass objects (e.g. Film, TvSeries)
public class MediaItem {

    protected String name;
    protected int yearReleased;
    private String primaryGenre;
    private String secondaryGenre;

    public MediaItem(String name, int yearReleased, String primaryGenre, String secondaryGenre){
        this.name = name;
        this.yearReleased = yearReleased;
        this.primaryGenre = primaryGenre;
        this.secondaryGenre = secondaryGenre;
    }

}
