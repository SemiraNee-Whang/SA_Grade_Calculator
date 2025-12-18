package SAGradeCalculator;

import javax.swing.*;

public class SAGradeCalculator {

    public static void main(String[] args) {
        String[] options = {"High School (CAPS / Matric)", "University"};
        int choice = JOptionPane.showOptionDialog(null, "Select your grading system:",
                "SA Grade Calculator",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            handleHighSchool();
        } else if (choice == 1) {
            handleUniversity();
        } else {
            JOptionPane.showMessageDialog(null, "No option selected. Exiting.");
        }
    }

    private static void handleHighSchool() {
        double sba = Double.parseDouble(JOptionPane.showInputDialog("Enter your SBA mark (%):"));
        double exam = Double.parseDouble(JOptionPane.showInputDialog("Enter your Exam mark (%):"));
        boolean isLO = JOptionPane.showConfirmDialog(null, "Is this Life Orientation?", "Life Orientation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        double finalGrade = HighSchoolCalculator.calculateFinalGrade(sba, exam, isLO);
        int level = HighSchoolCalculator.getCAPSLevel(finalGrade);
        String achievement = HighSchoolCalculator.getAchievementDescription(level);

        JOptionPane.showMessageDialog(null,
                String.format("Final Grade: %.2f%%\nCAPS Level: %d\nAchievement: %s",
                        finalGrade, level, achievement));
    }

    private static void handleUniversity() {
        int subjects = Integer.parseInt(JOptionPane.showInputDialog("Enter number of subjects:"));
        double[] marks = new double[subjects];
        double[] weights = new double[subjects];

        for (int i = 0; i < subjects; i++) {
            marks[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter mark for Subject " + (i + 1) + " (%):"));
            weights[i] = 1.0 / subjects; // equally weighted by default
        }

        double average = UniversityCalculator.calculateWeightedAverage(marks, weights);
        String classification = UniversityCalculator.getUniversityClass(average);

        JOptionPane.showMessageDialog(null,
                String.format("Weighted Average: %.2f%%\nDegree Classification: %s", average, classification));
    }
}
