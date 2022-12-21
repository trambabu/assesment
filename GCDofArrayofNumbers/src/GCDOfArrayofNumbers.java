
/**
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number 
 * that divides both of them. 
 * @author USER
 *
 */
public class GCDOfArrayofNumbers{
   public static int highestCommonFactor(int a,int b){
      int res = 0;
      while (b > 0){
         int temp = b;
         b = a % b;
         a = temp;
         res = a;
      }
      return res;
   }
   public static void main(String arg[]){
      int[] myArray = {2, 4, 6};
      int result = highestCommonFactor(myArray[0],myArray[1]);
      for(int i = 2; i < myArray.length; i++){
         result = highestCommonFactor(result, myArray[i]);
      }
      System.out.println("Gcd of n numbers is: "+result);
   }
}