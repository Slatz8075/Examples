
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author slatz8075
 */
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //to create the input for the user
        Scanner input = new Scanner(System.in);
        
        //ask user for their name
        System.out.println("Please enter your name");
        //get the name form the user
        String name = input.nextLine();
        //say hello
        System.out.println("hello " + name);//Short cut: type "sout" then press "tab"
        //ask for the year the user was born
        System.out.println("please enter your year of birth");
        int birthYear = input.nextInt();
        //calculate age
        int age = 2016 - birthYear;
        //tell the user their age
        System.out.println("You are " + age + " years old!");
        
        if (age > 30){
            System.out.println("you are old!");
        } else if (age > 10 && age < 30){
            
        }
                
       //Example int max = Integer.MAX_VALUE;
       //System.out.println(max);
       //max = max + 1;
       //System.out.println(max);
    }
}
