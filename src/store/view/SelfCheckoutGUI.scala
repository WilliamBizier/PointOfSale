package store.view

import javafx.scene.input.MouseEvent
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.GridPane
import store.model.checkout.SelfCheckout
import store.controller._

object SelfCheckoutGUI extends JFXApp {

  val checkoutModel: SelfCheckout = new SelfCheckout()
  this.checkoutModel.prepareStore()

  var scanField: TextField = new TextField {
    editable = false
    style = "-fx-font: 20 ariel;"
  }

  var receiptArea: ReceiptDisplay = new ReceiptDisplay()

  val numberFontSize: Int = 20

  var buttonOne: SelfCheckoutButton = new SelfCheckoutButton("1", new NumberAction(checkoutModel, 1), 1, 1, numberFontSize)
  var buttonTwo: SelfCheckoutButton = new SelfCheckoutButton("2", new NumberAction(checkoutModel, 2), 1, 1, numberFontSize)
  var buttonThree: SelfCheckoutButton = new SelfCheckoutButton("3", new NumberAction(checkoutModel, 3), 1, 1, numberFontSize)

  var buttonFour: SelfCheckoutButton = new SelfCheckoutButton("4", new NumberAction(checkoutModel, 4), 1, 1, numberFontSize)
  var buttonFive: SelfCheckoutButton = new SelfCheckoutButton("5", new NumberAction(checkoutModel, 5), 1, 1, numberFontSize)
  var buttonSix: SelfCheckoutButton = new SelfCheckoutButton("6", new NumberAction(checkoutModel, 6), 1, 1, numberFontSize)

  var buttonSeven: SelfCheckoutButton = new SelfCheckoutButton("7", new NumberAction(checkoutModel, 7), 1, 1, numberFontSize)
  var buttonEight: SelfCheckoutButton = new SelfCheckoutButton("8", new NumberAction(checkoutModel, 8), 1, 1, numberFontSize)
  var buttonNine: SelfCheckoutButton = new SelfCheckoutButton("9", new NumberAction(checkoutModel, 9), 1, 1, numberFontSize)

  var clearButton: SelfCheckoutButton = new SelfCheckoutButton("Clear", new ClearAction(checkoutModel))
  var buttonZero: SelfCheckoutButton = new SelfCheckoutButton("0", new NumberAction(checkoutModel, 0), 1, 1, numberFontSize)
  var enterButton: SelfCheckoutButton = new SelfCheckoutButton("Enter", new EnterAction(checkoutModel))

  var checkoutButton: SelfCheckoutButton = new SelfCheckoutButton("Check Out", new CheckoutAction(checkoutModel))
  var payCashButton: SelfCheckoutButton = new SelfCheckoutButton("Cash", new CashAction(checkoutModel))
  var payCreditButton: SelfCheckoutButton = new SelfCheckoutButton("Credit", new CreditAction(checkoutModel))
  var loyaltyCardButton: SelfCheckoutButton = new SelfCheckoutButton("Loyalty Card", new LoyaltyAction(checkoutModel))


  stage = new PrimaryStage {
    title = "Self Checkout"
    scene = new Scene() {
      content = List(
        new GridPane {
          hgap = 0.0
          vgap = 0.0

          add(scanField, 0, 0, 4, 1)

          add(buttonOne, 0, 1)
          add(buttonTwo, 1, 1)
          add(buttonThree, 2, 1)

          add(buttonFour, 0, 2)
          add(buttonFive, 1, 2)
          add(buttonSix, 2, 2)

          add(buttonSeven, 0, 3)
          add(buttonEight, 1, 3)
          add(buttonNine, 2, 3)

          add(clearButton, 0, 4)
          add(buttonZero, 1, 4)
          add(enterButton, 2, 4)


          add(checkoutButton, 3, 1)
          add(payCashButton, 3, 2)
          add(payCreditButton, 3, 3)
          add(loyaltyCardButton, 3, 4)


          add(receiptArea, 4, 0, 2, 5)
        }
      )
    }

    updateDisplay()

    addEventFilter(MouseEvent.MOUSE_CLICKED, (_: MouseEvent) => {
      updateDisplay()
    })

  }

  def updateDisplay(): Unit = {
    receiptArea.clear()
    for(item <- checkoutModel.itemsInCart()) {
      receiptArea.addItem(item)
    }
    receiptArea.addTotals(checkoutModel.subtotal(), checkoutModel.tax(), checkoutModel.total())

    scanField.text.value = checkoutModel.displayString()
  }


}
