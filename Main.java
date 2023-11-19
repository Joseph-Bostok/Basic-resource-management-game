import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------------------");

        Car car1 = new UsedCar(
            90001,
            "Traveler",
            "Empire",
            "Dark Blue",
            32000,
            "Good"
        );

        car1.display();
        System.out.println("--------------------------");
        PurchaseOrder order1 = new PurchaseOrder(
            "Charlotte Used Automotive",
            4,
            95000.0
        );

        PurchaseOrder order2 = new PurchaseOrder(
            "East Charlotte Used Motors",
            7,
            160000.0
        );
        int orderComparison = order1.compareTo(order2);
        if (orderComparison > 0) {
            System.out.println(
                "Order 1 is for more vehicles than order 2"
            );
        } else if (orderComparison < 0) {
            System.out.println(
                "Order 2 is for more vehicles than order 1"
            );
        } else {
            System.out.println("Both orders are for the same number of vehicles");
        }
    }
}