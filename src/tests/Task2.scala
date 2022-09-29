package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, Modifier, Sale, SalesTax}

class Task2 extends FunSuite{

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

  test(" buying an item with a sale")
  {

    //puts two items in cart
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()

    val cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size ==2)
    assert(cart.head.description() == "test item")
    assert(cart(1).description() =="test item")
    assert(compareDoubles(cart.head.price(),10))

    val taxes: Modifier = new SalesTax(10)
    testItem.addModifier(taxes)


    val sale: Modifier = new Sale(50)
    testItem.addModifier(sale)

    assert(compareDoubles(cart.head.price(),5.0))
    assert(compareDoubles(cart(1).price(),5.0))
    assert(compareDoubles(testSelfCheckout.subtotal(),10))
    //its one cuz (5+5)/10
    assert(compareDoubles(testSelfCheckout.tax(),1))
    assert(compareDoubles(cart.head.tax(),0.5))
    assert(compareDoubles(cart(1).tax(),0.5))
    assert(compareDoubles(testSelfCheckout.total(),11))

    val checkbottle: BottleDeposit = new BottleDeposit(10)
    testItem.addModifier(checkbottle)
    assert(compareDoubles(cart.head.tax(),10.5))


    val checksale: Modifier = new Sale(50)
    testItem.addModifier(checksale)

    assert(compareDoubles(cart(1).price(),2.5))
    assert(compareDoubles(cart.head.price(),2.5))
    //assert(compareDoubles(testSelfCheckout.total(),5.25))


  }
}
