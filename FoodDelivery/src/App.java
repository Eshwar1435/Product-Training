import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int loginChoice;
        do { 
            System.out.println("Welcome to the login system");
            System.out.println("1. Admin\n2. Customer\n3. Deliver Person\n4. Exit");
            System.out.print("Enter your choice: ");
            loginChoice = in.nextInt();
            in.nextLine();
            switch (loginChoice) {
                case 1 ->{
                    Admin admin = new Admin();
                    admin.login(in);
                    
                }
                case 2->{
                    // Customer customer = new Customer();
                    // customer.login();
                }
                case 3 ->{
                    // DeliverPerson deliverPerson = new DeliverPerson();
                    // deliverPerson.login();
                }
                case 4 ->{
                    System.out.println("Exiting the system. Goodbye!");
                    }
                default->{
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (loginChoice!=4);
        in.close();
    }
}
