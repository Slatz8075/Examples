
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author slatz8075
 */
public class StringManipulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create scanner for input
        Scanner input = new Scanner(System.in);
        
        //scan in a word
        String word = input.nextLine();
        word = word.toLowerCase();
        
        //make some changes 
        String changedWord = word.replaceFirst("a", "@");
        
        //find the first l
        int lPosition = changedWord.indexOf("l");
        
        //found an l in the words
        if(lPosition != -1){
            //breaking the string apart
            //starts at the beginning, goes UPTO the L
            String beginning = changedWord.substring(0, lPosition);
            //start at the L, take everythig after it
            String ending = changedWord.substring(lPosition);
            //reassemble 
            changedWord = ending + beginning + "ay";
        }
        
        //check if the word typed out is "hello"
        if(word.equalsIgnoreCase("hello")){ //tis may be helpful: word.equalsIgnoreCase
            System.out.println("Hi There!");
        }
        
        //gets the length of the word
        int length = word.length();
        //walk through the characters using a loop
        int count = 0;
        for(int i = 0; i < length; i ++) { 
            //look at the character 
            //is the character an l
            if(word.charAt(i) == 'l') {
                //count it!
                count = count ++; //or count + 1
            }
        }
        
        
        
        System.out.println("the word is " + changedWord);
        System.out.println("the L is it position " + lPosition);
        System.out.println("There are " + count + " Ls");
    }
}
