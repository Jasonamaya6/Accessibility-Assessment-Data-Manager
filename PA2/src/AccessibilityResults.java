import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * AccessibilityResults.
 * 
 * @author jasonamaya.
 * @version febuary 13th, 2023.
 *
 */
public class AccessibilityResults {

    private ArrayList<AccessibilityAssessment> assessments;

    /**
     * Object Accessibility Results.
     * 
     * @param filename the name of the file we will work with.
     */
    public AccessibilityResults(String filename) {
        assessments = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String category = scan.next();
                String googleResult = scan.next();
                String waveResult = scan.next();
                String sortsiteResult = scan.next();
                String aslintResult = scan.next();
                String description = scan.nextLine().substring(1);
                assessments.add(new AccessibilityAssessment(category, googleResult, waveResult, sortsiteResult,
                        aslintResult, description));
            }

            scan.close();
        } catch (

        FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
    }

    /**
     * The number of test.
     * 
     * @return assessments size in a int.
     */
    public int numTests() {
        return assessments.size();
    }

    /**
     * Save the results of the file.
     * 
     * @param filename name of the file we are working with.
     * @param format string format how it is needed to be returned.
     * @param results the ArrayList that is going to be returned.
     */
    public static void saveResults(String filename, String format, ArrayList<AccessibilityAssessment> results) {
        try {
            File file = new File(filename);
            PrintWriter write = new PrintWriter(file);
            for (int i = 0; i < results.size(); i++) {
                write.println(results.get(i).toString());
            }
            write.println();
            write.print(String.format(format, results.size()));
            write.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }

    }

    /**
     * Shows the the test results .
     * 
     * @param details the file we are working with.
     * @return the array list that we are working with, amount of tests.
     */
    public ArrayList<AccessibilityAssessment> showTestResults(String details) {
        ArrayList<AccessibilityAssessment> result = new ArrayList<>();
        String filename = "showTestResults-" + details + ".txt";
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).getCategory().toUpperCase().contains(details.toUpperCase())
                    || assessments.get(i).getDescription().toUpperCase().contains(details.toUpperCase())) {
                result.add(assessments.get(i));
            }

        }
        String form = "Total tests matching: %s";
        saveResults(filename, form, result);

        return result;
    }

    /**
     * Shows the catgeories of the results list.
     * 
     * @param category checks if the string.
     * @return the array list.
     */
    public ArrayList<AccessibilityAssessment> showByCategory(String category) {
        ArrayList<AccessibilityAssessment> result = new ArrayList<>();
        String filename = "showByCategory-" + category + ".txt";
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).getCategory().toUpperCase().contains(category.toUpperCase())) {
                result.add(assessments.get(i));
            }

        }
        String form = "Total tests matching: %s";

        saveResults(filename, form, result);

        return result;

    }

    /**
     * Shows all the failed tests.
     * 
     * @return arraylist of failed tests.
     */
    public ArrayList<AccessibilityAssessment> showAllFailed() {
        ArrayList<AccessibilityAssessment> result = new ArrayList<>();
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).getGoogleResult().equals("notfound")
                    && assessments.get(i).getWaveResult().equals("notfound")
                    && assessments.get(i).getAslintResult().equals("notfound")
                    && assessments.get(i).getSortsiteResult().equals("notfound")) {
                result.add(assessments.get(i));
            }

        }
        String form = "Total tests failed: %s";
        String filename = "showAllFailed.txt";

        saveResults(filename, form, result);

        return result;

    }

    /**
     * The passing of the file.
     * 
     * @param name the .txt file we are using
     * @param category category of what is being tested.
     * @return the arraylist that is needed to be passed.
     */
    public ArrayList<AccessibilityAssessment> passing(String name, String category) {
        ArrayList<AccessibilityAssessment> result = new ArrayList<>();
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).passed(name)) {
                result.add(assessments.get(i));
            }

        }
        String form = "Total tests matching: %s";
        String filename = "passing-" + name + "-" + ".txt";

        saveResults(filename, form, result);

        return result;

    }

    /**
     * Number of passing in the list.
     * 
     * @param name The name of the .txt file.
     * @param category of what is being tested.
     * @return the amount of numbers being passed.
     */
    public int numPass(String name, String category) {
        int count = 0;
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).passed(name)) {
                count++;
            }

        }

        return count;

    }

    /**
     * Gets all of what is in the list.
     * 
     * @return the array list and everything in it.
     */
    public ArrayList<AccessibilityAssessment> getAll() {
        return assessments;
    }

}
