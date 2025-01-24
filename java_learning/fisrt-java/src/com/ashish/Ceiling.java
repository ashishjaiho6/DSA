package com.ashish;

import java.util.Scanner;

/**
 * This program finds the smallest character in a sorted array that is strictly greater than a given target character.
 * If the target character is greater than or equal to all characters in the array, it wraps around to the first character.
 */
public class Ceiling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Predefined sorted array of characters
        char[] letters = {'c', 'f', 'j', 'k', 'm', 's', 't'};

        // Prompt the user to enter the target character
        System.out.println("Enter the target character:");
        char target = input.next().charAt(0);

        // Find the next greatest letter
        char ans = nextGreatestLetter(letters, target);

        // Display the result
        System.out.println("The next greatest letter is: " + ans);
    }

    /**
     * Finds the smallest character in the sorted array that is strictly greater than the target.
     * If no such character exists, wraps around to the fi rst character in the array.
     *
     * @param letters A sorted array of characters.
     * @param target  The target character.
     * @return The next greatest letter.
     */
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        // If the target is greater than or equal to the last character, wrap around to the first character
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }

        // Binary search to find the smallest letter greater than the target
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                // If target is less than the middle character, move to the left half
                end = mid - 1;
            } else {
                // If target is greater than or equal to the middle character, move to the right half
                start = mid + 1;
            }
        }

        // Return the character at the "start" index, wrapping around if necessary
        return letters[start % letters.length];
    }
}
