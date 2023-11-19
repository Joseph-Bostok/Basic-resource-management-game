/** 

DO NOT MODIFY THIS CLASS 

*/
public abstract class Vehicle {

    private int vin;

    public Vehicle(int vin) {
        this.vin = vin;
    }

    public abstract void display();

    public int getVin() {
        return vin;
    }

    @Override 
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.getVin() == ((Vehicle)other).getVin();
    }

}
