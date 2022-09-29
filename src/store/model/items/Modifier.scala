package store.model.items

abstract class Modifier {


  def updatePrice(premod: Double): Double = {
    0.0
  }

  def computeTax(priceItem:Double): Double = {
    0.0
  }

  //for the loyalty card
  var state: Double
}
