package exercise3;
import java.util.Scanner;

public class ProcessMortgage {
	 public static void main(String[] args) {
	      
         Mortgage mortgages[] = new Mortgage[3];
        
         double interestRate;
         int mortgageNumber;
         String customerName;
         double mortgageAmount;
         int term;
         String mortgageType;
         Scanner scan = new Scanner(System.in);
        
         System.out.print("Enter current interest rate: ");
         interestRate =scan.nextDouble();
         scan.nextLine();
        
         for(int i=0;i<mortgages.length;i++)
         {
                System.out.print("Mortgage Type (Personal or Business): ");
                mortgageType = scan.nextLine();
                while(!mortgageType.equalsIgnoreCase("Personal") && !mortgageType.equalsIgnoreCase("Business"))
                {
                       System.out.print("The Mortgage type entered is not valid. Please enter a valid typ (Business/Personal): ");
                       mortgageType = scan.nextLine();
                }
               
                System.out.print("Mortgage Number: ");
                mortgageNumber = scan.nextInt();
                scan.nextLine();
                System.out.print("Customer Full Name: ");
                customerName = scan.nextLine();
                System.out.print("Mortgage Amount: ");
                mortgageAmount = scan.nextDouble();
                System.out.print("Mortgage Term: ");
                term = scan.nextInt();
                scan.nextLine();
               
                if(mortgageType.equalsIgnoreCase("Personal"))
                       mortgages[i] = new PersonalMortgage(mortgageNumber,customerName,mortgageAmount,interestRate,term);
                else
                       mortgages[i] = new BusinessMortgage(mortgageNumber,customerName,mortgageAmount,interestRate,term);
         }
        
         System.out.println(" Details of Mortgages : ");
         for(int i=0;i<mortgages.length;i++)
         {
                mortgages[i].getMortgageInfo();
                System.out.println();
         }
         scan.close();
   }
}


