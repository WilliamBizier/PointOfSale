package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, Modifier, Sale, SalesTax}

class Task3 extends FunSuite {

  var testItem: Item = new Item("test item", 10.0)
  var testItemagain: Item = new Item("protein", 2.0)
  var testSelfCheckout: SelfCheckout = new SelfCheckout()

  testSelfCheckout.addItemToStore("123", testItem)
  testSelfCheckout.addItemToStore("001", testItemagain)


  //epsilon value
  val epsilon: Double = 0.001
  def compareDoubles( d1: Double, d2: Double): Boolean =
  {
    Math.abs(d1-d2) < epsilon
  }

  test(" buying an item with a sale") {
    //first scan
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()

    assert(testSelfCheckout.itemsInCart().size==4)
    assert(testSelfCheckout.itemsInCart().head.description() == "error")
    assert(testSelfCheckout.itemsInCart()(1).description() == "error")
    assert(testSelfCheckout.itemsInCart()(2).description() == "test item")
    assert(testSelfCheckout.itemsInCart()(3).description() == "test item")
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 0.0))
    assert(compareDoubles(testSelfCheckout.itemsInCart()(1).price(), 0.0))
    assert(compareDoubles(testSelfCheckout.itemsInCart()(2).price(), 10.0))
    assert(compareDoubles(testSelfCheckout.itemsInCart()(3).price(), 10.0))

    //the first check out
    //testSelfCheckout.itemsInCart()_not_emptied_for_next_customer
    testSelfCheckout.checkoutPressed()
    assert(testSelfCheckout.displayString()=="cash or credit")
    testSelfCheckout.cashPressed()
    assert(testSelfCheckout.displayString()=="")
    assert(testSelfCheckout.itemsInCart().size==0)


  }
}
