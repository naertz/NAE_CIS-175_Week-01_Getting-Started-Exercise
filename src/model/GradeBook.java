/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Sep 1, 2021
 */

package model;

import java.util.ArrayList;

public class GradeBook {
    // Instance Variables ==================================
    private String testName;               // Test Name
    private ArrayList<Integer> testScores; // Test Scores
    private ArrayList<String> letterGrades; // Letter Grades
    // =====================================================
    
    // Constructor(s) ================================================
    // Default
    public GradeBook() {
        setTestName("");
        setTestScores(new ArrayList<Integer>());
    }
    
    // Main
    public GradeBook(String testName, ArrayList<Integer> testScores) {
        setTestName(testName);
        setTestScores(testScores);
    }
    // ===============================================================
    
    // Setters ==================================================
    // Test Name
    public void setTestName(String testName) {
        this.testName = testName;
    }
    
    // Test Scores
    public void setTestScores(ArrayList<Integer> testScores) {
        this.testScores = testScores;
        
        setLetterGrades(testScores);
    }
    
    // Letter Grades
    public void setLetterGrades(ArrayList<Integer> testScores) {
        final int MIN_GRADE_A = 90;
        final int MIN_GRADE_B = 80;
        final int MIN_GRADE_C = 70;
        final int MIN_GRADE_D = 60;
        
        final String GRADE_A = "A";
        final String GRADE_B = "B";
        final String GRADE_C = "C";
        final String GRADE_D = "D";
        final String GRADE_F = "F";
        
        ArrayList<String> letterGrades = new ArrayList<String>();
        
        for (int testScore : testScores) {
            if (testScore >= MIN_GRADE_A) {
                letterGrades.add(GRADE_A);
            } else if (testScore >= MIN_GRADE_B) {
                letterGrades.add(GRADE_B);
            } else if (testScore >= MIN_GRADE_C) {
                letterGrades.add(GRADE_C);
            } else if (testScore >= MIN_GRADE_D) {
                letterGrades.add(GRADE_D);
            } else if (testScore < MIN_GRADE_D) {
                letterGrades.add(GRADE_F);
            }
        }
        
        this.letterGrades = letterGrades;
    }
    // ==========================================================
    
    // Getters =================================
    // Test Name
    public String getTestName() {
        return testName;
    }
    
    // Test Scores
    public ArrayList<Integer> getTestScores() {
        return testScores;
    }
    
    // Letter Grades
    public ArrayList<String> getLetterGrades() {
        return letterGrades;
    }
    // =========================================
    
    // Helper Methods ===================================================================================================
    // GradeBook Printer
    public void print() {
        final String SCORE = "Score";
        final String GRADE = "Grade";
        
        // Test scores converted to strings
        ArrayList<String> testScoreStrings = new ArrayList<String>();
        
        // Strings to be padded for each side
        ArrayList<String> scoreStrings = new ArrayList<String>();
        ArrayList<String> gradeStrings = new ArrayList<String>();
        
        // Longest string length on score side
        int longestScoreSideLength = SCORE.length();
        
        // Find the longest string length on the score side.
        for (int testScore : testScores) {
            String testScoreString = String.format("%d", testScore);
            // Add string to test score strings list for padding later
            testScoreStrings.add(testScoreString);
            
            if (testScoreString.length() > longestScoreSideLength) {
                longestScoreSideLength = testScoreString.length();
            }
        }
        
        // Add all strings to be displayed on the score side to the score strings list.
        scoreStrings.add(String.format("%" + (-longestScoreSideLength) + "s", SCORE));
        for (String testScoreString : testScoreStrings) {
            scoreStrings.add(String.format("%" + (-longestScoreSideLength) + "s", testScoreString));
        }
        
        // Longest string length on grade side.
        int longestGradeSideLength = GRADE.length();
        
        // Find the longest string length on the grade side.
        for (String letterGrade : letterGrades) {
            if (letterGrade.length() > longestGradeSideLength) {
                longestGradeSideLength = letterGrade.length();
            }
        }
        
        // Add all strings to be displayed on the grade side to the grade strings list.
        gradeStrings.add(String.format("%" + (longestGradeSideLength) + "s", GRADE));
        for (String letterGrade : letterGrades) {
            gradeStrings.add(String.format("%" + (longestGradeSideLength) + "s", letterGrade));
        }
        
        // Print each padded line.
        for (int i = 0; i < scoreStrings.size(); ++i) {
            System.out.printf("%s -------- %s\n", scoreStrings.get(i), gradeStrings.get(i));
        }
    }
    
    // toString Override
    @Override
    public String toString() {
        return "GradeBook [testName=" + testName + ", testScores=" + testScores + ", letterGrades=" + letterGrades + "]";
    }
    // ==================================================================================================================
}
