import java.util.ArrayList;

public class RefinedIronGenerator extends Generator{

    public RefinedIronGenerator(String name, ArrayList<Resource> constructionCost, int resourceProductionRate, int numberConstructed, Resource RefinedIron){
        super("Iron Refinery", constructionCost, 1, 1, RefinedIron);
    }
}