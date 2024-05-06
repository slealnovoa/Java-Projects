package InsuranceRecord;

public class Life extends Insurance{
	public Life() {

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
