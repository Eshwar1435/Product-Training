public class Restaurant{
    private int restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private double restaurantRating;
    private Menu menu = new Menu();

    public Menu getMenu() {
        return menu;
    }
    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public String getRestaurantLocation() {
        return restaurantLocation;
    }
    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }
    public double getRestaurantRating() {
        return restaurantRating;
    }
    public void setRestaurantRating(double restaurantRating) {
        this.restaurantRating = restaurantRating;
    }

}