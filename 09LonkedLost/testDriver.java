import java.util.*;
public class testDriver{
    public static void main(String[] args){
        MyLinkedList test = new MyLinkedList();
        int score = 0;

        // * * * * TESTING THE CREATION OF A LINKED LIST + TOSTRING() * * * * \\
        try{
            if(test.toString().equals("[]")){
                score += 1;
            }
        }
        catch(NullPointerException e){
            System.out.println("Your toString doesn't work on an empty list!");
        }

        // * * * * TESTING THE NORMAL ADD * * * * \\
        ArrayList<Integer> testeroni = new ArrayList<Integer>();

        for(int i = 0; i < 24; i++){
            int tchooadd = (int)(Math.random() * Integer.MAX_VALUE);
            testeroni.add(tchooadd);
            test.add(tchooadd);
        }

        for(int i = 0; i < 24; i++){
            try{
                if(testeroni.get(i) == test.get(i)){
                    score += 1;
                }
                else{
                    System.out.println("Your add function did not work properly.");
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Issue with your get function!");
            }
        }

        // * * * * TESTING INDEX OF METHOD * * * * \\

        int index = (int)(Math.random() * 25);
        System.out.println(test);
        System.out.println(testeroni);
        if(test.indexOf(testeroni.get(index)) == index){
            score += 1;
        }
        else{
            System.out.println("Issue with your IndexOf");
        }

        // * * * * TESTING REMOVE * * * * \\

        try{
            test.remove(0);
        }
        catch(NullPointerException e){
            System.out.println("Issue with your remove function on the first index");
        }

        int length = test.size();
        for(int i = 0; i < length; i++){
            test.remove(0);
        }
        if(test.size() == 0){
            score += 1;
        }
        else{
            System.out.println("Remove not working");
        }

        System.out.println(score);




    }
}
