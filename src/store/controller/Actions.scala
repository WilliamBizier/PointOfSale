package store.controller

import javafx.event.{ActionEvent, EventHandler}
import store.model.checkout.SelfCheckout

/**
 * EventHandlers for each of the buttons on the SelfCheckout. NumberAction takes
 * an Int representing the number button that was pressed. You may assume
 * that each of these classes has a reference to the same SelfCheckout object.
 */

class NumberAction(selfCheckoutModel: SelfCheckout, number: Int) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    selfCheckoutModel.numberPressed(number)
  }
}

class ClearAction(selfCheckoutModel: SelfCheckout) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    selfCheckoutModel.clearPressed()
  }
}

class EnterAction(selfCheckoutModel: SelfCheckout) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    selfCheckoutModel.enterPressed()
  }
}

class CheckoutAction(selfCheckoutModel: SelfCheckout) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    selfCheckoutModel.checkoutPressed()
  }
}

class CashAction(selfCheckoutModel: SelfCheckout) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    selfCheckoutModel.cashPressed()
  }
}

class CreditAction(selfCheckoutModel: SelfCheckout) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    selfCheckoutModel.creditPressed()
  }
}

class LoyaltyAction(selfCheckoutModel: SelfCheckout) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    selfCheckoutModel.loyaltyCardPressed()
  }
}
