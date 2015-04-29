/**
 * @author Natalia Alonso
 * @date April 22, 2014
 * @course COMP 333
 * @assignment Project 5 Part 1
 */
public class Print {

    /**
     * @param args the command line arguments
     */
    public static void printer(int x, int y, int z){
    
        System.out.format("First parameter: %d \n",x);
        System.out.format("Second parameter: %d \n",y);
        System.out.format("Third parameter: %d \n",z);}
    
    public static void main(String[] args) {
        int n = 1;
        System.out.println("n is first parameter, n++ is second parameter, n++ is third parameter");
        printer(n,n++,n++);
        
        n = 1;
        System.out.println("\nn++ is first parameter, n is second parameter, n++ is third parameter");
        printer(n++,n,n++);
        
        n = 1;
        System.out.println("\nn++ is first parameter, n++ is second parameter, n is third parameter");
        printer(n++,n++,n);        
    }
}
