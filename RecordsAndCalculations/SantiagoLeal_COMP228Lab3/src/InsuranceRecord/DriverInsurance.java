package exercise1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverInsurance {
	public static void main(String[] args) {

		@SuppressWarnings("unused")
		List<Insurance> list = new ArrayList<>();

		try (Scanner sc = new Scanner(System.in)) {
			String choice="";

			while(true) {

			Insurance ins=null;

			System.out.println("Do you want to enter a record? (yes/no)");

			choice= sc.nextLine();

			if(choice.equalsIgnoreCase("no"))

			break;

			System.out.println("Enter type of insurance: ");

			String type=sc.nextLine();

			System.out.println("Enter monthly amount: ");

			double cost=sc.nextDouble();

			sc.nextLine();

			if(type.equalsIgnoreCase("health")) {

			ins=new Health();

			ins.setMonthlyCost(cost);

			ins.displayInfo();

			}

			else if(type.equalsIgnoreCase("life")) {

			ins=new Life();

			ins.setMonthlyCost(cost);

			ins.displayInfo();

			}

			}
		}

		}

		}


