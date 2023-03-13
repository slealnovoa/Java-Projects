package exercise2;
import java.util.Scanner;

public class TestingClass {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
                System.out.println("Please enter type of Game tester want to create(full/part): ");
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("full"))
                {
                	
                    FullTimeGameTester fullTime = new FullTimeGameTester();
                    fullTime.isFullTime = true;
                    System.out.println("Full-time tester salary : "+fullTime.calculateSalary());

                }
                else if(choice.equalsIgnoreCase("part"))
                {
                	PartTimeGameTester partTime = new PartTimeGameTester();
                    System.out.println("Enter working hours: ");
                    double hours = Double.parseDouble(scan.nextLine());
                    partTime.isFullTime = false;
                    partTime.setTotalHours(hours);
                    System.out.println("Part-time salary : "+partTime.calculateSalary());

                }
                else
                {
                        System.out.println("The choice is invalid");
                        continue;
                }
                System.out.println("Do you need an extra record(yes/no): ");
                String next = scan.nextLine();
                if(next.equalsIgnoreCase("yes"))
                {
                        continue;
                }
                else
                {
                        return;
                }
        }

}


}
