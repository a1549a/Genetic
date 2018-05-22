import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdulla on 30.04.2018.
 */
public class Test1 {
    private static List<Individual> aholi;

    public static void main(String[] args) {
         aholi =  new ArrayList<Individual>();
         aholi.add(new Individual(5, new Power(4)));
         
    }
}
