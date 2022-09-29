package store.model.items

class LoyaltySale (var percofsale: Double) extends Modifier {
  override var state = new Off().loyatlystate

  override def updatePrice(premod: Double): Double = {
    var saleprice:Double = premod-(((percofsale/100)*premod)*state)
    saleprice
  }

  override def computeTax(priceItem: Double): Double = {
    0.0
  }

}
