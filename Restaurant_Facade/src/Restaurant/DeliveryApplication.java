package Restaurant;

public class DeliveryApplication {
    private FoodService foodService;
    private PaymentService paymentService;
    private RestaurantService restaurantService;

    public DeliveryApplication(){
        this.foodService = new FoodService();
        this.paymentService = new PaymentService();
        this.restaurantService = new RestaurantService();
    }
    public void processFood(String restaurantName, String restaurantLocation, String cuisineType,String foodName, String paymentType,double amount){
        restaurantService.RestaurantLocation(restaurantName,restaurantLocation);
        foodService.PrepareFood(cuisineType,foodName);
        paymentService.paymentDetails(paymentType,amount);
    }
}
