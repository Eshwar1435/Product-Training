// (original file was empty)
class Order {
    private int orderId;
    private String customerName;
    private int restaurantId;
    private double totalAmount;
    private String status;

    public Order(int orderId, String customerName, int restaurantId, double totalAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getRestaurantId() { return restaurantId; }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId +
                ", Customer: " + customerName +
                ", RestaurantID: " + restaurantId +
                ", Amount: " + totalAmount +
                ", Status: " + status;
    }
}