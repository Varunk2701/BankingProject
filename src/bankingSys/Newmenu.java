package bankingSys;

import java.util.*;


public class Newmenu {
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("-----------Welcome-----------\n\nEnter your choice:\n"
				+ "1. Create a new bank account\n"
				+ "2. Deposit Money\n"
				+ "3. Widraw Money\n"
				+ "4. Check Balance");
		
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1: 
		
			System.out.println("Please Enter the Following details: ");
			
			Random rand = new Random();
			long cid = rand.nextInt(9999);
			
			System.out.println("Full name: ");
			String cname = sc.nextLine();
			
			System.out.println("Permanent address: ");
			String caddress = sc.nextLine();
			
			System.out.println("City: ");
			String ccity = sc.nextLine();
			
			System.out.println("State: ");
			String cstate = sc.nextLine();
			
			System.out.println("E-mail id: ");
			String cemail = sc.nextLine();
			
			System.out.println("Mobile No: ");
			long cphone = sc.nextLong();
			
			Createaccount createNew = new Createaccount();
			System.out.println(createNew.createNewAccount(cid, cname, caddress, ccity, cstate, cemail, cphone)); 
			
				break;
				
		case 2:
			System.out.println("Please Enter your Account Number: \n");
			long accno = sc.nextLong();
			
			System.out.println("Enter amount to deposit: \n");
			int amt = sc.nextInt();
			
			Deposit newAmount = new Deposit();
			newAmount.depositAmount(accno, amt);
			
			break;
			
			
			
		case 3:
			System.out.println("Please Enter your Account Number: \n");
			long accno1 = sc.nextLong();
			
			System.out.println("Enter amount to widraw: \n");
			int amt1 = sc.nextInt();
			
			Widraw updatedAmount = new Widraw();
			updatedAmount.widrawAmount(accno1, amt1);
			
			break;
			
			
		case 4:
			System.out.println("Please Enter your Account Number: \n");
			long accno2 = sc.nextLong();
			
			Balance bal = new Balance();
			bal.checkBalance(accno2);
			
			
			break;

		default:
			break;
		}
		
		

		
	}

}
