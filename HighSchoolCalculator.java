package SAGradeCalculator;

public class HighSchoolCalculator {

    // Convert percentage to CAPS Level
    public static int getCAPSLevel(double percentage) {
        if (percentage >= 80) return 7;
        if (percentage >= 70) return 6;
        if (percentage >= 60) return 5;
        if (percentage >= 50) return 4;
        if (percentage >= 40) return 3;
        if (percentage >= 30) return 2;
        return 1;
    }

    public static String getAchievementDescription(int level) {
        switch(level) {
            case 7: return "Outstanding Achievement (Distinction)";
            case 6: return "Meritorious Achievement";
            case 5: return "Substantial Achievement";
            case 4: return "Moderate Achievement";
            case 3: return "Adequate Achievement";
            case 2: return "Elementary Achievement";
            default: return "Not Achieved (Fail)";
        }
    }

    // Calculate final Matric grade using SBA and Exam
    public static double calculateFinalGrade(double sba, double exam, boolean isLifeOrientation) {
        if (isLifeOrientation) {
            return sba; // LO is 100% SBA
        }
        return sba * 0.25 + exam * 0.75;
    }
}
