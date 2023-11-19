public class RefinedIron extends Resource {
    
    public RefinedIron(String name, int quantity, boolean isCritical){
        super("Refined Iron", quantity, false);

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