package menu.impl;

import java.util.Scanner;

import configs.ApplicationContext;
import entities.Cart;
import entities.Product;
import menu.Menu;
import services.ProductManagementService;
import services.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		
		Menu menuToNavigate = null;
		
		mainLoop: for(;;) {
			printHeaderAndProductList();
			
			String userInput = getUserInput();
			
			if (context.getLoggedInUser() == null) {
				menuToNavigate = new MainMenu();
				System.out.println("You are not logged in. Please, sign in or create new account");
				break;
			}
			
			if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				menuToNavigate = new MainMenu();
				break;
			}
			
			if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)) {
				Cart sessionCart = context.getSessionCart();
				if (sessionCart == null || sessionCart.isEmpty()) {
					System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
				} else {
					menuToNavigate = new CheckoutMenu();
					break;
				}
			} else {
				Product productToAddToCart = productManagementService.getProductById(Integer.parseInt(userInput));
				
				if (productToAddToCart == null) {
					System.out.println("Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
					continue;
				}
				
				processAddToCart(productToAddToCart);
			}
		}
		
		menuToNavigate.start();
	}

	private String getUserInput() {
		String userInput;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Product ID to add to cart or enter 'checkout' to proceed with checkout: ");
		userInput = sc.next();
		return userInput;
	}

	private void printHeaderAndProductList() {
		printMenuHeader();
		Product[] products = productManagementService.getProducts();
		for (Product p : products) {
			System.out.println(p);
		}
	}
	
	private void processAddToCart(Product productToAddToCart) {
		context.getSessionCart().addProduct(productToAddToCart);
		System.out.printf("Product %s has been added to your cart. "
				+ "If you want to add a new product - enter the product id. "
				+ "If you want to proceed with checkout - enter word "
				+ "'checkout' to console %n", productToAddToCart.getProductName());
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** PRODUCTS *****");
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
	}

}
