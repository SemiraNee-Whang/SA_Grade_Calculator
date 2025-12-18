package SAGradeCalculator;

public class UniversityCalculator {

    // Convert percentage to class
    public static String getUniversityClass(double percentage) {
        if (percentage >= 75) return "First Class (Distinction)";
        if (percentage >= 70) return "Second Class (Division 1)";
        if (percentage >= 60) return "Second Class (Division 2)";
        if (percentage >= 50) return "Third Class (Pass)";
        return "Fail";
    }

    // Convert CAPS level to APS points (basic)
    public static int levelToAPSPoints(int level) {
        return level; // Level 1-7 = 1-7 points
    }

    // Calculate weighted average for a semester/year
    public static double calculateWeightedAverage(double[] marks, double[] weights) {
        double total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i] * weights[i];
        }
        return total;
    }
}
