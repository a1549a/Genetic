import java.util.*;
/**
 * Created by Abdulla on 28.04.2018.
 */
public class Individual {
    private double soglomlik = 0;
    public int[] gene;
    private int n;
    private Power Individualpower ;

    public Individual(int n, Power individualpower) {
        this.n = n;
        this.Individualpower = individualpower;
        setGene();
        //setSoglomlik();
    }

    public void setGene() {
        Random rn = new Random();
        gene = new int[n];
        for(int i=0;i<n;i++)
        this.gene[i]=rn.nextInt(2);
    }


    public void setSoglomlik() {
            soglomlik = 0;
         for(int i=0;i<n;i++)
                if(gene[i] == 1) soglomlik += Individualpower.power[i];
    }

    public double get_haqiqiy_soglomlik( ){
        double sum = 0, sum1 = 0;

        for(int i = 0; i < n; i++)
                if(gene[i] == 1) {
                     sum += Individualpower.getA(i);
                     sum1 += Individualpower.getB(i);
                }

        return sum/sum1;
    }
    public double getSoglomlik() {
        return soglomlik;
    }
}
