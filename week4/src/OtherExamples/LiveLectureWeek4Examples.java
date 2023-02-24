package OtherExamples;

import java.io.IOException;

public class LiveLectureWeek4Examples {


    public static void onlyAcceptsSix(int input) throws NotSixException {
        if(input == 6){
            System.out.println("well done, that was a 6");
        }else{
            throw new NotSixException("The input was not a 6");
        }
    }

    public enum DayOfTheWeek{MON, TUES, WEDS, THURS}

    public static void main(String[] args){

        String dayOfTheWeek = "May";
        DayOfTheWeek myDay = DayOfTheWeek.MON;
        System.out.println(dayOfTheWeek);
        System.out.println(myDay);
//
//
//        try{
//
//
//            onlyAcceptsSix(4);
//            int[] numbers = new int[10];
//            System.out.println(numbers[2]);
//
//
//
//
//
//        }catch(NotSixException e){
//            System.out.println("The number was wrong");
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("The number wasn't the problem, the array was");
//        }
    }


}
