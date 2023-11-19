public class RawIron extends Resource{
    

    public RawIron(String name, int quantity, boolean isCritical){
        super("Raw Iron", quantity, false);

    }

     @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int scoreImpact(){
        return quantity;
    }

    @Override
      public void setIsCrticial(boolean isCritical){
        this.isCritical = isCritical;
    }

    
}