  import java.io.*;
import java.util.*;

class StudentData {
    private int roll_Num;
    private String stuName;
    private String stuGrade;

    StudentData(int roll_Num, String stuName, String stuGrade) {
        this.roll_Num = roll_Num;
        this.stuName = stuName;
        this.stuGrade = stuGrade;
    }

    int getRollNum() { return roll_Num; }
    String getStuName() { return stuName; }
    String getStuGrade() { return stuGrade; }

    void setStuName(String stuName) { this.stuName = stuName; }
    void setStuGrade(String stuGrade) { this.stuGrade = stuGrade; }

    @Override
    public String toString() {
        return "Roll No: " + roll_Num + ", Name: " + stuName + ", Grade: " + stuGrade;
    }
}

class StudentDataManager {
    private List<StudentData> studentList = new ArrayList<>();

    void addStudent(StudentData data) {
        studentList.add(data);
        System.out.println("\n Student inserted successfully\n");
    }

    StudentData searchStudent(int rollNum) {
        for (StudentData sd : studentList) {
            if (sd.getRollNum() == rollNum)
                return sd;
        }
        return null;
    }

    void deleteStudent(int rollNum) {
        StudentData sd = searchStudent(rollNum);
        if (sd != null) {
            studentList.remove(sd);
            System.out.println("\n Student deleted successfully\n");
        } else {
            System.out.println("\n Student not found!\n");
        }
    }

    void showAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("\n No student records found.\n");
        } else {
            System.out.println(" Student Records:\n");
            for (StudentData s : studentList) {
                System.out.println(s);
            }
        }
    }

    void saveToTextFile(String filePath) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (StudentData s : studentList) {
                writer.write(s.getRollNum() + "," + s.getStuName() + "," + s.getStuGrade());
                writer.newLine();
            }
        }
    }

    void loadFromTextFile(String filePath) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String content;
            while ((content = reader.readLine()) != null) {
                String[] parts = content.split(",");
                studentList.add(new StudentData(Integer.parseInt(parts[0]), parts[1], parts[2]));
            }
        }
    }
}

public class systeminterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentDataManager sdm = new StudentDataManager();

        while (true) {
            System.out.println("\n🎓 STUDENT MANAGEMENT MENU");
            System.out.println(" 1. Register Student");
            System.out.println(" 2. Delete Student");
            System.out.println(" 3. Search Student");
            System.out.println(" 4. List All Students");
            System.out.println(" 5. Save Records");
            System.out.println(" 6. Exit\n");

            System.out.print("Pick your choice: ");
            int opt = input.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rn = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fname = input.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = input.nextLine();

                    if (fname.isEmpty() || grade.isEmpty()) {
                        System.out.println(" Name and Grade cannot be empty.");
                        break;
                    }

                    sdm.addStudent(new StudentData(rn, fname, grade));
                    break;

                case 2:
                    System.out.print("Enter Roll No to remove: ");
                    rn = input.nextInt();
                    sdm.deleteStudent(rn);
                    break;

                case 3:
                    System.out.print("Enter Roll No to find: ");
                    rn = input.nextInt();
                    StudentData found = sdm.searchStudent(rn);
                    if (found != null)
                        System.out.println("\n" + found + "\n");
                    else
                        System.out.println("\n No student found.\n");
                    break;

                case 4:
                    sdm.showAllStudents();
                    break;

                case 5:
                    try {
                        sdm.saveToTextFile("StudentsData.txt");
                        System.out.println("\n Data saved to file.\n");
                    } catch (Exception e) {
                        System.out.println(" Error saving file.");
                    }
                    break;

                case 6:
                    System.out.println(" Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid input! Please enter a number between 1 – 6.");
            }
        }
    }
}

