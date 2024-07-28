import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create the height label and text field
        JLabel heightLabel = new JLabel("Height (m):");
        heightLabel.setBounds(50, 30, 100, 25);
        frame.add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(150, 30, 150, 25);
        frame.add(heightField);

        // Create the weight label and text field
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(50, 70, 100, 25);
        frame.add(weightLabel);

        JTextField weightField = new JTextField();
        weightField.setBounds(150, 70, 150, 25);
        frame.add(weightField);

        // Create the calculate button
        JButton calculateButton = new JButton("Calculate BMI");
        calculateButton.setBounds(50, 110, 150, 25);
        frame.add(calculateButton);

        // Create the result label
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 150, 300, 25);
        frame.add(resultLabel);

        // Create the advice label
        JLabel adviceLabel = new JLabel("<html>Advice:</html>");
        adviceLabel.setBounds(50, 180, 300, 50);
        frame.add(adviceLabel);

        // Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the input values
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());

                    // Calculate BMI
                    double bmi = weight / (height * height);

                    // Determine the BMI category and give advice
                    String result;
                    String advice;
                    if (bmi < 18.5) {
                        result = String.format("BMI: %.2f (Underweight)", bmi);
                        advice = "<html>Advice: Consider increasing your calorie intake with healthy foods and engage in strength training exercises.</html>";
                    } else if (bmi < 24.9) {
                        result = String.format("BMI: %.2f (Normal weight)", bmi);
                        advice = "<html>Advice: Maintain your weight by continuing a balanced diet and regular exercise.</html>";
                    } else if (bmi < 29.9) {
                        result = String.format("BMI: %.2f (Overweight)", bmi);
                        advice = "<html>Advice: Consider reducing your calorie intake, focusing on a balanced diet, and increasing physical activity.</html>";
                    } else {
                        result = String.format("BMI: %.2f (Obese)", bmi);
                        advice = "<html>Advice: Consult with a healthcare provider for personalized advice. Focus on a healthy diet and regular exercise.</html>";
                    }

                    // Update the result and advice labels
                    resultLabel.setText(result);
                    adviceLabel.setText(advice);

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                    adviceLabel.setText("");
                }
            }
        });

        // Set the frame to be visible
        frame.setVisible(true);

    }
}       

