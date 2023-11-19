public class People extends Resource {
    

    public People(String name, int quantity, boolean isCritical){
        super("People", quantity, true);

    }
    /**
    * The people resource is a critical resource!
   */
    @Override
      public void setIsCrticial(boolean isCritical){
        this.isCritical = isCritical;
    }
    
    @Override
    public int scoreImpact(){
        return quantity;
    }

    @Override
    public boolean isCritical(){
        return isCritical;
    }
}