package EmailAdmin;
import java.util.*;
public class EmailApp {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter First Name : ");
        String Fname = sc.nextLine();
        System.out.print("Enter Last Name : ");
        String Lname = sc.nextLine();
        //Creating Object of Email Class
        Email  email = new Email(Fname,Lname);
        int choice = -1;
        do{
            System.out.println("********\n Enter your choice\n1.show Info\n2.Change Password\n3.Change Mailbox Capacity \n4.Set Alternate Mail ");
            choice=sc.nextInt();
            switch(choice){
                case 1 : email.getInfo();choice=-1;break;
                case 2 : email.setPassword();choice=-1;break;
                case 3 : email.setMailCapacity();choice=-1;break;
                case 4 : email.setAlter_Email();choice=-1;break;
                default:System.out.println("Invalid choice !! enter other choice ....");choice=-1;break;
            }
        }while(choice==-1);
    }
}
