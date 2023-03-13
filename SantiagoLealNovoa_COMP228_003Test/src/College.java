public abstract class College {

	//declaring variables
	
	private String name;
	private String address;
	private String accreditation;
	protected double fees;
	private int noOfCourses;

	//initialize variables
	
	public College(String name, String address, String accreditation, int noOfCourses) {
		super();
			this.name = name;
			this.address = address;
			this.accreditation = accreditation;
			this.noOfCourses = noOfCourses;
	}	
	
	//setters and getters
	
	public String getName() {
		return name;
	}

	public String getAddress() {
			return address;
	}

	public String getAccreditation() {
		return accreditation;
	}

	public double getFees() {
		return fees;
	}

	public int getNoOfCourses() {
		return noOfCourses;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}

	public abstract void setFees(double fees);

	public void setNoOfCourses(int noOfCourses) {
		this.noOfCourses = noOfCourses;
	}

	public abstract String getProgram();

	//toString method
	
	@Override
		public String toString() {
			return "Name : " + name + "\nAddress : " + address + "\nAccreditation : " + accreditation + "\nNo Of Courses : "
					+ noOfCourses+"\nProgram Type : "+getProgram()+"\nFees : "+fees;
		}

}


