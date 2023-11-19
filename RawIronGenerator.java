import java.util.ArrayList;
public class RawIronGenerator extends Generator{
    
    public RawIronGenerator(String name, ArrayList<Resource> constructionCost, int resourceProductionRate, int numberConstructed, Resource RawIron){
        super("Iron Mine", constructionCost, 1, 1, RawIron);
    }
    
}