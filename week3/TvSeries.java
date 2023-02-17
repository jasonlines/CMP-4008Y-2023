// Exercise - see explanation in the comments for Film, but in short - update TvSeries to extend MediaItem.
// To do this, you'll need to update the class declaration to say extends MediaItem, and you'll need to also
// update the fields and constructor of this class too (See Film for an example)
public class TvSeries {

    // fields
    private String name;
    private int yearReleased;
    private int numberOfSeries;
    private String primaryGenre;
    private String secondaryGenre;

    public TvSeries(String name, int yearReleased, int numberOfSeries, String primaryGenre, String secondaryGenre){
        this.name = name;
        this.yearReleased = yearReleased;
        this.numberOfSeries = numberOfSeries;
        this.primaryGenre = primaryGenre;
        this.secondaryGenre = secondaryGenre;
    }

    public void setNumberOfSeries(int updatedNumberOfSeries){
        this.numberOfSeries = updatedNumberOfSeries;
    }

    public String toString(){
        return "The name of this series is " + this.name + " and it has " + this.numberOfSeries + " series";
    }

    public static void main(String[] args){
        TvSeries exampleSeries = new TvSeries("Ted Lasso", 2018, 2, "Comedy", "Sports");
        System.out.println(exampleSeries);

//        Film f = exampleSeries;
    }

}
