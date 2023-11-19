import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 * The TextManagementGame class represents a text-based management game where the player manages resources and resource generators.
 */
public class TextManagementGame {
    // Define game variables
    private int round;
    private ArrayList<Resource> resources = new ArrayList<Resource>();
    private ArrayList<Generator> generators = new ArrayList<Generator>();
    private ArrayList<Resource> constructionCost = new ArrayList<Resource>();
    private ArrayList<Resource> ironMineCost = new ArrayList<Resource>();
    private ArrayList<Resource> hospitalCost = new ArrayList<Resource>();
    private ArrayList<Resource> ironRefineryCost = new ArrayList<Resource>();
    private RawIron RawIron;
    private RefinedIron RefinedIron;
    private People People;
    private PeopleGenerator PeopleGenerator;
    private RefinedIronGenerator RefinedIronGenerator;
    private RawIronGenerator RawIronGenerator;

    // Define a Scanner for user input
    private Scanner scanner;

    /**
     * Creates a new TextManagementGame instance with initial resource and time values.
     * 
     */
    public TextManagementGame() {
        round = 1;       // Start at time 1
        scanner = new Scanner(System.in);

        this.RawIron  = new RawIron("Raw Iron", 100, false);
        this.RefinedIron = new RefinedIron("RefinedIron", 50,false);
        this.People = new People("People", 20, true);

        resources.add(this.RawIron);
        resources.add(this.RefinedIron);
        resources.add(this.People);
        ironMineCost.add(this.RawIron);
        ironRefineryCost.add(this.RefinedIron);
        hospitalCost.add(this.People);
    }// remember to add costs to these! int ironMineCOst = 10; or whatever.

    /**
     * Check if a method should run with a 1 in number chance.
     *
     * @return true if the method should run, false otherwise
     */
    public boolean haveEventThisTurn(int number) {
        Random random = new Random();
        int chance = random.nextInt(number); // Generates a random number between 0 (inclusive) and number (exclusive)
        return chance == 0; // Returns true with a 1 in number chance
    }

    /**
    * Prints the list of resources
    */
    public void viewResources(){
        for(Resource r : resources){
            System.out.println(r);
        }
    }

    /**
    * Prints the list of Generators
    */
    public void viewGenerators(){
        for(Generator b : generators){
            System.out.println(b);
            
        }
        
    }
    /**
    * Saves the current game files!
    */
    public void saveGame(){
        try(PrintWriter writer = new PrintWriter(new FileOutputStream("resource_game_save.txt"))){
            writer.println(round);
            for (Resource r : resources) {
                writer.println(r.getName() + ", " + r.getQuantity() +  ", " + r.isCritical());
            }
            for (Generator g : generators){
                writer.println(g.getName() + "," + g.getConstructionCost() + ", " + g.getResourceProductionRate() + ", " + g.getNumberConstructed());
            }
            
         } catch(FileNotFoundException e){
             System.out.println("Error, game could not be saved." + e.getMessage());
         }
    }

      /*  public void loadGame(){
            try(Scanner scanner = new Scanner(new File("resource_game_save.txt"))){
            if(scanner.hasNextLine()){
                round = Integer.parseInt(scanner.nextLine());
            }
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String resourceName = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                boolean isCritical = Boolean.parseBoolean(parts[2]);
                resources.add(new RawIron(resourceName, quantity, isCritical));
                resources.add(new RefinedIron(resourceName, quantity, isCritical));
                resources.add(new People(resourceName, quantity, isCritical));
            }
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] genParts = line.split(",");
                String generatorName = genParts[0];
                ArrayList getConstructionCost = ArrayList.parseArrayList(genParts[1]);
                int resourceProductionRate = Integer.parseInt(genParts[2]);
                int numberConstructed = Integer.parseInt(genParts[3]);
                generators.add(new RawIronGenerator(generatorName, constructionCost, resourceProductionRate, numberConstructed, resource));
                generators.add(new RefinedIronGenerator(generatorName, constructionCost, resourceProductionRate, numberConstructed,resource));
                generators.add(new PeopleGenerator(generatorName, constructionCost, resourceProductionRate, numberConstructed, resource));
            }
        }   catch(FileNotFoundException e ){
            System.out.println("Error, game could not be saved." + e.getMessage());
            }
        }
        */

        /**
        *  Checks if the player has enough resources to build something
        *  @param arraylist to store the costs, and a local variable for a required amount set in the constructors
        */
    private boolean hasSufficientResources(ArrayList<Resource> cost, int requiredAmount) {
    for (Resource costItem : cost) {
        for (Resource playerResource : resources) {
            if (playerResource.getName().equalsIgnoreCase(costItem.getName()) && 
                playerResource.getQuantity() >= requiredAmount) {
                return true;
            }
        }
    }
    return false;
}


    /**
    * Deducts resources from the players invetory when building a generator.
    * @param arralist for the cost and a local int variale to deduct a specific amount
    */
    private void deductResources(ArrayList<Resource> cost, int amountToDeduct) {
        for (Resource costItem : cost) {
            for (Resource playerResource : resources) {
                if (playerResource.getName().equalsIgnoreCase(costItem.getName())) {
                playerResource.consume(amountToDeduct);
                break;
                }
            }
        }
    }

    /**
     * Checks if a Generator can be constructed and then adds it to the list of Generators
     * 
     */
   public void constructGenerator() {
    System.out.println("Select a generator to construct");
    System.out.println("1.) Raw Iron Mine");
    System.out.println("2.) Iron Refinery");
    System.out.println("3.) Hospital");

    int choice = scanner.nextInt();

   ArrayList<Resource> ironMineCost = new ArrayList<>();
    ironMineCost.add(new RawIron("Raw Iron", 10, false)); 

    ArrayList<Resource> ironRefineryCost = new ArrayList<>();
    ironRefineryCost.add(new RefinedIron("Raw Iron", 20, false)); 

    ArrayList<Resource> hospitalCost = new ArrayList<>();
    hospitalCost.add(new People("People", 5, true)); 

 
    switch (choice) {
        case 1:
            if (hasSufficientResources(ironMineCost,1)) {
                deductResources(ironMineCost,10);
                Generator rawIronGenerator = new RawIronGenerator("Iron Mine", ironMineCost, 1, 2, RawIron);
                generators.add(rawIronGenerator);
                System.out.println("\nYou have successfully added an Iron mine!");
            } else {
                System.out.println("Not enough resources to construct Iron Mine.");
            }
            break;

        case 2:
            if (hasSufficientResources(ironRefineryCost,1)) {
                deductResources(ironRefineryCost,20);
                Generator refinedIronGenerator = new RefinedIronGenerator("Iron Refinery", ironRefineryCost, 3, 1, RefinedIron);
                generators.add(refinedIronGenerator);
                System.out.println("\nYou have successfully added an Iron refinery!");
            } else {
                System.out.println("Not enough resources to construct Iron Refinery.");
            }
            break;

        case 3:
            if (hasSufficientResources(hospitalCost,1)) {
                deductResources(hospitalCost,15);
                Generator peopleGenerator = new PeopleGenerator("Hospital", hospitalCost, 5, 1, People);
                generators.add(peopleGenerator);
                System.out.println("\nYou have successfully added a Hospital!");
            } else {
                System.out.println("Not enough resources to construct a Hospital.");
            }
            break;

        default:
            System.out.println("Invalid choice, please try again.");
            return;
    }

    System.out.println("\n-------------------------------------------------");
    System.out.println("Select another option, or end your turn.");
}



    /** 
     * Increments the time counter and then adds more resources based on what generators are present
     * 
     */
    public void endRound() {
    round++;
    for (Generator generator : generators) {
        int productionRate = generator.getResourceProductionRate();
        Resource producedResource = generator.getProduct();

        for (Resource resource : resources) {
            if (resource.getName().equalsIgnoreCase(producedResource.getName())) {
                resource.add(productionRate);
                break;
            }
        }
    }
    }

    /**
     * Adds a Generator object to the ArrayList of Generators.
     *
     * @param Generator the Generator object to add
     */
    public void addGenerator(Generator generator) {
        generators.add(generator);
    }

    /**
     * Adds a Resource object to the ArrayList of resources.
     *
     * @param resource the Resource object to add
     */
    public void addResource(Resource resource) {
        System.out.println("Please select 1 to add raw iron to your inventory.");
        System.out.println("1.) Add Raw Iron");
        int choice = scanner.nextInt();

           switch (choice){

                case 1:
                break;
            }

        resources.add(resource);
    }

    /**
     * Checks if we are out of any critical resources
     *
     * @return returns true if we are out of any critical resources returns false otherwise
    */
    public boolean isCriticalResourceEmpty(){
        for(Resource r : resources){
            if(r.isCritical() && r.getQuantity() == 0){
                return true;
            }
        }
        return false;
    }
   /**
    * checks current score 
   */
    public int CurrentScore(){
        return resources.size(); 
    }

   /**
    * player can manually add raw iron to there RawIron quantity.
    * 
   */
    public void addRawIron(){
        System.out.println("How much Raw Iron would you like to mine?");
        int amount = scanner.nextInt();

        if(amount <0){
            System.out.println("Invalid amount");
            return;
        }

        for (Resource resource : resources){
            if (resource.getName().equalsIgnoreCase("Raw Iron")){
                resource.add(amount);
                System.out.println("----------------------------------------------------------");
                System.out.println(amount + " Units of Raw Iron were added to your inventory");
                return;
            }
        }
        System.out.println("Raw Iron resource not found.");
    }

    /**
     * Starts the game and manages the game loop.
     */
    public void start() {
        System.out.println("Welcome, you are managing a colony of miners. Collect Iron and try to increase your population. Best of luck!"); 
        int oddsOfRandomEvent = 4; //a 25% chance of a random event occuring

        // Main game loop
        while (!isCriticalResourceEmpty()) {
            System.out.println("\nDay " + round);
            if(haveEventThisTurn(oddsOfRandomEvent)){
                System.out.println("A random event happened!");
                /**
                * 2 events can occur per round with a 25% chance of happening. any resource can be removed or added via random amount.
                */
                Random random = new Random();
                if(!resources.isEmpty()){
                    int randomIndex = random.nextInt(resources.size());
                    Resource affectedResource = resources.get(randomIndex);
                    boolean boost = random.nextBoolean();
                    int amount = random.nextInt(25) +1;

                    if(boost){
                        affectedResource.add(amount);
                        System.out.println("Hooray! you found " + affectedResource.getName() + ". Your quantity has been increased by " + amount + ".");
                    } else{
                        affectedResource.consume(amount);
                        System.out.println("Yikes! some of your " + affectedResource.getName() + " has been lost. Your Quantity has been decreased by " + amount + ".");
                    }
                } else {
                    System.out.println("A random event happened, but there were no resources to affect!");
            }
        }
            System.out.println("Options:");
            System.out.println("\n1. Collect Raw Iron");
            System.out.println("2. Manage Resources and Generators (Current Score)");
            System.out.println("3. Add a new Generator");
            System.out.println("4. End round");
            System.out.println("5. Quit game");
            System.out.println("6. Save game");
            //System.out.println("5. Load game");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                addRawIron();
                    break;
                case 2:
                    System.out.println("Generators:__________________________________________________ ");
                    viewGenerators();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("\nResources___________________________________________________");
                    viewResources();
                    System.out.println("--------------------------------------------------------------");
                    break;
                case 3: 
                    constructGenerator();
                    break;
                case 4:
                    endRound();
                    break;
                case 5:
                 System.out.println("\nYou played for " + round + " rounds");
                 System.out.println("\nFinal Resources Collected / total score:");
                 System.out.println("--------------------------------------------------------------");
                 viewResources();
                 CurrentScore();
                 System.exit(0);
                    break;
                    case 6:
                    saveGame();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nGame Over! You ran out of resources.");
        System.out.println("\tYou played for " + round + " rounds");
        System.out.println("\nFinal Resources Collected / total score:");
        System.out.println("--------------------------------------------------------------");
        viewResources();
        System.out.println(CurrentScore());
    }

    /**
     * Main method to run the game
     *
     * @param args the command-line arguments (not used in this game)
     */
    public static void main(String[] args) {
        TextManagementGame game = new TextManagementGame();
        game.start();
    }
}