package managments.menu;

import java.util.Scanner;



import managments.base.Base;

public class HospitalManagementView extends  Base{
    private final Scanner scanner = new Scanner(System.in);
    private HospitalManagementController controller;
    public HospitalManagementView(){
        controller = new HospitalManagementController(this);
    }
    public void init(){
        showHomePage();
    }
    private void showHomePage() {
        while (true) {
              System.out.println("----- HOME PAGE -----");
              System.out.println();
              System.out.println("1.Admin Login");
              System.out.println("2.ReceptionList Login");
              System.out.println("3.exit");
              System.out.print("Enter your choice : ");
              try {
                int choice = scanner.nextInt();
                 scanner.nextLine();
                switch (choice) {
                    case 1:adminLogin();break;
                    case 2:receptionListLogin();break;
                    case 3:scanner.close(); exit();break;
                    default:break;
                }
              } catch (Exception e) {
                  scanner.nextLine();
                  System.out.println("Invalid input try again !");
              }
        }
     
    }

    private void receptionListLogin(){
                while (true) {
            System.out.println("---- Reception LOGIN ----");
            System.out.println();
            System.out.println("1.Login with your id");
            System.out.println("2.Login with your number");
            System.out.println("3.Return to hompage ");
            try {
                int choice = scanner.nextInt();
                 scanner.nextLine();
                switch (choice) {
                    case 1:receptionloginWithId();break;
                    case 2:receptionloginWithNumber();break;
                    case 3:return;
                    default:break;
                }
              } catch (Exception e) {
                  scanner.nextLine();
                  System.out.println("Invalid input try again !");
              }
        }
    }
    private void receptionloginWithNumber() {
         String number = getNumber();
        String password=getPassword();
        controller.adminChechPasswordWithNumber(number,password);
    }
    private void receptionloginWithId() {
         int id= getId();
        String password=getPassword();
        controller.adminChechPasswordWithId(id,password);
    }
    private void adminLogin() {
        while (true) {
            System.out.println("---- ADMIN LOGIN ----");
            System.out.println();
            System.out.println("1.Login with your id");
            System.out.println("2.Login with your number");
            System.out.println("3.Return to hompage ");
            try {
                int choice = scanner.nextInt();
                 scanner.nextLine();
                switch (choice) {
                    case 1:loginWithId();break;
                    case 2:loginWithNumber();break;
                    case 3:return;
                    default:break;
                }
              } catch (Exception e) {
                  scanner.nextLine();
                  System.out.println("Invalid input try again !");
              }
        }
      
    }
    private void loginWithNumber() {
        String number = getNumber();
        String password=getPassword();
        controller.chechPasswordWithNumber(number,password);
    }
       private void loginWithId() {
        int id= getId();
        String password=getPassword();
        controller.chechPasswordWithId(id,password);
    }
    private String getPassword() {
       System.out.println("Enter Your password ");
       String password= scanner.nextLine();
       return password.trim();
    }

    private String getNumber() {
        String number="";
        do{
            System.out.print("Enter Your number :");
            number=scanner.nextLine();
            if(!number.matches("\\d{10}")){
                System.out.println("Not a number  put a 10 digit number " );
            }else break;
        }while(true);
        return number;
    }

    private int getId() {
        int id=0;
        do{
            System.out.println("Enter your id : ");
            try {
             id = scanner.nextInt();
                 scanner.nextLine();
                 break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Enter the Id number ");
               
            }
        }while(true);
        return id;
    }
}
