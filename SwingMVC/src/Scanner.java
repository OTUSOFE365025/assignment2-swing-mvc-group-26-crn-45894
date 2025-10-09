/**
 * Simple scanner window used for testing the cash register.
 *
 * This class provides a small Swing frame with a single "Scan" button.
 * Each time the button is pressed the Controller will request a random
 * UPC code from this class. The UPCs are loaded from a small text file.
 *
 * I kept the implementation intentionally minimal so the focus stays
 * on the MVC wiring in the assignment.
 */
import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scanner {
	// Swing components for the tiny scanner UI
	private JFrame frame;
	private JPanel scannerPanel;
	private JButton scanButton;

	// File that contains product definitions (UPC is first token on each line)
	private String productsFile = "products.txt";
	private List<String> upcList = null;

	public Scanner() {
		frame = new JFrame("Scanner");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setLocation(300, 50);
		frame.setVisible(true);

		// Build UI
		scanButton = new JButton("Scan");
		scannerPanel = new JPanel();

		scannerPanel.add(scanButton);
		frame.getContentPane().add(scannerPanel);
		// Note: Controller attaches the action listener to the button
	}

	// Load the UPC codes from the products file into memory
	private void loadUPCCodes() {
		upcList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(productsFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length >= 1) {
					upcList.add(parts[0]);
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading products file: " + e.getMessage());
		}
	}

	// Return a random UPC from the loaded list (used to simulate scanning)
	public String getRandomUPC() {
		if (upcList == null || upcList.isEmpty()) {
			loadUPCCodes();
		}
		if (upcList == null || upcList.isEmpty()) {
			System.out.println("No UPC codes available.");
			return null;
		}
		Random rand = new Random();
		int idx = rand.nextInt(upcList.size());
		return upcList.get(idx);
	}

	// Getters and setters (kept for testability in the assignment)
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getScannerPanel() {
		return scannerPanel;
	}

	public void setScannerPanel(JPanel scannerPanel) {
		this.scannerPanel = scannerPanel;
	}

	public JButton getScanButton() {
		return scanButton;
	}

	public void setScanButton(JButton scanButton) {
		this.scanButton = scanButton;
	}

}
