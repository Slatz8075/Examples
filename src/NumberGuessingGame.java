
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slatz8075
 */
public class NumberGuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner for input
        Scanner input = new Scanner(System.in);

        //generate random number between 1 and 100
        int number = (int) (Math.random() * 100 + 1);
        //set a guess to 0
        int guess = 0;
        //while guess is not corect
        while (guess != number) {
            //ask user for guess and store it
            System.out.println("Please enter your guess between 1 and 100");
            guess = input.nextInt();
            //if guess is too high, tell them
            if (guess > number) {
                System.out.println("Guess is too high");
            }
            //if guess is too low, tell them
            if (guess < number){
                System.out.println("Guess is too low");
            }
            //if guess is correct, Contratulations
            if (guess == number){
                System.out.println("Congratulations!");
            }
        }
    }
}