
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ListCellRenderer;
import java.awt.Component;
import java.awt.Font;

public class View {
	// View uses Swing framework to display the application's UI.
	//	This class builds the form and exposes a few simple methods
	// to update the scanned items list and the subtotal label.
	private JFrame frame;
	private JLabel firstnameLabel;
	private JLabel lastnameLabel;
	private JTextField firstnameTextfield;
	private JTextField lastnameTextfield;
	private JButton firstnameSaveButton;
	private JButton lastnameSaveButton;
	private JButton hello;
	private JButton bye;

	// For Cash Register UI
	private DefaultListModel<String> scannedItemsModel;
	private JList<String> scannedItemsList;
	private JScrollPane scannedItemsScrollPane;
	private JLabel subtotalLabel;
	 
	public View(String title) {
		frame = new JFrame(title);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 350);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Create UI elements
		firstnameLabel = new JLabel("Firstname :");
		lastnameLabel = new JLabel("Lastname :");
		firstnameTextfield = new JTextField();
		lastnameTextfield = new JTextField();
		firstnameSaveButton = new JButton("Save firstname");
		lastnameSaveButton = new JButton("Save lastname");
		hello = new JButton("Hello!");
		bye = new JButton("Bye!");

		// Cash Register UI
		scannedItemsModel = new DefaultListModel<>();
		scannedItemsList = new JList<>(scannedItemsModel);
		// Use a monospaced font so formatted columns align
		scannedItemsList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		// Simple left-aligned renderer that uses JLabel so padding/monospace works
		scannedItemsList.setCellRenderer(new ListCellRenderer<String>() {
			private final JLabel lbl = new JLabel();
			{
				lbl.setOpaque(true);
				lbl.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
			}
			@Override
			public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
					boolean isSelected, boolean cellHasFocus) {
				lbl.setText(value);
				if (isSelected) {
					lbl.setBackground(list.getSelectionBackground());
					lbl.setForeground(list.getSelectionForeground());
				} else {
					lbl.setBackground(list.getBackground());
					lbl.setForeground(list.getForeground());
				}
				return lbl;
			}
		});
		scannedItemsScrollPane = new JScrollPane(scannedItemsList);
		subtotalLabel = new JLabel("Subtotal: $0.00");

		// Layout
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(firstnameLabel)
				.addComponent(lastnameLabel)
				.addComponent(scannedItemsScrollPane)
				.addComponent(subtotalLabel))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(firstnameTextfield)
				.addComponent(lastnameTextfield))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(firstnameSaveButton)
				.addComponent(lastnameSaveButton))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(hello)
				.addComponent(bye)));
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(firstnameLabel)
				.addComponent(firstnameTextfield)
				.addComponent(firstnameSaveButton)
				.addComponent(hello))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lastnameLabel)
				.addComponent(lastnameTextfield)
				.addComponent(lastnameSaveButton)
				.addComponent(bye))
			.addComponent(scannedItemsScrollPane)
			.addComponent(subtotalLabel));

		layout.linkSize(SwingConstants.HORIZONTAL, firstnameSaveButton, lastnameSaveButton);
		layout.linkSize(SwingConstants.HORIZONTAL, hello, bye);
		frame.getContentPane().setLayout(layout);
	}
	// Cash Register UI methods
	public void addScannedItem(String item) {
		scannedItemsModel.addElement(item);
	}

	public void clearScannedItems() {
		scannedItemsModel.clear();
	}

	public void setSubtotal(double subtotal) {
		subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
	}
	 
	 public JFrame getFrame() {
	  return frame;
	 }
	 
	 public void setFrame(JFrame frame) {
	  this.frame = frame;
	 }
	 
	 public JLabel getFirstnameLabel() {
	  return firstnameLabel;
	 }
	 
	 public void setFirstnameLabel(JLabel firstnameLabel) {
	  this.firstnameLabel = firstnameLabel;
	 }
	 
	 public JLabel getLastnameLabel() {
	  return lastnameLabel;
	 }
	 
	 public void setLastnameLabel(JLabel lastnameLabel) {
	  this.lastnameLabel = lastnameLabel;
	 }
	 
	 public JTextField getFirstnameTextfield() {
	  return firstnameTextfield;
	 }
	 
	 public void setFirstnameTextfield(JTextField firstnameTextfield) {
	  this.firstnameTextfield = firstnameTextfield;
	 }
	 
	 public JTextField getLastnameTextfield() {
	  return lastnameTextfield;
	 }
	 
	 public void setLastnameTextfield(JTextField lastnameTextfield) {
	  this.lastnameTextfield = lastnameTextfield;
	 }
	 
	 public JButton getFirstnameSaveButton() {
	  return firstnameSaveButton;
	 }
	 
	 public void setFirstnameSaveButton(JButton firstnameSaveButton) {
	  this.firstnameSaveButton = firstnameSaveButton;
	 }
	 
	 public JButton getLastnameSaveButton() {
	  return lastnameSaveButton;
	 }
	 
	 public void setLastnameSaveButton(JButton lastnameSaveButton) {
	  this.lastnameSaveButton = lastnameSaveButton;
	 }
	 
	 public JButton getHello() {
	  return hello;
	 }
	 
	 public void setHello(JButton hello) {
	  this.hello = hello;
	 }
	 
	 public JButton getBye() {
	  return bye;
	 }
	 
	 public void setBye(JButton bye) {
	  this.bye = bye;
	 }
	 
}
