import java.util.ArrayList;

public class PeopleGenerator extends Generator{
    
    public PeopleGenerator(String name, ArrayList<Resource> constructionCost, int resourceProductionRate, int numberConstructed, Resource People){
        super("Hospital", constructionCost, 1, 1, People);
    }

}