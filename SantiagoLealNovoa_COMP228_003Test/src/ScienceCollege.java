public class ScienceCollege extends College {

	public ScienceCollege(String name, String address, String accreditation, int noOfCourses) {

        super(name, address, accreditation, noOfCourses);

    }

   
	//Override methods
    @Override

    public void setFees(double fees) {
		this.fees = 1.1 * fees;

    }

   

    @Override

    public String getProgram() {
		return "Science Program";

    }
}
