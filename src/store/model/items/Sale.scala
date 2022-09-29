package store.model.items

class Sale(percofsale: Double)extends Modifier{

  override var state = 0.0
  override def updatePrice(premod: Double): Double = {
    var saleprice:Double = premod-((percofsale/100)*premod)
    saleprice
  }

  override def computeTax(priceItem: Double): Double = {
    0.0
  }
}

