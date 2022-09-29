package store.model.checkout

abstract class baseframe(val state1: SelfCheckout){

  def clearPressed(): Unit = {}

  def enterPressed(): Unit = {}

  def checkoutPressed(): Unit = {}

  def cashPressed(): Unit = {}

  def creditPressed(): Unit = {}

  def numberPressed(num:Int): Unit = {}

}
