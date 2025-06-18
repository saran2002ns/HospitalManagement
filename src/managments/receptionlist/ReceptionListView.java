package managments.receptionlist;

import java.util.Scanner;

import repository.Db;

public class ReceptionListView {
    ReceptionListControl control;
    Scanner scanner = new Scanner(System.in);
    Db db = Db.getInstance();
    public ReceptionListView(){
        control=new ReceptionListControl(this);
    }
    public void init() {
      menu();
    }

   private void menu() {
    while (true) {
        System.out.println("---- ADMIN -----");
       System.out.println();
       System.out.println("1.Add Patient");
       System.out.println("2.Search Patient");
        System.out.println("3.return");
        System.out.println("Enter your choice : ");

         try {
            int var1 = scanner.nextInt();
            scanner.nextLine();
            switch (var1) {
               case 1:addPatient();break;
               case 2:searchPatient();break;
               case 3:
                 return;
            }
         } catch (Exception var2) {
            this.scanner.nextLine();
            System.out.println("Invalid input try again !");
         }
       
    }
       
    }
   private void searchPatient() {
     String name = getName();
     control.searchPatient(name);
   }
   private void addPatient() {
    String name =getName();
    byte age =getAge();
    String number =getNumber();
    String date = getDate();
    String time = getTime();
    control.addPatient(name,age,number,date,time);
   }
    private String getTime() {
     System.out.println("Enter Your time ");
       String name= scanner.nextLine();
       return name.trim();
  }
     private String getDate() {
    System.out.println("Enter Your date ");
       String name= scanner.nextLine();
       return name.trim();
  }
     private String getName() {
       System.out.println("Enter Your name ");
       String name= scanner.nextLine();
       return name.trim();
    }
      private byte getAge() {
       System.out.println("Enter Your age : ");
       byte age= Byte.parseByte(scanner.nextLine());
       return age;
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
}
