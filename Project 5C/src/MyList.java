/**
 * @author Natalia Alonso
 * @date April 22, 2014
 * @course COMP 333
 * @assignment Project 5 Part 3
 */

import java.util.*;

public class  MyList <E>
{
   private ArrayList<E> theList;

   public MyList( )
   { 
       //create an empty list  
       theList = new ArrayList<E>();
   }

   public MyList(ArrayList<E> data)
   { 
       theList = data;
   }
   
   public int length()
   { 
       //number of items on list 
       return theList.size();
   }

   
   public boolean empty()
   {   
       return (theList.size() == 0);
   }
   
   public E car ()
   {   
       return theList.get(0);
    }
   
   public MyList<E> cdr()
   { 
       //leaves this unchanged
       MyList<E> temp;
       temp = new MyList<E>((ArrayList<E>)theList.clone());
       temp.theList.remove(0);
       return temp;
   }
   
   public MyList<E> cons(E x)
   {  
       //leaves this unchanged 
       MyList<E> temp;
       temp = new MyList<E>((ArrayList<E>)theList.clone());
       temp.theList.add(0, x);
       return temp;
   }
   
   public String toString()
   { //prints contents of list 
       String output;
       output = "'( ";
       int i;
       for(i =0; i<theList.size();i++){
           output += theList.get(i).toString() + " ";
       }
       output += ")";
       return output;
       
   }
   
   public boolean member (E x)
  {
      
      if( x.equals( this.car() ) ){
        return true;
      }
      else
          this.cdr().member(x);
      
      return false;
       //must be recursive method
       //use equals to test for equality
       //Use only car, cdr and cons to write this method
   }
   
   
   public static void main( String[] args)
   {
         MyList<String> aList = new MyList<String>();
         MyList<String> bList = new MyList<String>();
         System.out.println(aList);
         aList = aList.cons("bananas"); 
         aList = aList.cons("apples");
         aList = aList.cons("oranges"); 
         aList = aList.cons("blueberries");
         bList = aList.cdr();
         bList = bList.cdr();
         System.out.println(aList + "  " + bList);
         String item = "blueberries";
         System.out.println( "Is " + item + " in aList? "  + (aList.member(item)));      
         
         item = "bananas";
         System.out.println( "Is " + item + " in bList? "  + (bList.member(item)));   
         
         while( !aList.empty())
         {
            System.out.print("Removing " + aList.car() + ". aList = ");
            aList = aList.cdr();
            System.out.println(aList);
         }
         
         System.out.println();
         
         MyList<Object> cList = new MyList<Object>();
         MyList<Object> dList = new MyList<Object>();
         System.out.println(cList);
         cList = cList.cons("bananas"); 
         cList = cList.cons("apples");
         cList = cList.cons("oranges"); 
         cList = cList.cons("blueberries");
         dList = cList.cdr();
         dList = dList.cdr();
         System.out.println(cList + "  " + dList);
         Object item2 = "blueberries";
         System.out.println( "Is " + item2 + " in cList? "  + (cList.member(item2)));      
         
         item2 = "bananas";
         System.out.println( "Is " + item2 + " in dList? "  + (dList.member(item2)));   
         
         while( !cList.empty())
         {
            System.out.print("Removing " + cList.car() + ". cList = ");
            cList = cList.cdr();
            System.out.println(cList);
         }
         
         System.out.println();
         
         MyList<Integer> eList = new MyList<Integer>();
         MyList<Integer> fList = new MyList<Integer>();
         System.out.println(eList);
         eList = eList.cons(1); 
         eList = eList.cons(2);
         eList = eList.cons(3); 
         eList = eList.cons(4);
         fList = eList.cdr();
         fList = fList.cdr();
         System.out.println(eList + "  " + fList);
         Integer item3 = 4;
         System.out.println( "Is " + item3 + " in eList? "  + (eList.member(item3)));      
         
         item3 = 1;
         System.out.println( "Is " + item3 + " in fList? "  + (fList.member(item3)));   
         
         while( !eList.empty())
         {
            System.out.print("Removing " + eList.car() + ". eList = ");
            eList = eList.cdr();
            System.out.println(eList);
         }
         
         System.out.println();
      // Put test program here. Systematically test Strings, Integers, Objects         
   }
}  

