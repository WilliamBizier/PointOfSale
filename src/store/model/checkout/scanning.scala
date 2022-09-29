package store.model.checkout

import store.model.items.Item

class scanning(state1: SelfCheckout) extends baseframe(state1){

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def numberPressed(number: Int): Unit = {
    state1.display += number.toString
    state1.display2=state1.display
    // TODO
  }

  override def clearPressed(): Unit = {
    state1.display =""
    // TODO
  }

  override def enterPressed(): Unit =
  {
    state1.display=""
    val erroritem: Item = new Item("error",0.0)
    var itemcodes: Item = state1.storeitems.getOrElse(state1.display2,erroritem)
    state1.listofitems = state1.listofitems :+ itemcodes

  }

  override def checkoutPressed(): Unit = {
    state1.display="cash or credit"
    state1.state=new checkoutstate(state1)
  }



}
