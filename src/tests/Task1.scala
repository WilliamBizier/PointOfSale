package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite
{
  var testItem: Item = new Item("test item", 1.0)
  var lditem: Item = new Item("protein", 2.0)
  var testSelfCheckout: SelfCheckout = new SelfCheckout()
  testSelfCheckout.addItemToStore("123", testItem)
  testSelfCheckout.addItemToStore("001", lditem)
  var tolerance: Double = 0.00001

  test("test 1: simulation of buying shit lmao"){
    //check the initial clear string
    assert(testSelfCheckout.displayString() == "", "why")
    //enter a initial item
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    assert(testSelfCheckout.displayString()=="123")
    //enter the item see if it has the correct price and description
    testSelfCheckout.enterPressed()
    val correct: Item = testSelfCheckout.itemsInCart()(0)
    assert(correct.description() == "test item")
    //check for leading zeros
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    assert(testSelfCheckout.displayString()=="001")
    testSelfCheckout.enterPressed()
    val correct1: Item = testSelfCheckout.itemsInCart()(1)
    assert(correct1.description() == "protein")
    //clear shit
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString()=="")
    //order in cart
    assert((correct.description() == "test item")&&(correct1.description() == "protein"))
    //error testing
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart()(2).description()=="error")
    //change the mofo price of something
    testItem.setBasePrice(420.0)
    val checkprice: Double = Math.abs(testItem.price()-420.0)
    assert(checkprice<tolerance,"Here")
    assert(Math.abs(testSelfCheckout.itemsInCart()(0).price()-420.0)<tolerance)


  }
  test("test 2: What ever paul did") {
    //    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    //
    //    var testItem: Item = new Item("test item", 100.0)
    //
    //    testSelfCheckout.addItemToStore("123", testItem)
    // TODO
    var descriptions:List[String]=List()
    var prices:List[Double]=List()
    descriptions=descriptions:+"My description"
    prices=prices:+5.99
    descriptions=descriptions:+"Oreos"
    prices=prices:+4.50
    var items:List[Item]=List()
    for (index <- descriptions.indices){
      items=items:+new Item(descriptions(index),prices(index))

      assert(items(index).description()==descriptions(index),"testing description "+
        "explected: "+descriptions(index)+" actually got: "+items(index).description())
      assert(Math.abs(items(index).price()-prices(index))<.0001,"testing constructor "+
        "expected: "+prices(index)+" got: "+items(index).price())
      items(index).setBasePrice(prices(index)-5)
      assert(Math.abs(items(index).price()-(prices(index)-5))<.0001,"testing setBasePrice "+
        "expected: "+(prices(index)-5)+" got: "+items(index).price())
    }

  }
  /*
      assert(testItem.description() == "test item", "this")
    val bpcheck: Double = Math.abs(testItem.price() - 1.0)
    assert(bpcheck < tolerance, "There")
  }

  test("test 2: price change doesnt update items in the cart"){
    testItem.setBasePrice(420)
    val checkprice: Double = Math.abs(testItem.price()-420.0)
    assert(checkprice<tolerance,"Here")
  }

  test("test 3: doesnt intially display empty string ")
  {
    assert(testSelfCheckout.displayString() == "", "why")
  }

  test("test 3: display broken")
  {
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    assert(testSelfCheckout.displayString()=="123")
  }

  test("test 4: clear doesn't clear ")
  {
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString() == "", "here")
  }

  test("test 5: enter pressed checks")
  {
    //error function
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    //first item in cart
    val Er: Item = testSelfCheckout.itemsInCart()(0)
    assert(Er.description() == "error", "this")
    val pricecheck: Double = Math.abs(Er.price() - 0.0)
    assert(pricecheck < tolerance, "There")
    //part 2
    //correct enter pressed function
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    //second item in cart
    val correct: Item = testSelfCheckout.itemsInCart()(1)
    assert(correct.description() == "test item")
    val pricecheck1: Double = Math.abs(testItem.price() - 420.0)
    assert(pricecheck1 < tolerance, "There")
    testSelfCheckout.clearPressed()

  }

  test("test 6: leading zeros"){
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.enterPressed()
    //third item in cart
    val zeros: Item = testSelfCheckout.itemsInCart()(2)
    assert(zeros.description()=="protein")
    val checkprice3: Double = Math.abs(lditem.price() - 2.0)
    assert(checkprice3 < tolerance, "There")
    assert(zeros.price()==2.0)

  }
   */
}