package store.model.items

class BottleDeposit (totalamountcharge: Double) extends Modifier {
  override var state = 0.0


  override def updatePrice(premod: Double): Double = {
    premod
  }
  override def computeTax(priceItem: Double): Double = {
    this.totalamountcharge
  }
}
