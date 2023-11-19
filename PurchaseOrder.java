class PurchaseOrder implements Comparable<PurchaseOrder>{

    private String name;
    private int numCars;
    private double offer;

    public PurchaseOrder(String name, int numCars, double offer){
        this.name = name;
        this.numCars = numCars;
        this.offer =  offer;
    }

    public String getName(){
        return name;
    }

    public int getNumCars(){
        return numCars;
    }

    public double getOffer(){
        return offer;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumCars(int numCars){
        this.numCars = numCars;
    }

    public void setOffer(double offer){
        this.offer = offer;
    }
    
    @Override
    public int compareTo(PurchaseOrder other){
           if(this.numCars != other.numCars){
            return (int)(this.numCars - other.numCars);
        }
        else{
            return (int)(this.offer - other.offer);
        }
    }
} 
