package OtherExamples;

import java.io.IOException;

public class LiveLectureWeek4Examples {

    // reminder - a simple method that should only accept the input of 6
    // We saw an initial version that just printed a message if it was 6 or not,
    // but now it is updated to throw a custom Exception that we made, called
    // NotSixException - remember, it is a clas that extends Exception, so
    // a NotSixException IS-An Exception itself, but having a specific subclass
    // for this exception means we can have a dedicated catch block later for
    // doing specific behaviours only when that type of exception occurs
     public static void onlyAcceptsSix(int input) throws NotSixException {
        if(input == 6){
            System.out.println("well done, that was a 6");
        }else{
            throw new NotSixException("The input was not a 6");
        }
    }

    // very simple example of an enum - remember, enums (enumarative types) are very
    // useful when you require a variable that can only take one of afixed range of
    // values. We could represent day of the week with a String, but this is not type
    // safe as anyone can enter a valid String, even if it is not a day. Rather than
    // needing to implement error checking to compare a String against accepted values,
    // using an enum like below means if we have a DayOfTheWeek variable then it can
    // only be set to one of our defined values, not something else
    public enum DayOfTheWeek{MON, TUES, WEDS, THURS}
    // Excercise: the enum above has 4 values at the moment - try extending this
    // yourself so that you can also have a DayOfTheWeek to represent the other 3
    // days of the week, then test that you can set them correctly in the main method below
    public static void main(String[] args){
        String dayOfTheWeek = "May"; // called dayOfTheWeek but it is not a day
        DayOfTheWeek myDay = DayOfTheWeek.MON; // this HAS to be one of the enum's values
        System.out.println(dayOfTheWeek);
        System.out.println(myDay);

        // Exception example: in addition to extending Film to include exceptions
        // we also demonstrated that we could catch exceptions in deifferent places,
        // and also have different catch blocks for different types of Exception. Below,
        // this code can throw either a NotSixException (in the method call on line 51),
        // or if this doesn't happen then the code on line 52 will cause an
        // IndexOutOfBoundsException. Investigate how causing the exception on different
        // lines affects which catch block runs (a try can have multiple catch blocks for
        // different types of Exception, but if any kind of Exception is thrown during the
        // try block then only one catch will be triggered, and this will be the first
        // catch that matches the type of Exception that was thrown).
        try{
            onlyAcceptsSix(4); // throws an exception if not 6, fine otherwise
            int[] numbers = new int[10];
            System.out.println(numbers[20]); // always throws an exception if the index is out of bounds
        }catch(NotSixException e){
            System.out.println("The number was wrong");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The number wasn't the problem, the array was");
        }
    }


}
