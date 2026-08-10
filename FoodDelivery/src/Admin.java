import java.util.HashMap;
import java.util.Scanner;

public class Admin {
private final String username;
private final String password;
static HashMap<Integer, Restaurant> resList = new HashMap<>();
static HashMap<Integer, Order> orderList = new HashMap<>();
public Admin() {
    this.username = "admin";
    this.password = "admin123";
}
public void addRestaurant(int id,String name,String location, double rating){
    Restaurant r = new Restaurant();
    r.setRestaurantId(id);
    r.setRestaurantName(name);
    r.setRestaurantLocation(location);
    r.setRestaurantRating(rating);
    System.out.println("Adding Restaurant...");
    resList.put(id, r);
    System.out.println("Added Restaurant");
}
public void removeRestaurant(int id){
    resList.remove(id);
}
public HashMap<Integer,Restaurant> viewRestaurant(){
    return resList;
}

public void manageMenu(Scanner in) {
    System.out.print("Enter Restaurant ID: ");
    int rid = in.nextInt();
    in.nextLine();

    Restaurant r = resList.get(rid);

    if (r == null) {
        System.out.println("Restaurant not found!");
        return;
    }

    int choice;
    do {
        System.out.println("\n--- Manage Menu ---");
        System.out.println("1. Add Food Item");
        System.out.println("2. Remove Food Item");
        System.out.println("3. Update Food Item");
        System.out.println("4. View Menu");
        System.out.println("5. Back");
        System.out.print("Enter choice: ");

        choice = in.nextInt();
        in.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Food ID: ");
                int fid = in.nextInt();
                in.nextLine();

                System.out.print("Enter Food Name: ");
                String name = in.nextLine();

                System.out.print("Enter Price: ");
                double price = in.nextDouble();
                in.nextLine();

                System.out.print("Enter Category: ");
                String category = in.nextLine();

                FoodItem item = new FoodItem(fid, name, price, category, true);
                r.getMenu().addItem(item);

                System.out.println("Food item added!");
            }

            case 2 -> {
                System.out.print("Enter Food ID to remove: ");
                int fid = in.nextInt();
                in.nextLine();

                r.getMenu().removeItem(fid);
                System.out.println("Food item removed!");
            }

            case 3 -> {
                System.out.print("Enter Food ID to update: ");
                int fid = in.nextInt();
                in.nextLine();

                System.out.println("1. Update Price");
                System.out.println("2. Update Availability");
                System.out.println("3. Update Both");
                System.out.print("Enter choice: ");
                int updateChoice = in.nextInt();

                switch (updateChoice) {

                    case 1 -> {
                        System.out.print("Enter new price: ");
                        double price = in.nextDouble();
                        in.nextLine();

                        r.getMenu().updatePrice(fid, price);
                    }

                    case 2 -> {
                        System.out.print("Availability (1 = Available, 0 = Not Available): ");
                        int ch = in.nextInt();
                        in.nextLine();

                        boolean available = (ch == 1);

                        r.getMenu().updateAvailability(fid, available);
                    }

                    case 3 -> {
                        System.out.print("Enter new price: ");
                        double price = in.nextDouble();

                        System.out.print("Availability (1 = Available, 0 = Not Available): ");
                        int ch = in.nextInt();
                        in.nextLine();

                        boolean available = (ch == 1);

                        r.getMenu().updateItem(fid, price, available);
                    }

                    default -> System.out.println("Invalid choice!");
                }
            }

            case 4 -> {
                r.getMenu().viewItems();
            }

            case 5 -> System.out.println("Going back...");

            default -> System.out.println("Invalid choice!");
        }

    } while (choice != 5);
}


public void manageOrders(Scanner in) {

    int choice;

    do {
        System.out.println("\n--- Order Management ---");
        System.out.println("1. View All Orders");
        System.out.println("2. View Orders by Restaurant");
        System.out.println("3. Update Order Status");
        System.out.println("4. Back");
        System.out.print("Enter choice: ");

        choice = in.nextInt();
        in.nextLine();

        switch (choice) {

            case 1 -> {
                if (orderList.isEmpty()) {
                    System.out.println("No orders found!");
                } else {
                    for (Order o : orderList.values()) {
                        System.out.println(o);
                    }
                }
            }

            case 2 -> {
                System.out.print("Enter Restaurant ID: ");
                int rid = in.nextInt();
                in.nextLine();

                for (Order o : orderList.values()) {
                    if (o.getRestaurantId() == rid) {
                        System.out.println(o);
                    }
                }
            }

            case 3 -> {
                System.out.print("Enter Order ID: ");
                int oid = in.nextInt();
                in.nextLine();

                Order o = orderList.get(oid);

                if (o == null) {
                    System.out.println("Order not found!");
                } else {
                    System.out.println("1. Preparing");
                    System.out.println("2. Out For Delivery");
                    System.out.println("3. Delivered");

                    int st = in.nextInt();
                    in.nextLine();

                    switch (st) {
                        case 1 -> o.setStatus("Preparing");
                        case 2 -> o.setStatus("OutForDelivery");
                        case 3 -> o.setStatus("Delivered");
                        default -> System.out.println("Invalid status!");
                    }

                    System.out.println("Order updated!");
                }
            }

            case 4 -> System.out.println("Going back...");

            default -> System.out.println("Invalid choice!");
        }

    } while (choice != 4);
}



public void login(Scanner in) {
    System.out.print("Enter username: ");
    String enteredUsername = in.nextLine();
    System.out.print("Enter password: ");
    String enteredPassword = in.nextLine();

    if (enteredUsername.equals(this.username) && enteredPassword.equals(this.password)) {
        System.out.println("Admin login successful!");
        int adminChoice;
        do {
            System.out.println("1. Add Restaurant\n2. Remove Restaurant\n3. view Restaurant\n4. Manage Menu\n5. View Orders\n6. Logout");
            System.out.print("Enter your choice: ");
            adminChoice = in.nextInt();
            switch (adminChoice) {
                case 1 -> {
                    System.out.println("Enter the Restaurant Details : ");
                    System.out.println("Enter restaurant Id : ");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter Restaurant Name : ");
                    String name = in.nextLine();
                    System.out.println("Enter Restaurant Location : ");
                    String location = in.nextLine();
                    System.out.println("Enter the rating : ");
                    double rating = in.nextDouble();
                    addRestaurant(id, name, location, rating);
                }
                case 2 -> {
                    System.out.println("Removing Restaurant...");
                    System.out.print("Enter the id of restaurant to remove:");
                    int rid = in.nextInt();
                    removeRestaurant(rid);
                }
                case 3 -> {
                    System.out.println("Viewing Restaurants...");
                    for(Restaurant r :viewRestaurant().values()){
                        System.out.printf("Id: %d%n Name: %s%n Location: %s%n Rating: %f%n",r.getRestaurantId(),r.getRestaurantName(),r.getRestaurantLocation(),r.getRestaurantRating());
                    }
                }
                case 4 -> {
                    manageMenu(in);
                }
                case 5 -> {
                    manageOrders(in);
                }
                case 6 -> {
                    System.out.println("Logging out...");
                    // break;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

        } while (adminChoice !=6);
    } else {
        System.out.println("Invalid username or password.");
    }
    in.close();
}

}

