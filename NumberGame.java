import java.util.Random;
import java.util.Scanner;

class NumberGame {
    static Scanner sc=new Scanner(System.in);
    static Random rand=new Random();

     public static void main(String[] args) {
         System.out.println(("-".repeat(27)));
         System.out.println("|"+(" ".repeat(25))+"|");
         System.out.println("|"+" Welcome to Number Game  "+"|");
         System.out.println("|"+(" ".repeat(25))+"|");
         System.out.println(("-".repeat(27)));
         menupage();
     }

     static void menupage(){
         int choice=0;
         do{
             System.out.println("\nPress 1: Classic Game");
             System.out.println("Press 2: Limit Game");
             System.out.println("Press 3: About Game");
             System.out.println("Press 4: Exit Game\n");

             System.out.println("Enter choice:");
             choice=sc.nextInt();

             switch (choice){
                 case 1 -> classicgame();
                 case 2 -> limitgame();
                 case 3 -> aboutgame();
                 case 4 -> exitpage();

                 default -> {
                     System.out.println("Invalid choice.\n");
                     menupage();
                 }
             }
         }
         while (choice!=4);
     }

     static void classicgame(){
         int n= rand.nextInt(1,100);
         int count=1;
         int g=0;

         while (g!=n){
             System.out.println("\nEnter Guessed No");
             g= sc.nextInt();

             if(g==n){
                 displayscore(count);
             }
             else if (g>n) {
                 System.out.println("Lower the no\n");
                 count++;
             }
             else if (g<n) {
                 System.out.println("Higher the no\n");
                 count++;
             }
         }

     }

     static void limitgame(){
         int n= rand.nextInt(0,100);
         int count=1;
         int g=0;
         System.out.println("\n Remember,You have only 10 chance to guess Number.");

         while (g!=n){
             System.out.println("Enter Guessed No");
             g= sc.nextInt();

             if(g==n){
                 displayscore(count);
             }
             else if (count==10) {
                 System.out.println("\nYou fail to guess Number in 10 chance");
                 System.out.println("\n do you want to play again (yes/no)");
                 String p=sc.next();

                 if(p.equalsIgnoreCase("yes")){
                     limitgame();
                 }
                 else {
                     menupage();
                 }
             }
             else if (g>n) {
                 System.out.println("Lower the no\n");
                 count++;
             }
             else if (g<n) {
                 System.out.println("Higher the no\n");
                 count++;
             }
         }
     }

     static void aboutgame(){
         System.out.println("\n1.In this game you have to guess no.");
         System.out.println("2.If your guessed no is smaller than actual nor  Game display-> Higher the no.");
         System.out.println("3.If your guessed no is Larger than actual nor  Game display-> Lower the no.");
         System.out.println("4. After guessing no Game display your Final score.");
         menupage();
     }

     static void exitpage(){
         System.out.println("Thankyou for Playing Game.");
         return;
     }

     static void displayscore(int s){
         System.out.println("\n Your Final score is: "+s);
         System.out.println("\n do you want to play again (yes/no)");
         String p=sc.next();

         if(p.equalsIgnoreCase("yes")){
             classicgame();
         }
         else{
             menupage();
         }
     }
}
