package project1;

import java.util.Scanner;

/**
 *
 * @author Natalia Alonso
 * COMP 333 Spring 2014
 */
public class LinearRegression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*  
         *   *   *   *   VARIABLE LIST *   *   *   *
               S1 - Sum of X values
               S2 - Sum of Y values
               S3 - Sum of X * Y
               S4 - Sum of X * X
               S5 - Sum of Y * Y
               D  - Sum of Y(obs) - Y(calc) squared
               S  - Slope
               B  - Y-intercept
               E1 - Error in the slope
               E2 - Error in the intercept
               T  - Beta function for linear regression
               R  - Correlation coefficient

       Error function uses (N-2) weighting
         */
        double[] X = new double[52];
        double[][] Y = new double[3][52];
        char[] LITERL = new char[2];
        int N;                                  
        int I = 0;     
        double S1 = 0; 
        double S2 = 0;
        double S3 = 0;
        double S4 = 0;
        double S5 = 0;
        double D = 0;
        double S = 0;
        double B = 0;
        double E1 = 0;
        double E2 = 0;
        double T = 0;
        double R = 0;
        
        System.out.format("%1s","*   *   *   LINEAR REGRESSION ANALYSIS *    *   *\n\n");
        System.out.format("%1s","HOW MANY PAIRS NEED TO BE ANALYZED? ");
        Scanner s = new Scanner(System.in);
        
        N = s.nextInt();
        if( N > 50){
            System.out.format("%1s","At present this program can only handle 50 data pairs.");
            return;
        }else{
            System.out.format("%1s","\n\nEnter one pair at a time");
            System.out.format("%1s","and separate X from Y with a comma.\n\n");
            System.out.format("%1s","\nEnter pair number 1: ");
            s.useDelimiter("[\\s,]");
            X[1] = s.nextDouble();
            Y[1][1] = s.nextDouble();
            for(I = 2; I <= N; I++){
                System.out.print("Enter pair number " + I + ": ");
                X[I] = s.nextDouble();
                Y[1][I] = s.nextDouble();
            }
        }
        System.out.format("%1s","Would you like to review the data? ");
        String c;
        s.reset();
        c = s.next();
        c = c.substring(0, 1).toLowerCase();
        if(c.toCharArray()[0] != 'n'){
            for(I = 1; I <= N; I++){
                System.out.format("\nDATA PAIR %d) %20.10f,%20.10f",I,X[I],Y[1][I]);
            }
        }
        
        System.out.format("%1s","\nWould you like to make any changes? ");
        c = s.next();
        c = c.substring(0, 1).toLowerCase();
        if(c.toCharArray()[0] != 'n'){
            System.out.format("%1s","To change a data pair, enter the");
            System.out.format("%1s","\nPair number and the new X,Y pair.");
            System.out.format("%1s","\nHow many changes shall we make? ");
            s.useDelimiter("\n");
            int ICHANG = s.nextInt();
             s.reset();
            for(I = 1; I <= ICHANG; I++){
                System.out.format("%1s","CHANGE NUMBER: ");
                int C1 = s.nextInt();
                s.useDelimiter(("[\\s,]"));
                double C2 = s.nextDouble();
                double C3 = s.nextDouble();
                s.reset();
                X[C1] = C2;
                Y[1][C1] = C3;
            }
        }
        for(I = 1; I <= N; I++){
            S1 = S1 + X[I];
            S2 = S2 + Y[1][I];
            S3 = S3 + X[I]*Y[1][I];
            S4 = S4 + X[I]*X[I];
            S5 = S5 + Y[1][I]*Y[1][I];
        }
        T = N*S4 - S1*S1;
        S = (N*S3 - S1*S2)/T;
        B = (S4*S2 - S1*S3)/T;
        for(I=1; I <=N; I++){
            Y[2][I] = S*X[I]+B;
            D = D + Math.pow((Y[2][I] - Y[1][I]),2);
        }
        D = D/(N-2);
        E1 = Math.sqrt(D*N/T);
        E2 = Math.sqrt(D/N*(1+S1*S1/T));
        R = (N*S3 - S1*S2)/(Math.sqrt(Math.abs(((N*S4-Math.pow(Math.abs(S1),2)))*(N*S5 - Math.pow(Math.abs(S2), 2)))));
        System.out.format("\n\n\n\n%10s %20s %22s","X-VALUE","Y-OBS","Y-CALC");
        System.out.format("\n%10s %20s %22s","=======","=====","======");
        for(I = 1; I <= N; I++){
            System.out.format("\n%10.10f %20.10f %22.10f",X[I],Y[1][I],Y[2][I]);
        }
        System.out.format("\n\nSLOPE = %22.16f",S);
        System.out.format("\nTHE ERROR IN THE SLOPE IS +/- %22.16f",E1);
        System.out.format("\n\nINTERCEPT = %22.16f",B);
        System.out.format("\nTHE ERROR IN THE INTERCEPT IS +/- %22.16f",E2);
        c = "+";
        if(Math.abs(B) != B){
            c = "-";
        }
        System.out.println("\n\nTHE EQUATION FOR BEST LINEAR FIT IS: ");
        double BBAR = Math.abs(B);
        System.out.format("Y(X) = %25.16fX %s %25.16f\n\n\n",S,c,BBAR);
        System.out.format("LINEAR CORRELATION COEFFICIENT = %22.16f",R);
        System.out.format("\nLINEAR... Execution completed");
    }
}
