import java.util.ArrayList;
import java.util.Scanner;

public class Attempt4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String contPrompt;
		System.out.println("\n");
		System.out.printf("%-5s %-15s %-15s %n", "#", "Item", "Price");
		System.out.println("========================================");
		ArrayList<Double> prices = new ArrayList<>();
		prices.add(9.99);
		prices.add(1.89);
		prices.add(22.99);
		prices.add(7.75);
		prices.add(1.00);
		prices.add(4.49);
		prices.add(5.00);
		prices.add(100.00);
		ArrayList<String> items = new ArrayList<>();
		items.add("Apple");
		items.add("Orange");
		items.add("Banana");
		items.add("Kiwi");
		items.add("Grape");
		items.add("Pickle");
		items.add("Watermelon");
		items.add("Coconut");
//These array lists hold all of the values associated with this price and items.
		ArrayList<String> itemsCart = new ArrayList<>();
		ArrayList<Double> pricesCart = new ArrayList<>();
//Initialize the Array Lists for the total price and totla items in cart.
		do {
			for (int i = 0; i < prices.size(); i++) {
				System.out.printf("%-5s %-15s %-15s %n", (i + 1), items.get(i), "$" + prices.get(i));
			}
			System.out.println("");
//This formats the array lists into a menu for the user.			

			int userChoice = getInt(scan, "Please select the # of the item that you would like to add to your cart: ",
					1, 8);
			userChoice -= 1;
//This prompts the user and sends to the validation method.			

			System.out
					.println("You've added a(n) " + (items.get(userChoice)) + " costing $" + (prices.get(userChoice)));
//Shows the choice that was just added.
			itemsCart.add(items.get(userChoice));

			pricesCart.add(prices.get(userChoice));
//The corresponding items and prices are added to the cart.		
			System.out.println("You have " + itemsCart + " in your cart costing " + pricesCart + "respectively.");
			System.out.println("Your average price is: " + averagePrice);
//Prints out all the items in the cart.			

			System.out.println("Would you like to select another item?");
			System.out.println("Press y to continue or press any other key to check out.");

			double average = calcAverage(pricesCart);
//Calculates the average.		
			contPrompt = scan.nextLine();

		} while (contPrompt.equalsIgnoreCase("y"));

	}

	public static ArrayList<Double> calcAverage(ArrayList<Double> pricesCart) {

		double sum = 0;
		for (int i = 0; i < pricesCart.size(); i++) {
			sum += pricesCart.get(i);
		}
		double averagePrice = (sum / pricesCart.size());

		return averagePrice;

	}

	public static int getInt(Scanner scan, String prompt, int min, int max) {

		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(scan, prompt);
			if (i < min)
				System.out.println("Number must be greater than 1");
			else if (i > max)
				System.out.println("Number must be less than 8");
			else
				isValid = true;
		}
		return i;

	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();

				isValid = true;
			} else {
				System.out.println("Invalid student #. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

}