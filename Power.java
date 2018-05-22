import java.util.Scanner;
/**
 * Created by Abdulla on 28.04.2018.
 */
public class Power {
    private int n;
    public double power[];
    public double power1[];
    private int a[];
    private int b[];

    public Power(int n) {
        this.n = n;
        a = new int [n];
        b = new int [n];
        setAB();
        setPower();
    }

    public void setAB(){
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<n;i++)
                a[i] = sc.nextInt();

        for(int i=0;i<n;i++)
                b[i] = sc.nextInt();
    }


    public void setPower(){

        power = new double[n];
        power1 = new double[n];

        for(int i=0;i<n;i++){
              power[i] = a[i]*1.0/b[i];
              power1[i] = a[i]*1.0/b[i];
          }

          double minn = power[0];

        for(int i=0;i<n;i++)
                if( minn < power[i])minn=power[i];

        for(int i=0;i<n;i++)power[i]/=minn;

    }

    public int getA(int index) {
        return a[index];
    }

    public int getB(int index) {
        return b[index];
    }
}
