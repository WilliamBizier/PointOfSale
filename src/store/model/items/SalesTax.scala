package store.model.items

class SalesTax (percsaletax: Double) extends Modifier{
  override var state = 0.0
  override def updatePrice(premod: Double): Double = {
    premod
  }
  override def computeTax(priceItem: Double): Double = {
    var cock: Double = (this.percsaletax/100)*priceItem
    cock
  }
}
