import javax.swing.JOptionPane;


public class Main 
{




	public static void main(String[] args) {

		//using showInputDialog to get input from user
		
		String name = JOptionPane.showInputDialog("Enter college name: ");
		
		String address = JOptionPane.showInputDialog("Enter college address: ");
		
		String accred = JOptionPane.showInputDialog("Enter college accreditation: ");
		
		int courses = Integer.parseInt(JOptionPane.showInputDialog("Enter number of courses: "));
		
		String program = JOptionPane.showInputDialog("Enter program type(Science/Business): ");
		
		double fees = Double.parseDouble(JOptionPane.showInputDialog("Enter college fee: "));
		
		College newCollege = null;
		
		//using showMessageDialog to show record
		
		if (program.equalsIgnoreCase("science")) {
			
			newCollege = new ScienceCollege(name, address, accred, courses);
			newCollege.setFees(fees);
			JOptionPane.showMessageDialog(null, newCollege);
			
		} 
		
		else if (program.equalsIgnoreCase("business")) {
			
			newCollege = new BusinessCollege(name, address, accred, courses);
			newCollege.setFees(fees);
			JOptionPane.showMessageDialog(null, newCollege);
		} 
		
		else {
			
			JOptionPane.showMessageDialog(null, "Invalid College Type");
		}
	}
}

