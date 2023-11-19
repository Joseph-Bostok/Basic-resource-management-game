import java.util.ArrayList;

/**
 * The Generator class represents a generic resource generating item in the game.
 * Generators have a name, a construction cost, and a resource production rate.
 */
abstract class Generator implements Score{
    protected String name;
    protected ArrayList<Resource> constructionCost;
    protected int resourceProductionRate;
    protected int numberConstructed;
    protected Resource product;

    /**
     * Creates a new Generator with the given name, construction cost, and resource production rate.
     *
     * @param name                  the name of the Generator
     * @param constructionCost      the cost in resources required to construct the Generator
     * @param resourceProductionRate the rate at which the Generator produces resources per unit of time
     * @param numberConstructed     the number of units of this generator constructed at this time
     * @param product               the type of resource this generator produces
     */
    public Generator(String name, ArrayList<Resource> constructionCost, int resourceProductionRate, int numberConstructed, Resource product) {
        this.name = name;
        this.constructionCost = constructionCost;
        this.resourceProductionRate = resourceProductionRate;
        this.numberConstructed = numberConstructed;
        this.product = product;
    }

    /**
     * Gets the name of the Generator.
     *
     * @return the name of the Generator
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the construction cost of the Generator.
     *
     * @return the construction cost of the Generator
     */
    public ArrayList<Resource> getConstructionCost() {
        return constructionCost;
    }

    /**
     * Gets the resource production rate of the Generator.
     *
     * @return the resource production rate of the Generator
     */
    public int getResourceProductionRate() {
        return resourceProductionRate;
    }

    /**
     * Gets the number of units constructed of this Generator.
     *
     * @return the number of units constructed of the generator
     */
    public int getNumberConstructed() {
        return numberConstructed;
    }

    /**
    * toString to pring out what the generator has
   */
    @Override
    public String toString(){
        return "Generator: " + name + " Resource production: " + resourceProductionRate + " Number constructed: " + numberConstructed;
    }

    /**
    * score for gemerators is the amount that has been constructed 
   */
     public int scoreImpact(){
        return numberConstructed;
    }

    /**
    * gets the product resource the generator is "creating"
   */
    public Resource getProduct() {
        return this.product;
    }

}