/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natalia
 */
class StudentHS
{
   String name;
   int[] testGrades; 
  
   public StudentHS ( String n, int[] tests )
   {
         name = n;   testGrades = tests;
   }
   
   public String toString()
   {
      String s = name + "  " + testGrades[0] +
             "  "  + testGrades[1];
      return s;
   }
   
   public Object clone()
   {
         return new StudentHS(name, testGrades);
   }

}
   
public class TestingStudentHS
{
      
      public static void main(String[] args)
      {
         int[] t1 = { 89 , 67};
         int[] t2 = {90, 81};
         StudentHS s1 = new StudentHS("Thomas", t1);
         StudentHS s2 = new StudentHS("Jenny" , t2);
         
         System.out.println(s1 + " / " + s2);
         StudentHS s3 = (StudentHS)s1.clone();
         int[] t3 = s1.testGrades.clone();
         s3.testGrades = t3;
         s3.testGrades[0] = 78;         // This line edits the array data references by s1 and s3
         s3.name = "Tim";
         System.out.println(s1 + " / " + s2 + " / " + s3);    

      }
}

