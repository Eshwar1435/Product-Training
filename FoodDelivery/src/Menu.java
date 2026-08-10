import java.util.HashMap;

class Menu {
    private HashMap<Integer, FoodItem> items = new HashMap<>();

    public void addItem(FoodItem item) {
        items.put(item.getFoodId(), item);
    }

    public void removeItem(int id) {
        items.remove(id);
    }

    public void updateItem(int id, double price,boolean available) {
        FoodItem item = items.get(id);
        if (item != null) {
            item.setPrice(price);
            item.setAvailable(available);
        } else {
            System.out.println("Item not found!");
        }
    }
    public void updatePrice(int id, double price) {
    FoodItem item = items.get(id);
    if (item != null) {
        item.setPrice(price);
    } else {
        System.out.println("Item not found!");
    }
}

public void updateAvailability(int id, boolean available) {
    FoodItem item = items.get(id);
    if (item != null) {
        item.setAvailable(available);
    } else {
        System.out.println("Item not found!");
    }
}
public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("Menu is empty!");
            return;
        }
        for (FoodItem item : items.values()) {
            System.out.println("ID: " + item.getFoodId() +
                    " Name: " + item.getName() +
                    " Price: " + item.getPrice());
        }
    }
}