import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // setup the input
        Scanner input = new Scanner(System.in);
        // initialize our sales table
        int[][] salesTable = new int[5][4];
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
            salesTable[productNumber - 1][salesPerson - 1] += salesAmount;
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
            // print the table
            if (!continueRunning) {
                // some space for our table
                System.out.print("\n\n");
                // placeholder for top left cell
                System.out.format("%15s", "");
                // print the sales agents
                for (int i = 1; i < 5; i++) {
                    System.out.format("%15s", "Sales Agent #" + i);
                }
                // table heading for total and a line break
                System.out.format("%15s", "Total" + "\n");
                // vars for storing totals
                int[] salesAgentTotal = new int[4];
                int[] productSalesTotal = new int[5];
                // iterate over our 2d array
                for (int row = 0; row < salesTable.length; row++) {
                    System.out.format("%15s", "Product #" + (row + 1));
                    for (int col = 0; col < salesTable[row].length; col++) {
                        System.out.format("%15s", salesTable[row][col]);
                        salesAgentTotal[col] += salesTable[row][col];
                        productSalesTotal[row] += salesTable[row][col];
                    }
                    System.out.format("%15s", productSalesTotal[row] + "\n");
                }
                System.out.format("%15s", "Total");
                for (int i = 0; i < salesAgentTotal.length; i++) {
                    System.out.format("%15s", salesAgentTotal[i]);
                }
                // give the table some bottom padding
                System.out.print("\n\n");
            }
        }
        input.close();
    }
}