import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    Restaurant restaurant;
    public RestaurantService(Restaurant restaurant){
        this.restaurant=restaurant;
    }
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for (Restaurant restaurant:restaurants){
            if (restaurant.getName().contains(restaurantName))
                return restaurant;
            else
                throw new restaurantNotFoundException("Restaurant not found"+restaurantName);
        }
        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
