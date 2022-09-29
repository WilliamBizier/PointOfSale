package store.model.checkout

import store.model.items.{Item, LoyaltySale, On}

class SelfCheckout {
  var display: String = ""
  var storeitems: Map[String,Item]=Map()
  var listofitems:List[Item]=List()
  var display2: String =""

  var state : baseframe = new scanning(this)

  def addItemToStore(barcode: String, item: Item): Unit =
  {
    storeitems=storeitems+(barcode ->item)


    // This method adds an item to your store's checkout system. It does not add an item to the customer's cart
    // TODO
  }

  def numberPressed(number: Int): Unit = {
   this.state.numberPressed(number)
    // TODO
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
    // TODO
  }

  def enterPressed(): Unit =
  {
   this.state.enterPressed()
  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    this.state.creditPressed()
  }

  def loyaltyCardPressed(): Unit = {
    for (item <- storeitems.values){
      for (q <-item.listofmods){
        q.state=new On().loyatlystate
      }
    }
    // TODO
  }

  def displayString(): String = {
    display

  }


  def itemsInCart(): List[Item] = {

    this.listofitems
  }

  def subtotal(): Double = {
    var jerseymikes: Double =0.0
    for (i <-this.itemsInCart()){
      jerseymikes=jerseymikes+i.price()
    }
    jerseymikes
  }

  def tax(): Double = {
    var jerseymikes: Double =0.0
    for (i <-this.itemsInCart()){
      jerseymikes=jerseymikes+i.tax()
    }
    jerseymikes
  }

  def total(): Double = {
    var ttl: Double = tax()+subtotal()
    ttl
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you88 can
    // write a similar method in your Test Suite classes.

    // Example usage:
    val testItem: Item = new Item("test item", 100.0)
    testItem.addModifier(new LoyaltySale(50))
    this.addItemToStore("111", testItem)


  }

}