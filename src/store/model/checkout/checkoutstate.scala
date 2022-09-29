package store.model.checkout

import store.model.checkout.baseframe
import store.model.items.{Off, On}

class checkoutstate (state1: SelfCheckout) extends baseframe(state1){



  override def clearPressed(): Unit = {
    //nothing
  }

  override def enterPressed(): Unit = {
    //nothing
  }

  override def checkoutPressed(): Unit = {
    //nothing
  }

  override def cashPressed(): Unit = {
    state1.listofitems=List()
    state1.display=""
    state1.state=new scanning(state1)

    for (item <- state1.storeitems.values){
      for (q <-item.listofmods){
        q.state=new Off().loyatlystate
      }
    }
  }

  override def creditPressed(): Unit = {
    state1.listofitems=List()
    state1.display=""
    state1.state=new scanning(state1)

    for (item <- state1.storeitems.values){
      for (q <-item.listofmods){
        q.state=new Off().loyatlystate
      }
    }
  }

  override def numberPressed(num: Int): Unit = {
    //nothing
  }



}
