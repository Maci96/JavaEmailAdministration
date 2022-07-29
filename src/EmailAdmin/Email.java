package EmailAdmin;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.io.*;
public class Email {
public Scanner sc= new Scanner(System.in);
//Non Access Variables
private String Fname;
private String Lname;
private String Dept;
private String Email;
private String Password;
private int MailCapacity = 500;
private String alter_Email;
//Constructor to instanciate the email object
    public Email(String fname, String lname){
        this.Fname= fname;
        this.Lname=lname;
        //Calling Methods
        this.Dept = this.setDept();
        this.Password = this.generatePassword(8);
        this.Email = this.generateNewEmail();

        System.out.print("New Employe : "+Fname+" "+Lname);
    }
    //Generate Email
    private String generateNewEmail(){
        return this.Fname.toLowerCase()+"."+this.Lname.toLowerCase()+"@"+this.Dept.toLowerCase()+".company.com";
    }
    // Asking for dept
    private String setDept(){
        System.out.println("Departement codes \n0 for none \n1 for sales \n2 for Accounting \n3 for development ");
        boolean flag = false;
        do{
            System.out.println("Enter Departement Code");
            int choice = sc.nextInt();
            switch (choice){
                case 0 : flag=true; return "None";
                case 1 : flag=true; return "Sales";
                case 2 : flag=true; return "Accounting";
                case 3 : flag=true; return "Development";
                default : System.out.println("invalid choice please choose a another code");
            }

        }while(!flag);
        return "";
    }
    private String generatePassword(int length){
        Random r =new Random();
        String Capital_chars="AZERTYUIOPQSDFGHJKLMWXCVBN";
        String Small_chars = "azertyuiopqsdfghjklmwxcvbn";
        String Numbers="0123456789";
        String Symbols = "!@#$%&?";
        String values = Capital_chars+Small_chars+Numbers+Symbols;
        String Password ="";
        for (int i=0; i<length; i++){
            Password = Password+values.charAt(r.nextInt(values.length()));
        }
        return Password;
    }
    public void setPassword(){
        boolean flag =false;
        do{
            System.out.println("Do you want to change Password : (Y/N)");
            char choice = sc.next().charAt(0);
            if(choice == 'Y' || choice == 'y'){

                System.out.println("Enter current password");
                String currentPassword = sc.next();
                if(currentPassword.equals(this.Password)){
                    System.out.print("Enter the new Password ");
                    this.Password = sc.next();
                    System.out.println("Password Changed Successfully");
                    flag = true;
                }
                else{
                    System.out.println("incorrect password");
                    flag = true;
                }
            }
            else if(choice =='N' || choice=='n' ){

                System.out.println("Password change option cancelled!!");
                flag = true;
            }
        }while(!flag);
    }
    public void setMailCapacity(){
        System.out.print("Current capacity = "+this.MailCapacity+" mb" );
        System.out.println("Enter new mailBox capacity");
        this.MailCapacity = sc.nextInt();
        System.out.println("MailBox capacity is successfully changed");

    }
    public void setAlter_Email(){
        System.out.print("Enter the new Alternate Mail");
        this.alter_Email = sc.next();
        System.out.println("Alternate email is set");

    }
    public void getInfo(){
        System.out.println("New : "+this.Fname+" "+this.Lname);
        System.out.println("Departement : "+this.Dept);
        System.out.println("Email : "+this.Email);
        System.out.println("Password : "+this.Password);
        System.out.println("Alternate Mail : "+ this.alter_Email );
        System.out.println("Email Capacity : "+this.MailCapacity);
    }
    public void StoreInFile(){
        try{
            FileWriter in = new FileWriter("./index.txt");//Specify the name
            in.write("First name : "+this.Fname);
            in.append("\nLast name : "+this.Lname);
            in.append("\nPassword : "+this.Password);
            in.append("\nEmail : "+this.Email);
            in.append("\nAlternate Email : "+this.alter_Email);
            in.append("\nAlternate Mail Capicity: "+this.MailCapacity);
            in.close();
            System.out.println("Data Stored ....");
        }catch(Exception e){
System.out.println(e);
        }
    }
    public void Read_File(){
        try{
            FileReader f1 = new FileReader("./index.txt");
            int i ;
            while((i=f1.read())!=-1){
                System.out.print((char)i);
            }
            System.out.println("Reading File Done.");
            f1.close();
        }catch(Exception e){
            System.out.println("Error while reading file "+e.getMessage());
        }
    }
}
