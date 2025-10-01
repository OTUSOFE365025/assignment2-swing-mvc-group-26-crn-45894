// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

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
	// Scanner uses Swing framework to create a UPC code
	private JFrame frame;
	private JPanel scannerPanel;
	private JButton scanButton;

	private String productsFile = "products.txt";
	private List<String> upcList = null;

	public Scanner() {
		frame = new JFrame("Scanner");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setLocation(300,50);
		frame.setVisible(true);

		// Create UI elements
		scanButton = new JButton("Scan");
		scannerPanel = new JPanel();

		// Add UI element to frame
		scannerPanel.add(scanButton);
		frame.getContentPane().add(scannerPanel);
		// Remove default action listener; let Controller handle scan events
	}

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
