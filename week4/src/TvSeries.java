public class TvSeries extends MediaItem{

    // fields
    private int numberOfSeries;

    // exercise - just as with Film, update the constructor to throw an exception if the number
    // of series is less than 1. It would be a good idea to make your own Exception subclass
    // for this too (i.e. something like IllegalNumberOfSeriesException), and then you could
    // try catching both this type of Exception and the IllegalDurationException within the same
    // try-catch structure
    public TvSeries(String name, int yearReleased, int numberOfSeries, String primaryGenre, String secondaryGenre){
        super(name,yearReleased,primaryGenre,secondaryGenre);
        this.yearReleased = yearReleased;
        this.numberOfSeries = numberOfSeries;
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
    }

}
