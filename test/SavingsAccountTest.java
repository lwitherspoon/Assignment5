import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    private static final double PRECISION = 0.001;

    @Test
    public void main() {
        int months = 3;
        String startingAmount = "0";
        double monthlyDeposit = 100;
        float annualInterestRate = 5;
        double expected = 302.507;

        assertEquals("Failed to calculate correct compounded value", expected, SavingsAccount.compoundValue(months, startingAmount, monthlyDeposit, annualInterestRate), PRECISION);
    }

}