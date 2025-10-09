# Cash Register Swing MVC (Assignment 2)

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)

---

## Overview

This project demonstrates an MVC (Model-View-Controller) design using Java Swing. The application simulates a cash register system with product scanning and subtotal calculation.

---

## How to Run

1. Open a terminal in the `SwingMVC/src` directory.
2. Compile all Java files:
   ```powershell
   javac *.java
   ```
3. Run the main application:
   ```powershell
   java MySwingMVCApp
   ```

---

## Features

- Scan products using the **Scan** button (reads from `products.txt`).
- Scanned products are listed with their prices.
- Subtotal updates automatically at the bottom of the main window.
- Easily extend the product list by editing `products.txt`.

---

## File Structure

- `src/Model.java`, `src/View.java`, `src/Controller.java`: MVC base files
- `src/Scanner.java`: Simulates product scanning
- `src/CashRegister.java`: Manages scanned items and subtotal
- `src/products.txt`: List of products (UPC, name, price)

---

## Documentation

- `SwingMVC/swing_framework_summary.md`: Swing summary and class diagram
- `SwingMVC/mvc_analysis.md`: MVC implementation explanation
- `SwingMVC/scan_sequence_diagram.md`: Scan process sequence diagram

---

## Answers to Assignment Questions

### Question 1: What is Swing?

Swing is Java’s long-standing GUI toolkit that provides a rich set of platform-independent components (windows, buttons, text fields, tables). It follows a pluggable look-and-feel and event-driven model: user actions generate events handled by listeners. In an MVC-style setup, Swing widgets live in the View; the Controller registers listeners to react to events and update the Model. Because Swing components already encapsulate internal state, many apps use a Passive-View variant where the controller manually pushes changes into the view instead of the model notifying the view.

### Question 2: How Does the Example Implement MVC?

Model holds data; View builds the Swing UI; Controller attaches listeners and updates model/state (see listeners and actions).

This is Swing MVC / Passive-View: the model doesn’t notify the view; controller directly sets fields / shows dialogs. Conventional textbook MVC often uses observer callbacks from model to view.


### Question 4: Sequence Diagram

The image below is the answer for question 4:

![alt text](<sequence diagram.jpg>)


---

## Work Distribution

| Name   | Contribution                                          |
| ------ | ----------------------------------------------------- |
| Ahmed  | Answered Q1, Q2, Q4 and prepared documentation        |
| Ivan   | Developed and implemented core application code (MVC) |
| Pranav | Developed and implemented core application code (MVC) |

_All members contributed to design discussions and project review._
