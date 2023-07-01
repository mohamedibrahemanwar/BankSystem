package Sessoin_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingApplication {
    private static int accountId = 1;
    private static List<Clint> clients = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Create account for a client");
            System.out.println("2. List all accounts");
            System.out.println("3. Display account details");
            System.out.println("4. Withdraw money");
            System.out.println("5. Deposit money");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    listAccounts();
                    break;
                case 3:
                    displayAccount(scanner);
                    break;
                case 4:
                    withdraw(scanner);
                    break;
                case 5:
                    deposit(scanner);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter client name: ");
        String name = scanner.next();
        System.out.print("Enter client address: ");
        String address = scanner.next();
        System.out.print("Enter client phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Is this a savings account? (y/n): ");
        String isSavings = scanner.next();

        BankAccount account;
        if (isSavings.equalsIgnoreCase("y")) {
            System.out.print("Enter minimum balance: ");
            double minimumBalance = scanner.nextDouble();
            account = new SavingBankAccount(balance, minimumBalance);
        } else {
            account = new BankAccount(balance);
        }
        account.setAccountId(accountId++);

        Clint client = new Clint(name, address, phoneNumber, account);
        clients.add(client);
        System.out.println("Account created with ID " + account.getAccountId());
    }

    private static void listAccounts() {
        System.out.println("List of all accounts:");
        for (Clint client : clients) {
            System.out.println("Client name: " + client.getName());
            System.out.println("Account ID: " + client.getAccount().getAccountId());
            System.out.println("Balance: " + client.getAccount().getBalance());
            System.out.println();
        }
    }

    private static void displayAccount(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        for (Clint client : clients) {
            if (client.getAccount().getAccountId() == accountId) {
                System.out.println("Client name: " + client.getName());
                System.out.println("Account ID: " + client.getAccount().getAccountId());
                System.out.println("Balance: " + client.getAccount().getBalance());
                if (client.getAccount() instanceof SavingBankAccount) {
                    System.out.println("Minimum balance: " + ((SavingBankAccount) client.getAccount()).getMinimumBalance());
                }
                System.out.println();
                return;
            }
        }
        System.out.println("Account not found");
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        for (Clint client : clients) {
            if (client.getAccount().getAccountId() == accountId) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                if (client.getAccount().withdraw(amount)) {
                    System.out.println("Withdrawal successful");
                    System.out.println("New balance: " + client.getAccount().getBalance());
                } else {
                    System.out.println("Insufficient balance");
                }
                return;
            }
        }
        System.out.println("Account not found");
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        for (Clint client : clients) {
            if (client.getAccount().getAccountId() == accountId) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                client.getAccount().deposit(amount);
                System.out.println("Deposit successful");
                System.out.println("New balance: " + client.getAccount().getBalance());
                return;
            }
        }
        System.out.println("Account not found");
    }
}
