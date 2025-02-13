import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATM {
    private static final int PIN = 1234;
    private static double balance = 5000.00;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter PIN: ");
            int enteredPin = Integer.parseInt(scanner.nextLine());

            if (enteredPin != PIN) {
                throw new InvalidPinException("Invalid PIN! Access denied.");
            }

            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance!");
            }

            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values.");
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final Balance: " + balance);
        }
    }
}
