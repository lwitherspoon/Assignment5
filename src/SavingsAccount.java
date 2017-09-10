import java.util.Scanner;

/**
 * Program to forecast dollar amount in savings account, given an annual interest rate and number of months to project
 * @author Laura Witherspoon
 * Assignment 5.30
 * Date: 9/12017
 */

public class SavingsAccount {

    /**
     * Compounds value in account based on starting dollar amount, number of months, and monthly addition of $100
     * @param months number of months to forecast out
     * @param initialAmount current amount in account
     * @param monthlyDeposit amount of money deposited to account each month
     * @param annualInterestRate percent interest earned annually
     * @return total amount with compounded interest in account after specified number of months
     */
    static double compoundValue(int months, String initialAmount, double monthlyDeposit, float annualInterestRate) {
        double newAmount = Double.parseDouble(initialAmount.replaceAll(",", ""));
        float monthlyRate = (annualInterestRate / 100) / 12;

        for (int i = 0; i < months; i++) {
            newAmount = (monthlyDeposit + newAmount) * (1 + monthlyRate);
        }

        return newAmount;
    }

    /**
     * Removes % sign, if applicable, and converts to float type
     * @param input string to parse
     * @return parsed float value
     */
    private static float parseInput(String input) {
        float parsedInput;
        if (input.indexOf("%") > 0) {
            input = input.substring(0,input.indexOf("%"));
            parsedInput = Float.parseFloat(input);
        } else {
            parsedInput = Float.parseFloat(input);
        }
        return parsedInput;
    }

    public static void main(String[] args) {
        System.out.print("Please enter your account's starting dollar amount: $");
        Scanner keyboard = new Scanner(System.in);
        String amount = keyboard.next();

        System.out.print("What is the annual interest rate? ");
        System.out.println("Please enter rate in this format: 3.5 or 3.5%");
        String rateInput = keyboard.next();

        // If interest rate is negative, prompt user for another string
        while (parseInput(rateInput) < 0) {
            System.out.println("You can't have a negative interest rate. ");
            System.out.println("Please enter the annual interest rate in the format: 3.5 or 3.5%");
            rateInput = keyboard.next();
        }

        // Parse rate input by user and save to local variable
        float annualInterestRate = parseInput(rateInput);

        System.out.println("How many months in the future should I project?");
        int months = keyboard.nextInt();

        // If months is negative, prompt user again for number of months
        while (months < 0) {
            System.out.println("You can't have negative months. ");
            System.out.println("Please enter the number of months in the future to project.");
            months = keyboard.nextInt();
        }

        System.out.printf("With a monthly $100 deposit and compounding interest, your account will have $%1.2f in " + months + " months.", compoundValue(months, amount, 100, annualInterestRate));
    }
}
