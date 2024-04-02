/**
 * AccessibilityAssessment PA2.
 * 
 * @author jasonamaya
 * @version Febuary 10, 2023.
 *
 */
public class AccessibilityAssessment {
    /** Instanciates the varibales created. **/

    private String category;
    private String googleResult;
    private String waveResult;
    private String sortsiteResult;
    private String aslintResult;
    private String description;

    /**
     * Public class AccesibilityAssesment.
     * 
     * @param category variable.
     * @param googleResult variable.
     * @param waveResult variable.
     * @param sortsiteResult variable.
     * @param aslintResult variable.
     * @param description variable.
     */
    public AccessibilityAssessment(String category, String googleResult, String waveResult, String sortsiteResult,
            String aslintResult, String description) {
        this.category = category;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortsiteResult = sortsiteResult;
        this.aslintResult = aslintResult;
        this.description = description;
    }

    /**
     * Get the category of the arrayList.
     * 
     * @return category of the instance variable.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Gets the descrition of the class.
     * 
     * @return description of the instance variable.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the google result of the class.
     * 
     * @return googleResult of the instance variable.
     */
    public String getGoogleResult() {
        return this.googleResult;
    }

    /**
     * Gets the result of wave.
     * 
     * @return waveResult of the insatance variable.
     */
    public String getWaveResult() {
        return this.waveResult;
    }

    /**
     * Gets the sortsite result.
     * 
     * @return sortsiteResult of the instance variable.
     */
    public String getSortsiteResult() {
        return sortsiteResult;
    }

    /**
     * Gets the aslint result.
     * 
     * @return aslintResult of the instance variable.
     */
    public String getAslintResult() {
        return this.aslintResult;
    }

    /**
     * String of all the results and category and description.
     * 
     * @return String of the line results.
     */
    public String toString() {
        return category + " - " + "Google: " + googleResult + " WAVE: " + waveResult + " SortSite: " + sortsiteResult
                + " ASLint: " + aslintResult + " - " + description;

    }

    /**
     * Checks if the other object equals to the default.
     * 
     * @param other creates a new object that checks for bool.
     * @return boolean if they are equal.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof AccessibilityAssessment)) {
            return false;
        }
        AccessibilityAssessment otherAssessment = (AccessibilityAssessment) other;
        if (this.category.equals(otherAssessment.category) && this.googleResult.equals(otherAssessment.googleResult)
                && this.waveResult.equals(otherAssessment.waveResult)
                && this.sortsiteResult.equals(otherAssessment.sortsiteResult)
                && this.aslintResult.equals(otherAssessment.aslintResult)
                && this.description.equals(otherAssessment.description))

            return true;
        return false;

    }

    /**
     * Checks if there is a in error within the parameter.
     * 
     * @param checkerPartialName Checks if the results holds an error.
     * @return true or false if it does hold error.
     */
    public boolean passed(String checkerPartialName) {
        if (checkerPartialName.equalsIgnoreCase("google")) {
            if (googleResult.equals("error") || googleResult.equals("error_paid")) {
                return true;

            }
        }
        if (checkerPartialName.equalsIgnoreCase("wave")) {
            if (waveResult.equals("error") || waveResult.equals("error_paid")) {
                return true;
            }

        }
        if (checkerPartialName.equalsIgnoreCase("sortsite")) {
            if (sortsiteResult.equals("error") || sortsiteResult.equals("error_paid")) {
                return true;
            }
        }
        if (checkerPartialName.equalsIgnoreCase("lint")) {
            if (aslintResult.equals("error") || aslintResult.equals("error_paid")) {
                return true;

            }
        }
        return false;
    }

}
