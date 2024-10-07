import java.util.Scanner;

class account{

    static String name;
   static double balence;

    account(String n,double b){
        this.name=n;
        this.balence=b;
    }
}

class Atm extends account{

    Atm(String n, double b) {
        super(n, b);
    }

    void Deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Amount to Deposit.");
        double amount=sc.nextDouble();
        balence=balence+amount;

        System.out.println("\nDear "+name+", "+amount+"credited sucessfully.");
        Balence();
    }

    void Withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Amount to withdraw.");
        double amount=sc.nextDouble();

        if(amount>10000){
            System.out.println("\nDear "+name+", "+"you cannot withdraw amount greater than 10000.");
        }
        else if (amount>balence) {
            System.out.println("\nDear "+name+", "+"your accont has insufficent balence");
            Balence();
        }
        else{
            balence=balence-amount;
            System.out.println("\nDear "+name+", "+amount+"Debited sucessfully.");
            Balence();
        }
    }

    void Balence(){
        System.out.println("\nYour current Balence:"+balence);
    }

    void Exit(){
        System.out.println("Thankyou for Visting ATM.");
    }
}

class run{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(("-".repeat(8)));
        System.out.println("|"+" ATM "+"|");
        System.out.println(("-".repeat(8)));

        menupage();
    }

    static void menupage(){
        System.out.println("\nEnter your Details.\n");
        System.out.println("Enter Name:");
        String name=sc.nextLine();
        Atm a=new Atm(name,0);
        int choice=0;
        do{
            System.out.println("\nPress 1: Deposit");
            System.out.println("Press 2: Withdraw");
            System.out.println("Press 3: Check Balence");
            System.out.println("Press 4: Exit");
            System.out.println("\n Enter choice");
            choice= sc.nextInt();

            switch (choice){
                case 1 -> a.Deposit();
                case 2 -> a.Withdraw();
                case 3 -> a.Balence();
                case 4 -> a.Exit();
                default ->{
                    System.out.println("Invalid choice");
                    menupage();
                }
            }
        }
        while (choice!=4);
    }
}
