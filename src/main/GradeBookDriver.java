/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Sep 1, 2021
 */

package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.GradeBook;

public class GradeBookDriver {
    public static void main(String[] args) {
        // Amount of scores
        int amountOfScores = 0;
        
        // Declare scanner object.
        Scanner input = new Scanner(System.in);
        
        // Prompt user for amount of scores.
        System.out.print("How many scores would you like to enter? ");
        
        // Loop through non-integer input.
        while (!input.hasNextInt()) {
            // Inform user that input is invalid.
            System.out.println("Non-integer input. Please enter an integer.");
            // Important: needed for next validation.
            input.next();
            // Prompt for input again.
            System.out.print("How many scores would you like to enter? ");
        }
        
        // Get validated amount of scores.
        amountOfScores = input.nextInt();
        
        // Test scores for upcoming GradeBook object
        ArrayList<Integer> mainTestScores = new ArrayList<Integer>();
        
        for (int i = 0; i < amountOfScores; ++i) {
            // Test score
            int mainTestScore = 0;
            
            // Prompt user for amount of scores.
            System.out.print("Enter a score: ");
            
            // Loop through non-integer input.
            while (!input.hasNextInt()) {
                // Inform user that input is invalid.
                System.out.println("Non-integer input. Please enter an integer.");
                // Important: needed for next validation.
                input.next();
                // Prompt for input again.
                System.out.print("Enter a score: ");
            }
            
            // Get validated test score.
            mainTestScore = input.nextInt();
            
            // Add test score to list.
            mainTestScores.add(mainTestScore);
        }
        
        // Close scanner object.
        input.close();
        
        // Create GradeBook object.
        GradeBook mainTest = new GradeBook("Main Test", mainTestScores);
        
        // Print GradeBook object.
        System.out.println();
        mainTest.print();
    }
}
