import OtherExamples.IllegalDurationException;

public class Film extends MediaItem{

    // fields
    private int duration;
    private String director;

    // constructor(s)
    public Film(String name, int yearReleased, int duration, String director, String primaryGenre, String secondaryGenre) throws IllegalDurationException{
        super(name, yearReleased, primaryGenre, secondaryGenre);

        if(duration < 0){
            throw new IllegalDurationException();
        }else {
            this.duration = duration;
        }

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
        return "This film is called " + this.name + " and it is " + this.duration + " minutes long";
    }

    // class-specific methods

    // example code written in week 3 - see below for week 4 code
    // note - I have had to add throws IllegalDurationException to the header of this method
    // as it doesn't have an explicit try-catch block to handle this potential Exception
    // now that we changed the constructor in week 4. Please see the week4Examples() method below
    // to see how we can use a try-catch with the constructor now, but below we are
    // effectively ignoring the exception in the method below
    public static void week3Examples() throws IllegalDurationException{
        // Toy Story,1995,81,John Lasseter,Animation,Adventure

        Film testFilm = new Film("Toy Story", 1995, 81, "John Lasseter", "Animation", "Adventure");

        // Example of polymorphism - remember, inheritance is an IS-A relationship. Every class implicitly
        // extends Object (hence all classes you make will already have a toString method). This means that if
        // we have a reference of type Object, then we can store any class in it (since everything is a subclass
        // of object
        Object anObject = testFilm;
        Object anotherObject = "hello"; // even this works, because String IS-A object since it is a class

        // The static type of "anObject" is Object, but when the code runs, Java knows that it is storing
        // a Film object. So the static type (as declared on line 44) is object, but the dynamic type is Film.
        // This is very useful, as it means we can have references to super classes, but the reference can store
        // an object that is the type of the subclass. For example, in the lecture we made the MediaItem class
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

        for(MediaItem mediaItem: watchedThisWeek){
            System.out.println(mediaItem);
        }
        */
    }

    // testing code written during the week 4 lecture to demonstrate catching IllegalDurationExceptions
    public static void week4Examples() {
        // in the lecture we showed that we could use an if statement to check for a negative duration, but there
        // wasn't really anything we could do with it other than set the duration to 0. It is much better to use
        // an Exception in this case though,as we can prevent a Film object being made with an invalid value for the
        // duration (as in the example below with our own IllegalDurationException)
        try {
            Film testFilm = new Film("Toy Story", 1995, -810, "John Lasseter", "Animation", "Adventure");
            System.out.println(testFilm);
        } catch (IllegalDurationException e) {
            System.out.println("The film cannot be created because negative durations don't make sense");
        }
    }

    // test harness
    public static void main(String[] args){
        //  note that to run the week3Examples() method, we have to put it in a try-catch
        // now since the constructor within it can throw an exception and it's not handled in that method
        // Therefore, we must handle it here. This is not the case for the week4Examples() method though since that
        // explicitly deals with the exception within the method using a try-catch, so the exception can never
        // reach as far as the main method for that example.

        try{
            week3Examples(); // to run the week 3 example code (comment/delete this line if you don't want to run this code)
        }catch(Exception e){
            e.printStackTrace(); // I didn't show this in the lecture, but you can specifically print out the
                                 // stack trace for an Exception, even if you have caught it. This is the same info
                                 // that Java normally prints when an unhandled exception triggers code to exit
        }
        week4Examples();
    }

}
