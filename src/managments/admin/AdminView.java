package managments.admin;

import java.util.Scanner;

import managments.base.Base;
import managments.display.DisplayView;

public class AdminView extends Base{
    private AdminService service ;
    public AdminView(){
      service = new AdminService(this);
    }
    Scanner scanner = new Scanner(System.in);
    public void init() {
     menu();
    }

    private void menu() {
      while (true) {
          System.out.println("---- ADMIN -----");
       System.out.println();
       System.out.println("1.APPOINMENT SHEDULING");
       System.out.println("2.MANAGE RECEPTION LIST");
       System.out.println("3.ADD DOCTERS");
       System.out.println("4.Display Appoinment Sheduling");
        System.out.println("5.Return");
        System.out.println("6.Exit");
        System.out.println("Enter your choice : ");

         try {
            int var1 = scanner.nextInt();
            switch (var1) {
               case 1:appoinmentSheduling();break;
               case 2:manageReceptionList();break;
               case 3:addDocter();break;
               case 4:new DisplayView().init();
               case 5:return;
               case 6:
                  this.scanner.close();
                  this.exit();
            }
         } catch (Exception var2) {
            this.scanner.nextLine();
            System.out.println("Invalid input try again !");
         }
      }
      
       
    }



    private void appoinmentSheduling() {
      
      service.setAppoinments();
    }

    private void manageReceptionList() {
      while (true) {
          System.out.println("---- MANAGE RECEPTION LIST -----");
       System.out.println();
       System.out.println("1.ADD RECEPTIONLIST");
       System.out.println("2.REMOVE RECEPTIONLIST");
        System.out.println("3.RETURN ");
        System.out.println("Enter your choice : ");

         try {
            int var1 = scanner.nextInt();
            scanner.nextLine();
            switch (var1) {
               case 1:addRecptionList();break;
               case 2:removeReceptionList();break;
               case 3:return;
            }
         } catch (Exception var2) {
            this.scanner.nextLine();
            System.out.println("Invalid input try again !");
         }
      }
        
    }

    private void removeReceptionList() {
      int id =getId();
      service.removeReceptionList(id);
    }
    private int getId(){
      int id=0;
       while (true) {
           try {
            id= scanner.nextInt();
            break;
           } catch (Exception e) {
           System.out.println("Enter valid input ");
           }
        }
        return id;
    }

    private void addRecptionList() {
      
      String name = getName();
      String password=getPassword();
      String number = getNumber();
      service.addToReceptionList(name,number,password);
      System.out.println(" ADDED SUCESSFULLY");
    }
    private String getName() {
       System.out.println("Enter Your name ");
       String name= scanner.nextLine();
       return name.trim();
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
    private void addDocter() {
    String name =getName();
    byte age =getAge();
    String number =getNumber();
    service.addDocter(name,age,number);
   }

      private byte getAge() {
       System.out.println("Enter Your age : ");
       byte age= Byte.parseByte(scanner.nextLine());
       return age;
    }


}
