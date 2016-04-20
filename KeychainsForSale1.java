import java.util.Scanner;
public class KeychainsForSale1 {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int select;
		int keychains = 0;
		int keychain_price = 10;
		//8.25% sales tax
		double tax =  0.0825;
		//Base shipping cost is $5 
		int base_shipping = 5;
		//Additional $1 incurred per keychain added to order
		int per_keychain_shipping = 1;
		System.out.println("Welcome to the Keychain Shop!");
		System.out.println("");
		System.out.println("1. Add Keychains to Order \n2. Remove Keychains from Order \n3. View Current Order \n4. Checkout");
		System.out.println("Please enter your choice: " );
		select = keyboard.nextInt();
		
		//Allows user to keep inputting choices until checkout() function is called
		while(select != 4){
			if (select == 1){
				keychains = add_keychains(keychains);
				System.out.println("You now have " + keychains + " keychains in your cart.");
			}
			else if(select == 2){
				keychains = remove_keychains(keychains);
				System.out.println("You now have " + keychains + " keychains in your cart.");
			}
			else if (select == 3){
				view_order(keychains, keychain_price, tax, base_shipping, per_keychain_shipping);
			}
			else if(select < 1 || select > 3){
				System.out.println("Invalid selection. Please try again.");
			}
			System.out.println("1. Add Keychains to Order \n2. Remove Keychains from Order \n3. View Current Order \n4. Checkout");
			System.out.println("Please enter your choice: " );
			select = keyboard.nextInt();
		}
		if (select == 4){
			checkout(keychains, keychain_price, tax, base_shipping, per_keychain_shipping);
		}	
	}
	public static int add_keychains(int keychains){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("You have " + keychains + " keychains. How many keychains would you like to add?");
		int add = keyboard.nextInt();
		if (add > 0){
			keychains = keychains + add;	
		}
		else{
			System.out.println("Please enter a valid number.");
		}
		System.out.println("");
		return keychains;
	}
	public static int remove_keychains(int keychains){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("You have " + keychains + " keychains. How many would you like to remove?");
		int remove = keyboard.nextInt();
		if (remove <= keychains && remove > 0){
			keychains = keychains - remove;
		}
		else if (remove < 0){
			System.out.println("Please enter a valid number.");
		}
		else{
			System.out.println("You only have " + keychains + " keychains in your cart!");
		}
		System.out.println("");
		return keychains;
	}
	public static void view_order(int keychains, int keychain_price, double tax, int base_shipping, int per_keychain_shipping){
		int shipping;
		int keychain_total;
		double order_tax;
		double total;
		System.out.println("You have " + keychains + " keychains in your cart.");
		System.out.println("Keychains cost $" + keychain_price + " each.");
		//$5 base cost + $1 per keychain in order
		shipping = base_shipping + (per_keychain_shipping * keychains);
		System.out.println("Shipping for your order will cost $" + shipping + "." );
		//Subtotal excludes shipping cost so it is only total cost of keychains
		keychain_total = keychains * keychain_price;
		System.out.println("Your subtotal is $" + keychain_total);
		//Tax will be taken off the subtotal meaning it will exclude shipping costs
		order_tax = keychain_total * tax;
		System.out.printf("Tax is 8.25 of your subtotal : $%.2f\n", order_tax);
		//Total order cost includes subtotal, tax from subtotal, and shipping costs
		total = shipping + keychain_total + order_tax;
		System.out.printf("Final cost of your order is $%.2f\n", total);
		System.out.println("");
	}
	public static void checkout(int keychains, int keychain_price, double tax, int base_shipping, int per_keychain_shipping){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Full name: ");
		String name = keyboard.next();
		
		view_order(keychains,keychain_price, tax, base_shipping,per_keychain_shipping);
		
		System.out.println("Thank you for your order, " + name + "!");
	}

}