

public class BusinessCollege extends College{
	public BusinessCollege(String name, String address, String accreditation, int noOfCourses) {

        super(name, address, accreditation, noOfCourses);

    }

   
	//override methods
	@Override
	
		public void setFees(double fees) {
			this.fees=fees;

    }

   

	@Override
	
		public String getProgram() {
		
			return "Business Program";

    }
}

