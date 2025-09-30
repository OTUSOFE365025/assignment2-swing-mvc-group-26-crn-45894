# Sequence Diagram: Scan Button Press

Below is a sequence diagram (PlantUML format) representing a single press of the scan button in the Cash Register Swing MVC application:

```plantuml
@startuml
actor User
participant Scanner
participant Controller
participant CashRegister
participant View

User -> Scanner: Press Scan Button
Scanner -> Controller: ActionListener event
Controller -> Scanner: getRandomUPC()
Scanner --> Controller: UPC code
Controller -> CashRegister: addItemByUPC(UPC)
CashRegister --> Controller: success, Product
Controller -> View: addScannedItem(Product info)
Controller -> CashRegister: getSubtotal()
CashRegister --> Controller: subtotal
Controller -> View: setSubtotal(subtotal)
@enduml
```

You can render this diagram using any PlantUML tool or online editor.
