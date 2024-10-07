import java.util.Scanner;

public class Student_Grade_Calculator {

    static Scanner sc=new Scanner(System.in);
    static int n;
    static int[] marks;
    static int totalmarks=0;
    static float percentage;
    static String grade;
    static String Name;
    static int rollno;

    public static void main(String[] args) {
        System.out.println(("-".repeat(30)));
        System.out.println(" |"+" Student Grade Calculator "+"|");
        System.out.println(("-".repeat(30)));
        getdatapage();
    }
    // Get data from User
    static void getdatapage(){
        System.out.println("\nEnter Details\n");
        System.out.println("Enter Name:");
        Name=sc.nextLine();
        System.out.println("Enter Roll No:");
        rollno=sc.nextInt();
        System.out.println("Enter total no of subject:");
        n= sc.nextInt();
        marks=new int[n];

        for (int i =0; i <n ; i++) {
            System.out.println("Enter subject"+(i+1)+" marks:");
            marks[i]= sc.nextInt();
        }

        System.out.println("\nMarks added sucessfully.");
        Resultpage();
    }

    // Calculating totalmarks,percentage,and grade
    static void Resultpage(){

        for (int i =0; i <n ; i++) {
            totalmarks+=marks[i];
        }

        percentage= (float) totalmarks /n;

        if(percentage>=91 && percentage<=100){
            grade="A+";
        }
        else if (percentage>=81 && percentage<=90) {
            grade="A";
        }
        else if (percentage>=71 && percentage<=80) {
            grade="B+";
        }
        else if (percentage>=61 && percentage<=70) {
            grade="B";
        }
        else if (percentage>=51 && percentage<=60) {
            grade="C+";
        }
        else if (percentage>=41 && percentage<=50) {
            grade="C";
        }
        else if (percentage>=33 && percentage<=40) {
            grade="D+";
        } else if ( percentage<33) {
            grade="F";
        }
        display();
    }

    static void display(){
        System.out.println("\n Final Result");
        System.out.println("Name:"+Name);
        System.out.println("Roll no:"+rollno);
        System.out.println("Total Marks:"+totalmarks);
        System.out.println("Average Percentage:"+percentage+"%");
        System.out.println("Grade:"+grade);
    }


}
