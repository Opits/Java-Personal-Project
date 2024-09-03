import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BudgetItem {
    private String name;
    private double amount;

    public BudgetItem(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

public class Main {
    private static List<BudgetItem> expenses = new ArrayList<>();
    private static List<BudgetItem> income = new ArrayList<>();
    private static List<BudgetItem> recurringCosts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Budget Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. Add Recurring Cost");
            System.out.println("4. View Summary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBudgetItem(scanner, expenses, "expense");
                    break;
                case 2:
                    addBudgetItem(scanner, income, "income");
                    break;
                case 3:
                    addBudgetItem(scanner, recurringCosts, "recurring cost");
                    break;
                case 4:
                    viewSummary();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addBudgetItem(Scanner scanner, List<BudgetItem> list, String type) {
        System.out.print("Enter " + type + " name: ");
        String name = scanner.nextLine();
        System.out.print("Enter " + type + " amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        list.add(new BudgetItem(name, amount));
        System.out.println(type + " added successfully.");
    }

    private static void viewSummary() {
        System.out.println("Summary:");
        System.out.println("Expenses:");
        printBudgetItems(expenses);
        System.out.println("Income:");
        printBudgetItems(income);
        System.out.println("Recurring Costs:");
        printBudgetItems(recurringCosts);
    }

    private static void printBudgetItems(List<BudgetItem> list) {
        for (BudgetItem item : list) {
            System.out.println(item.getName() + ": $" + item.getAmount());
        }
    }
}