package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, LoyaltySale, Modifier, Sale, SalesTax}

class ApplicationObjective extends FunSuite {
  var testItem: Item = new Item("test item", 10.0)
  var testItemagain: Item = new Item("protein", 2.0)
  var testSelfCheckout: SelfCheckout = new SelfCheckout()

  testSelfCheckout.addItemToStore("123", testItem)
  testSelfCheckout.addItemToStore("001", testItemagain)



  val checkloyalty: Modifier = new LoyaltySale(50)
  testItem.addModifier(checkloyalty)



  //epsilon value
  val epsilon: Double = 0.001
  def compareDoubles( d1: Double, d2: Double): Boolean =
  {
    Math.abs(d1-d2) < epsilon
  }

  test(" buying an item with a sale") {
    //first item before pressed
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 5.0))
    testSelfCheckout.loyaltyCardPressed()
    testSelfCheckout.loyaltyCardPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 5.0))
    //second item after pressed
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart()(1).price(), 5.0))
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.cashPressed()
    //second sale
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 10.0))
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 5.0))
    testSelfCheckout.creditPressed()

  }
}
