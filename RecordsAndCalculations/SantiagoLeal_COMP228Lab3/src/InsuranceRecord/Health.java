package exercise1;

public class Health extends Insurance{
	
	public Health() {

		super("health");

		}

		@Override

		public void setInsuranceCost(double cost) {

		super.setMonthlyCost(cost);

		}

		@Override

		public void displayInfo() {

		System.out.println("Insurance:\n\ttype: "+this.getTypeInsurance()+"\n\tMonthly Cost: "+this.getMonthlyCost());

		}

}
