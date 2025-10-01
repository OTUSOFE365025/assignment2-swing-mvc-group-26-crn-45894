[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)
Example of an MVC design based on Swing. Answer questions 1 & 2 in this README file.

---

## Cash Register Swing MVC Extension (Assignment 2)

### How to Run
1. Open a terminal in the `SwingMVC/src` directory.
2. Compile all Java files:
   ```powershell
   javac *.java
   ```
3. Run the main application:
   ```powershell
   java MySwingMVCApp
   ```

### Features
- Press the **Scan** button in the Scanner window to add a random product from `products.txt`.
- Each scanned product appears in a scrollable list with its price.
- The subtotal updates automatically at the bottom of the main window.
- Product list is easily extendable by editing `products.txt`.

### File Structure
- `src/Model.java`, `src/View.java`, `src/Controller.java`: MVC base files
- `src/Scanner.java`: Simulates product scanning
- `src/CashRegister.java`: Manages scanned items and subtotal
- `src/products.txt`: List of products (UPC, name, price)

### Documentation
- See `SwingMVC/swing_framework_summary.md` for a summary and class diagram of Swing.
- See `SwingMVC/mvc_analysis.md` for an explanation of the MVC implementation.
- See `SwingMVC/scan_sequence_diagram.md` for a sequence diagram of the scan process.

---

