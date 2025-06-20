import java.util.Scanner;
 class studentgrade{
    public static void main(String[] args) {
       Scanner input= new Scanner(System.in) ;
       System.out.println("Enter the number of subjects:");
    int subjects =input.nextInt();
    int marks[] =new int[subjects];
    int total =0;
    for (int i = 0; i < subjects; i++) {
       System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            marks[i] = input.nextInt();  
    
     while (marks[i] < 0 || marks[i] > 100) {
                System.out.println(" Please enter valid marks (0-100 only).");
                System.out.print("Re-enter marks for Subject " + (i + 1) + ": ");
                marks[i] = input.nextInt();
            }

            total += marks[i];
        }
         double average = (double) total / subjects;
          String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        
        System.out.println("\n Result Summary:");
        System.out.println("Total Marks: " + total + " / " + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        input.close();
    }
}



    
 