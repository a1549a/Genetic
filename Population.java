import java.util.Random;

/**
 * Created by Abdulla on 28.04.2018.
 */
public class Population {
    public Individual aholi[];
    private int n;
    Power power;

    public Population(int n, Power power) {
        this.n = n;
        this.power = power;
        setAholi();
    }

    public void setAholi() {

        aholi = new Individual[n];

        for(int i = 0; i < n; i++){
            aholi[i] = new Individual( n, this.power);
        }

    }

    public int max_haqiqiy_soglomlik(){
        int index = 0;
        for(int i = 1; i < n; i++){
            if(aholi[i].get_haqiqiy_soglomlik() < aholi[index].get_haqiqiy_soglomlik())
                index = i;
        }

        System.out.println(" Eng Katta soglomlik: " + index + "  " + aholi[index].get_haqiqiy_soglomlik());
        return index;
    }

    public Individual tugilish (int index1, int index2){
        Random rn = new Random();
        Individual baby1 = aholi[index1];
        Individual baby2 = aholi[index2];;
        int crossover_point;// = rn.nextInt(n);
        int mxn = 1;
        double  mx_soglomlik = -9999999999999f;
        for(   crossover_point = 1; crossover_point < n-1 ; crossover_point++) {
            baby1 = aholi[index1];
            baby2 = aholi[index2];

            for (int i = crossover_point; i < n; i++)
                baby1.gene[i] = aholi[index2].gene[i];

            for (int i = crossover_point; i < n; i++)
                baby2.gene[i] = aholi[index1].gene[i];

//            baby1.setSoglomlik();
//            baby2.setSoglomlik();
            if(baby1.get_haqiqiy_soglomlik() > mx_soglomlik){
                mx_soglomlik = baby1.get_haqiqiy_soglomlik();
                mxn = crossover_point;
            }

            if(baby2.get_haqiqiy_soglomlik() > mx_soglomlik){
                mx_soglomlik = baby2.get_haqiqiy_soglomlik();
                mxn = crossover_point;
            }


        }
        crossover_point = mxn;
        baby1 = aholi[index1];
        baby2 = aholi[index2];

        for (int i = crossover_point; i < n; i++)
            baby1.gene[i] = aholi[index2].gene[i];

        for (int i = crossover_point; i < n; i++)
            baby2.gene[i] = aholi[index1].gene[i];

//        baby1.setSoglomlik();
//        baby2.setSoglomlik();

            return baby1.get_haqiqiy_soglomlik() > baby2.get_haqiqiy_soglomlik() ? baby1 : baby2;

    }

    public void mutation ( int index){

        Random rn = new Random();

        int mutation_point = rn.nextInt(n);

        for(int i = 0; i < mutation_point; i++)
            aholi[index].gene[i] = (aholi[index].gene[i] + 1) % 2;

//        aholi[index].setSoglomlik();
    }


    public void toString( int index) {
        System.out.print("Populyatsiyadagi eng katta sog'lomlik ");
                for(int i=0;i<n;i++)
                    System.out.print(aholi[index].gene[i]);
                System.out.println(" soglomlik darajasi " + aholi[index].getSoglomlik());
    }
}
