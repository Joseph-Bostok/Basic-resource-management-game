    class UsedCar extends Car {

    private double mileage;
    private String condition;

    public UsedCar(int vin, String make, String model, String color, double mileage, String condition){
        super(vin,make, model, color);
        this.mileage = mileage;
        this.condition = condition;

    }
    
    public double getMileage(){
        return mileage;
    }

    public String getCondition(){
        return condition;
    }

    public void setMileage(double mileage){
        this.mileage = mileage;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    @Override
    public void display(){
        super.display();

     System.out.println("Mileage: " + (int)(this.getMileage()));
     System.out.println("Condition: " + getCondition());
    }
    
}