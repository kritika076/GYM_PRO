/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;
import javax.swing.JOptionPane;
import java.awt.Component;
/**
 *
 * @author pande
 */
public class Validator {
    /**
     * Validates if a string is null or empty.
     * * @param value The string to check
     * @param fieldName The name of the field for the error message
     * @param parent The parent component for the dialog box
     * @return true if valid, false otherwise
     */
    public static boolean isNotEmpty(String value, String fieldName, Component parent) {
        if (value == null || value.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, fieldName + " cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        return true;
    }

    /**
     * Validates that the age is a positive number within a reasonable range.
     * * @param ageStr The string input from the text field
     * @param parent The parent component for the dialog box
     * @return The parsed integer if valid, -1 if invalid
     */
    public static int validateAge(String ageStr, Component parent) {
        try {
            int age = Integer.parseInt(ageStr); 
            
            // Prevent entering negative numbers 
            if (age < 10 || age > 70) {
                JOptionPane.showMessageDialog(parent, "Age must be between 10 and 70.", "Range Error", JOptionPane.ERROR_MESSAGE); 
                return -1;
            }
            return age;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, "Please enter a valid number for Age.", "Input Error", JOptionPane.ERROR_MESSAGE); 
            return -1;
        }
    }
}
    
