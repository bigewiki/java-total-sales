import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // setup the input
        Scanner input = new Scanner(System.in);
        // initialize our sales table
        int[][] salesTable = new int[4][5];
        int salesPerson;
        int productNumber;
        int salesAmount;
        // loop to collect data
        Boolean continueRunning = true;
        while (continueRunning) {
            // resetting these variables
            salesPerson = 0;
            productNumber = 0;
            salesAmount = 0;
            // prompt for sales person number
            while (salesPerson < 1 || salesPerson > 4) {
                System.out.print("Enter Sale Person's number (1 - 4): ");
                salesPerson = input.nextInt();
            }
            // prompt for product number
            while (productNumber < 1 || productNumber > 5) {
                System.out.print("Enter product number (1 - 5): ");
                productNumber = input.nextInt();
            }
            // prompt for sales amount
            while (salesAmount < 1) {
                System.out.print("Enter sales amount (0 - ?): ");
                salesAmount = input.nextInt();
            }
            // set the table amount
            salesTable[salesPerson - 1][productNumber - 1] += salesAmount;
            // probably a smarter way to do this but I need to throw away this input
            input.nextLine().trim().toLowerCase();
            // let the user decide if they would like to continue
            System.out.print("Would you like to continue? (y/n): ");
            while (true) {
                String answer = input.nextLine().trim().toLowerCase();
                if (answer.equals("y")) {
                    System.out.println("===========================");
                    break;
                } else if (answer.equals("n")) {
                    continueRunning = false;
                    break;
                } else {
                    System.out.print("Would you like to continue? (y/n): ");
                }
            }
        }
        input.close();
    }
}