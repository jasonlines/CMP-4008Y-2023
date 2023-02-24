// exercise - MediaItem should be abstract since we will only want to make subclass objects (e.g. Film, TvSeries)
public class MediaItem {

    protected String name;
    protected int yearReleased;
    private String primaryGenre;   // exercise - change primaryGenre to use an enum instead of a String
    private String secondaryGenre; // exercise - as above, secondary genre should also be changed from a String

    public MediaItem(String name, int yearReleased, String primaryGenre, String secondaryGenre){
        this.name = name;
        this.yearReleased = yearReleased;
        this.primaryGenre = primaryGenre;
        this.secondaryGenre = secondaryGenre;
    }

}
