
public class MySwingMVCApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Assemble all the pieces of the MVC
		  Model m = new Model("Sylvain", "Saurel");
		  View v = new View("MVC with SSaurel");
		  Scanner scanner = new Scanner();
		  CashRegister cashRegister = new CashRegister("products.txt");
		  Controller c = new Controller(m, v, cashRegister, scanner);
		  c.initController();
	}

}
