
import java.util.Random;
import java.util.Scanner;
public class randomsayitahmini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Random rnd = new Random();
         Scanner input = new Scanner(System.in);
         
         int Correct = 0;
         int Wrong = 0;
        
         for (int i = 1; i <= 6; i++) {
            int num = rnd.nextInt(3); // 0 - 50
            
        
         System.out.print("Enter your guess between 0-50: ");
         int Guess = input.nextInt();
         
         
             if (Guess == num) {
                 System.out.println("CORRECT ");
                 Correct++;
                    
             } else {
                 System.out.println("WRONG ");
                 Wrong++;           
    
             
                
            
            System.out.println(i + ".Number: " +num);
        }
    }
         System.out.println("TOTAL CORRECT" +Correct);
         System.out.println("TOTAL WRONG" +Wrong);
  } 
}

