import Controller.ClientController;
import Models.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static ClientController clientController = new ClientController();
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {

        run();
    }
    public static void run() {
        int choice = -1;
        while (choice != 0) {
            showMenu();
//            choice = getUserChoice();
            System.out.print("Enter your choice: ");
            choice = console.nextInt();
            try {
                switch (choice) {
                    case 1:

                        System.out.println(ClientController.getAllClients());
                        break;
                    case 2:
                        System.out.println("Enter client name: ");
                        String ClientName = console.nextLine();
                        System.out.print("Enter client age: ");
                        long ClientAge = console.nextLong();
                        Client client = new Client(ClientName,ClientAge , LocalDate.now());
                        ClientController.addClient(client);
                        break;
                    case 3:
                        System.out.print("Enter client Id: ");
                        int ClientId = console.nextInt();
                        clientController.deleteClient(ClientController.searchClientById(ClientId));
                        break;
                    case 4:
                        System.out.println("\nEnter client name: ");
                        String UpdateClientName = console.nextLine();
                        System.out.print("Enter client age: ");
                        long UpdateClientAge = console.nextLong();
                        Client clients = new Client(UpdateClientName,UpdateClientAge , LocalDate.now());
                        ClientController.updateClient(clients);
                        break;
                    case 5:
                        System.out.print("Enter client Id: ");
                        int id = console.nextInt();
                        System.out.println("Selected client:");
                        System.out.println(ClientController.searchClientById(id));
                        break;
                    case 0:
                        System.out.println("EXIT...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public static void showMenu() {
        System.out.println("\n===Nikolai CRUD Operations ===");
        System.out.println("1. View all clients");
        System.out.println("2. Add new client");
        System.out.println("3. Delete client");
        System.out.println("4. Update client ");
        System.out.println("0. Exit");
    }
    public static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return console.nextInt();
    }
}