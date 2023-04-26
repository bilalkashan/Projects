import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int i=0;
    static int mid;
    public static Student[] Students = new Student[50];

    public static void main(String[] args) {
        Student obj=new Student();
        Scanner sc=new Scanner(System.in);
        System.out.println("");
        System.out.println("------------------------------------------------------------------");
        System.out.println("*************** STUDENT COURSE REGISTRATION SYSTEM ***************");
        System.out.println("------------------------------------------------------------------");

        System.out.println("");
        System.out.println("------------------------ Main Menu -------------------------------");
        System.out.println("1: Add Student Information");
        System.out.println("2: Check Student through Course Name");
        System.out.println("3: Show Details of All Students");
        System.out.println("4: Search Student Detail By Roll Number");
        System.out.println("5: Total Number of Students Added");
        System.out.println("6: Delete Any Student");
        System.out.println("7: Exit");
        System.out.println("------------------------------------------------------------------");
        System.out.print("Enter Number you want to perform: ");
        int choice =sc.nextInt();

        if (choice<8){
            switch (choice){
                case 1:
                    Student tempStudent= obj.InsertStudent();
                    Students[i]=tempStudent;
                    i++;
                    main(null);
                    break;
                case 2:
                    SearchStudentByCourseName();
                    main(null);
                    break;
                case 3:
                    showAllStudents();
                    main(null);
                    break;
                case 4:
                    studentdetailbyroll();
                    main(null);
                    break;
                case 5:
                    totalStudents();
                    main(null);
                    break;
                case 6:
                    DeleteStudent();
                       // System.out.println("Incorrect Roll number, check roll number again");
                    main(null);
                    break;
                case 7:
                    break;
            }
        }
    }

    // ----------- 2: SEARCH STUDENT BY COURSE NAME
    public static void SearchStudentByCourseName() {
        System.out.println("");
        System.out.println("************** CHECK STUDENTS THROUGH COURSE NAME ****************");
        System.out.println("------------------------------------------------------------------");
        Scanner input = new Scanner(System.in);
        int count = 0;
        System.out.print("Enter Course name: ");
        String cr = input.nextLine();
        System.out.println("");
        for (int j = 0; j < i; j++){
            if (Students[j].StudentCourses.contains(cr)) {
                count++;
                System.out.println("------------- STUDENT: "+count+" _______________");
                System.out.println("Student Name: " + Students[j].Name);
                System.out.println("Student RollNumber: " + Students[j].rollNumber);
                System.out.println("Student Email: " + Students[j].email);
            }else
                System.out.println("No students enrolled in this course");
        }
    }

    // ----------- 3: SHOW ALL STUDENTS
    public static void showAllStudents() {
        System.out.println("");
        System.out.println("******************** DETAILS OF ALL STUDENTS *********************");
        System.out.println("------------------------------------------------------------------");
        System.out.println("");
        for (int j = 0; j < i; j++) {
            System.out.println("------------- STUDENT: "+(j+1)+" -------------");
            System.out.println("Student Name: "+Students[j].Name );
            System.out.println("Roll number: " +Students[j].rollNumber);
            System.out.println("Email :" +Students[j].email);
            System.out.println("Courses: ");
            for (String c : Students[j].StudentCourses) {
                System.out.println(c);
            }
            System.out.println("--------------------------------------------");
            System.out.println("");
        }
    }

    // ----------- 4: SHOW TOTAL STUDENTS (COUNT)
    public static void totalStudents() {
        System.out.println("");
        System.out.println("******************* TOTAL NUMBER OF STUDENTS *********************");
        System.out.println("------------------------------------------------------------------");
        System.out.println("");
        if(i==0){
            System.out.println("No Students Enrolled, First Enter Students.....");
        }else
            System.out.println("Total Number of Students: "+i);
    }

    // ----------- 5: STUDENT DETAIL BY ROLL NUMBER
    public static void studentdetailbyroll(){
        //System.out.println("");
        System.out.println("**************** STUDENT DETAILS BY ROLL NUMBER *******************");
        System.out.println("------------------------------------------------------------------");
        System.out.println("");
        Scanner input = new Scanner(System.in);
        int count=0;
        System.out.print("Enter Student Roll Number: ");
        int roll = input.nextInt();
        if (BinarySearch(roll)!=-1){
            count=1;
        }
        if(count==0){
            System.out.println("Not Registered Student, Check Your Roll Number Again");
        }
        else {
                if (Students[mid].rollNumber == roll){
                    System.out.println("------------- STUDENT: "+(mid+1)+ " -------------");
                    System.out.println("Student Name: " + Students[mid].Name);
                    System.out.println("Student RollNumber: " + Students[mid].rollNumber);
                    System.out.println("Student Email: " + Students[mid].email);
                    System.out.println("Courses Enrolled");
                    for (String c : Students[mid].StudentCourses) {
                        System.out.println(c);
                    }
                }
        }
    }

    // ----------- 6: DELETE STUDENT
    public static void DeleteStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("********************** DELETE ANY STUDENT ************************");
        System.out.println("------------------------------------------------------------------");
        System.out.println("");
        if (i == 0) {
            System.out.println("No Student Enrolled yet...");
        } else {
            System.out.println("Roll Number of Enrolled Students");
            for (int b = 0; b < i; b++) {
                System.out.println(Students[b].rollNumber);
            }
            System.out.println("");
            System.out.print("Enter Roll Number of the Student you want to delete: ");
            int record = input.nextInt();
            if (BinarySearch(record) != -1) {
                for (int j = mid; j < i; j++) {
                    Students[j] = Students[j + 1];
                }
                System.out.println("Record has been deleted Successfully.....");
                i--;
            }else
                System.out.println("Entered Roll number is incorrect");
        }
    }

    // ----- BINARY FUNCTION
    static int BinarySearch(double target){
        int start = 0;
        int end = i-1;
        while (start<=end){
            mid = (start+end)/2;
            if (target == Students[mid].rollNumber)
                return mid;
            if (target<Students[mid].rollNumber)
                end = mid-1;
            if(target>Students[mid].rollNumber)
                start = mid+1;
        }
        return -1;
    }
}