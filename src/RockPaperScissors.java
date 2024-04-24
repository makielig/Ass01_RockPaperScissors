import java.io.*;

import java.util.*;

import java.lang.*;

public class RockPaperScissors{

    public static int getRan() // generating a random number from 1 to 3 as computers choice

    {

        Random ran = new Random();

        int v = ran.nextInt(3)+1;

        return v;

    }

    public static String generalize(int a1) // converting computers choice into labels

    {

        String value1="NULL";

        if(a1==1) // converting computers choice into labels

            value1="rock";

        else if(a1==2)

            value1 = "paper";

        else if(a1==3)

            value1 = "scissor";

        return value1;

    }

    public static String rules(String value2,String choice1) // comparing both players choices with according to defied rules and return result

    {

        String result1="NULL";

        if(value2.equals("rock") && choice1.equals("paper"))

            result1 = "win";

        else if(value2.equals("rock")&& choice1.equals("scissor"))

            result1 = "lose";

        else if(value2.equals("rock")&& choice1.equals("rock"))

            result1 = "draw";

        else if(value2.equals("paper") && choice1.equals("scissor"))

            result1 = "win";

        else if(value2.equals("paper")&& choice1.equals("rock"))

            result1 = "lose";

        else if(value2.equals("paper")&& choice1.equals("paper"))

            result1 = "draw";

        else if(value2.equals("scissor")&& choice1.equals("scissor"))

            result1 = "draw";

        else if(value2.equals("scissor")&& choice1.equals("paper"))

            result1 = "lose";

        else if(value2.equals("scissor")&& choice1.equals("rock"))

            result1 = "win";

        return result1;

    }

    public static void textfile(String name1,String result2) // Text file creation for name and result storage

    {

        try(FileWriter fw = new FileWriter("myfile.txt", true);

            BufferedWriter bw = new BufferedWriter(fw);

            PrintWriter out = new PrintWriter(bw))

        {

            out.println(name1);

            out.println(result2);

        }

        catch (IOException e) {

            System.out.println("Exception Encountered");

        }

    }

    public static void main(String []args){

        boolean isRunning = true;

        String value = "NULL",result ="NULL";

        Scanner sc = new Scanner(System.in); // for taking user input

        System.out.println("Enter your name:"); // taking name as input

        String name = sc.next();

        while(isRunning) // while loop for replay

        {

            System.out.println("Enter your choice:"); // taking users choice as input

            String choice = sc.next();

            int a=getRan();

            value = generalize(a);

            result = rules(value,choice);

            System.out.println("result:"+result); // printing the result

            textfile(name,result);

            System.out.println("Do you wanna keep playing(Enter either yes or no)"); //replay condition

            String check = sc.next();

            if(check.equals("no")|| check.equals("NO")|| check.equals("No"))

                System.exit(0);

        }

    }

} //end of prgoram