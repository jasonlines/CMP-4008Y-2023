public class Film extends MediaItem{

    // fields
    private int runtime;
    private String director;

    // constructor(s)
    public Film(String name, int yearReleased, int runtime, String director,
                String primaryGenre, String secondaryGenre){
        super(name, yearReleased, primaryGenre, secondaryGenre);
        this.runtime = runtime;
        this.director = director;
    }

    // accessors and mutators
    public String getName(){
        return this.name;
    }

    public void setYearReleased(int newYearReleased){
        this.yearReleased = newYearReleased;
    }

    // toString
    public String toString(){
        return "The inherited toString would say: " + super.toString();
    }

    // class-specific methods

    // test harness
    public static void main(String[] args){

        // Toy Story,1995,81,John Lasseter,Animation,Adventure

        Film testFilm = new Film("Toy Story", 1995, 81, "John Lasseter", "Animation", "Adventure");

        // Example of polymorphism - remember, inheritance is an IS-A relationship. Every class implicitly
        // extends Object (hence all classes you make will already have a toString method). This means that if
        // we have a reference of type Object, then we can store any class in it (since everything is a subclass
        // of object)
        Object anObject = testFilm;
        Object anotherObject = "hello"; // even this works, because String IS-An object since it is a class

        // The static type of "anObject" is Object, but when the code runs, Java knows that it is storing
        // a Film object. So the static type (as declared on line 44) is Object, but the dynamic type is Film.
        // This is very useful, as it means we can have references to super classes, but the reference can store
        // a subclass object within it. For example, in the lecture we made the MediaItem class
        // and made Film extend MediaItem - this means that I can make a variable to store a MediaItem, which we
        // will call myMedia, but inside this variable I can store a Film (becuase film extends MediaItem, and
        // therefore a Film object IS-A MediaItem object too)

        MediaItem myMedia = testFilm;

        // If I print out the toString of testFilm (which has the static type Film), the toString of anObject
        // (which has the static type of Object) and the toString of myMedia (which has the static type of MediaItem),
        // all three of these will result in calling the correct toString of the dynamic type of the object that is
        // stored - all three have the dynamic type of Film, so each of the three statements below will call
        // the toString implemented in Film, even though the static types are Film, Object and MediaIter
        System.out.println(testFilm); // static type: Film, dynamic type: Film
        System.out.println(anObject); // static type: Object, dynamic type: Film
        System.out.println(myMedia);  // static type: MediaItem, dynamic type: Film

        // Exercise - update the TvSeries class so that it extends MediaItem - you will need to change
        // the class declaration to include "extends MediaItem" and then change its constructor to call
        // the superclass's constructor (see how this is done in Film for an example).

        // Currently, this is fine:
        TvSeries alwaysSunnySeries = new TvSeries("It's Always Sunny in Philadelphia", 2005, 15, "Comedy", "Satire");

        // As TvSeries implicitly extends Object, this is also fine:
        Object alwaysSunnyObject = alwaysSunnySeries; // TvSeries IS-An object, hence an Object ref can store this

        // This currently would not compile though because TvSeries does not extend MediaItem
        //MediaItem alwaysSunnyMediaItem = alwaysSunnySeries; // compile time error if TvSeries doesn't extend MediaItem

        // If you fix the definition of TvSeries so that it correctly implements MediaItem then you can uncomment
        // the line above and it will not create a compilation error

        // Further example: once MediaItem is correctly inherited by TvSeries, you can also have a collection
        // (e.g. an array or ArrayList) to store multiple media items in the same collection - and printing will cause
        // the correct toString to be called because of polymorphism and dynamic binding

        /*
        // remove block comment after you have finished updating TvSeries to extend MediaItem
        // the code in this block WILL NOT compile until TvSeries is updated.

        MediaItem[] watchedThisWeek = new MediaItem[5];
        watchedThisWeek[0] = new TvSeries("It's Always Sunny in Philadelphia", 2005, 15, "Comedy", "Satire");
        watchedThisWeek[1] = new Film("The Lord of the Rings: The Return of the King",2003,201,"Peter Jackson","Action,Fantasy");
        watchedThisWeek[2] = new TvSeries("Ted Lasso", 2018, 2, "Comedy", "Sports");;
        watchedThisWeek[3] = new Film("Inception",2010,148,"Christopher Nolan","Action","Adventure");
        watchedThisWeek[4] = new Film("Die Hard",1988,132,"John McTiernan","Action","Thriller");

        for(int i = 0; i < watchedThisWeek.length; i++){
            // the static type of watchedThisWeek[i] will be MediaItem
            System.out.println(watchedThisWeek[i]);
            // but the dynamic type will be either Film or TvSeries - so once you fix the TvSeries class to extend
            // MediaItem, you will see the Java calls the correct toString depending on whether the dynamic type
            // of the element at position i is either a Film or TvSeries object.
        }

        // printing the array again but using a for-each loop this time. It will do the same as the for loop above,
        // but it is a clear example that we are getting an object with the static type of MediaItem at each iteration,
        // but when the code actually runs, the dynamic type determines what is printed)
        for(MediaItem mediaItem: watchedThisWeek){
            System.out.println(mediaItem);
        }
        */
    }

}
