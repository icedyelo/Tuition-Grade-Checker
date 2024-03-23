import javax.swing.JOptionPane;

public class program1 {

    public static void main(String args[]) {
        int choice = 0;
   
        do {
            String input = JOptionPane.showInputDialog(null, "Enter your choice:\n 1-Tuition Fee Calculation \n 2-Grade Calculation \n 3-Exit", "Menu", JOptionPane.INFORMATION_MESSAGE);
            
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No input provided. Please enter a valid choice.", "Menu", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    calculateTuitionFee();
                    break;
                case 2:
                    performGradeCalculation();
                    break;
                 case 3:
                    JOptionPane.showMessageDialog(null, "Exiting the program.", "Menu", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Choice", "Menu", JOptionPane.ERROR_MESSAGE);
            }
        } while (choice != 3);
    }

public static void calculateTuitionFee() {
    String input;
    int yr_lvl, gender;

    input = JOptionPane.showInputDialog("Enter year level:\n 1-4");
    
    if (input == null || input.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "No input provided. Please enter a valid year level.", "Tuition Fee", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        yr_lvl = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer for year level.", "Tuition Fee", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    input = JOptionPane.showInputDialog("Enter gender:\n 1-Male \n 2-Female");
    
    if (input == null || input.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "No input provided. Please enter a valid gender.", "Tuition Fee", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        gender = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer for gender.", "Tuition Fee", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    if (yr_lvl >= 1 && yr_lvl <= 4) {
        int tuitionFee;
        if (gender == 1) {
            if (yr_lvl == 1) {
                tuitionFee = 50000;
            } else {
                tuitionFee = 60000;
            }
        } else if (gender == 2) {
            if (yr_lvl == 1) {
                tuitionFee = 30000;
            } else if (yr_lvl == 2) {
                tuitionFee = 50000;
            } else {
                tuitionFee = 10000;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Gender", "Tuition Fee", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        JOptionPane.showMessageDialog(null, "Your Total Tuition Fee is: " + tuitionFee, "Tuition Fee", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Invalid Year Level", "Tuition Fee", JOptionPane.ERROR_MESSAGE);
    }
}

   public static void performGradeCalculation() {
        String input;
        int choice = 0;

        double sum = 0;

        do {
            input = JOptionPane.showInputDialog(null, "Enter your choice:\n 1-Total Grades \n 2-Total GWA \n 3-Exit", "Menu", JOptionPane.INFORMATION_MESSAGE);
            
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No input provided. Please enter a valid choice.", "Menu", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    double num;
					for (int i = 1; i < 5; i++) {
						input = JOptionPane.showInputDialog(null, i + " Enter Grade: ", "Grade", JOptionPane.INFORMATION_MESSAGE);
						if (input == null || input.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No input provided. Please enter a valid grade.", "Grade", JOptionPane.ERROR_MESSAGE);
                        continue;
						}
						num = Double.parseDouble(input);
						sum = sum + num;
						if (i == 4) {
							sum = sum / 4;
							JOptionPane.showMessageDialog(null, "Total Grades: " + sum, "Grade", JOptionPane.INFORMATION_MESSAGE);
					}
				}

                    break;
				
                case 2:
                    double grade1, grade2, average;

                    input = JOptionPane.showInputDialog(null, "Enter first semester grade", "Average", JOptionPane.INFORMATION_MESSAGE);
                    if (input == null || input.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No input provided. Please enter a valid grade.", "Average", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    grade1 = Double.parseDouble(input);
                    
                    input = JOptionPane.showInputDialog(null, "Enter second semester grade", "Average", JOptionPane.INFORMATION_MESSAGE);
                    if (input == null || input.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No input provided. Please enter a valid grade.", "Average", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    grade2 = Double.parseDouble(input);

                    average = (grade1 + grade2) / 2;
                    JOptionPane.showMessageDialog(null, "Total GWA: " + average, "Total Average", JOptionPane.INFORMATION_MESSAGE);

                    if (average <= 3.00) { 
                        JOptionPane.showMessageDialog(null, "You have passed", "Result", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "You have failed", "Result", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Choice", "Menu", JOptionPane.ERROR_MESSAGE);
            }
        } while (choice != 3);
    }
}
