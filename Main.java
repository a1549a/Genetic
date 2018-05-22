import java.util.Random;
import java.util.Scanner;
/**                                                                u
 * Created by Abdulla on 28.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        n = sc.nextInt();
        
        Power Powerone = new Power(n);

        Population Aholi = new Population( n, Powerone);

        Individual unumli_avlod = Aholi.aholi[0];

        int count_population = 10 * n + 1;

        while( (count_population--) > 0) {

            int father_index = 0;
            int mother_index;

            for (int i = 1; i < n; i++) {
                if (Aholi.aholi[i].get_haqiqiy_soglomlik() > Aholi.aholi[father_index].get_haqiqiy_soglomlik())
                    father_index = i;
            }

            mother_index = (father_index + 1) % n;
            for (int i = 0; i < n; i++) {
                if (Aholi.aholi[i].get_haqiqiy_soglomlik() > Aholi.aholi[mother_index].get_haqiqiy_soglomlik() && father_index != i)
                    mother_index = i;
            }
            

            int kasal_index=0;
            for (int i = 1; i < n; i++) {
                if (Aholi.aholi[i].get_haqiqiy_soglomlik() <= Aholi.aholi[kasal_index].get_haqiqiy_soglomlik())
                    kasal_index = i;
            }

            Aholi.aholi[kasal_index] = Aholi.tugilish(father_index, mother_index);

            if( count_population % 4 == 0)
                    Aholi.mutation(kasal_index);

            System.out.println(" Ota " + father_index + " Ona " + mother_index + " Kasal " + kasal_index);
            int index3 = Aholi.max_haqiqiy_soglomlik();
            if(unumli_avlod.get_haqiqiy_soglomlik() < Aholi.aholi[index3].get_haqiqiy_soglomlik())
                unumli_avlod = Aholi.aholi[index3];
        }

        
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(unumli_avlod.gene[i]);
        }
        System.out.print("  " + unumli_avlod.get_haqiqiy_soglomlik());

    }
}
