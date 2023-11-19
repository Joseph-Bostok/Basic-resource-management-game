/** 

DO NOT MODIFY THIS CLASS 

*/
import java.util.ArrayList;

public class Car extends Vehicle {

    private String make;
    private String model;
    private String color;

    public Car(
        int vin,
        String make,
        String model,
        String color
    ) {
        super(vin);
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public String getColor(){
        return color;
    }

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override 
    public void display() {
        System.out.println("Make/Model: " + this.getMake() + " / " + this.getModel());
        System.out.println("VIN: " + this.getVin());
        System.out.println("Color: " + this.getColor());
    }

    @Override 
    public String toString() {
        return "Car - " + super.getVin();
    }
}