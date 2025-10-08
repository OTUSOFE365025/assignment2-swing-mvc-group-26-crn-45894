import javax.swing.JOptionPane;
 
/**
 * Controller connects the Model and the View and handles user actions.
 *
 * Responsibilities of this class in the tiny demo:
 * - Initialize the view with model data
 * - Wire button listeners to small action handlers
 * - Handle scan events by querying the CashRegister and updating the view
 */
public class Controller {
	private Model model;
	private View view;
	private CashRegister cashRegister;
	private Scanner scanner;

	public Controller(Model m, View v, CashRegister cr, Scanner sc) {
		model = m;
		view = v;
		cashRegister = cr;
		scanner = sc;
		initView();
	}

	// Populate the view's text fields with values from the model
	public void initView() {
		view.getFirstnameTextfield().setText(model.getFirstname());
		view.getLastnameTextfield().setText(model.getLastname());
	}

	// Attach listeners to the buttons. The Controller keeps the handlers small
	// so the View remains passive and focused on rendering.
	public void initController() {
		view.getFirstnameSaveButton().addActionListener(e -> saveFirstname());
		view.getLastnameSaveButton().addActionListener(e -> saveLastname());
		view.getHello().addActionListener(e -> sayHello());
		view.getBye().addActionListener(e -> sayBye());

		// Listen for scan events coming from the simple Scanner window
		scanner.getScanButton().addActionListener(e -> handleScan());
	}

	private void saveFirstname() {
		model.setFirstname(view.getFirstnameTextfield().getText());
		JOptionPane.showMessageDialog(null, "Firstname saved : " + model.getFirstname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	private void saveLastname() {
		model.setLastname(view.getLastnameTextfield().getText());
		JOptionPane.showMessageDialog(null, "Lastname saved : " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	private void sayHello() {
		JOptionPane.showMessageDialog(null, "Hello " + model.getFirstname() + " " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	private void sayBye() {
		System.exit(0);
	}

	// When the scanner produces a UPC code, try to add the corresponding
	// product to the cash register and update the UI.
	private void handleScan() {
		String upc = scanner.getRandomUPC();
		if (upc == null) {
			JOptionPane.showMessageDialog(null, "No UPC code scanned.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		boolean added = cashRegister.addItemByUPC(upc);
		if (added) {
			CashRegister.Product p = cashRegister.getScannedItems().get(cashRegister.getScannedItems().size() - 1);
			// Use fixed-width fields to align columns when displayed in a monospaced JList
			// name: left 15, upc: left 8, price: right 7 with 2 decimals
			String display = String.format("Product: %-15s | UPC: %-8s | Price: $%7.2f", p.getName(), p.getUpc(), p.getPrice());
			view.addScannedItem(display);
			view.setSubtotal(cashRegister.getSubtotal());
		} else {
			JOptionPane.showMessageDialog(null, "Unknown UPC: " + upc, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
