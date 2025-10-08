/**
 * Application entry point for the small Swing MVC demo.
 *
 * This class wires together the Model, View and Controller and
 * starts the controller so the GUI becomes responsive.
 *
 * For the assignment I keep the main method short and explicit so
 * it's easy to see how the pieces are composed.
 */
public class MySwingMVCApp {

	public static void main(String[] args) {
		// Create simple model with default names
		Model m = new Model("Sylvain", "Saurel");

		// Create view (builds the Swing UI)
		View v = new View("MVC with Saurel");

		// Small helper that simulates scanning UPC codes
		Scanner scanner = new Scanner();

		// Load product data from file for the cash register
		CashRegister cashRegister = new CashRegister("products.txt");

		// Controller coordinates interactions between model and view
		Controller c = new Controller(m, v, cashRegister, scanner);
		c.initController();
	}

}
