package store.model.items




class   Item (var Desc: String, var Price: Double){
  // TODO: Complete this class according to the features listed in the HW document
  var listofmods:List[Modifier]= List()

  def description(): String =
  {
    this.Desc;
  }
  def setBasePrice(initprice: Double): Unit =
  {
    this.Price = initprice;
  }
  //
  def price(): Double = {
    var postprice: Double = this.Price
    for (mods <- listofmods){
      postprice=mods.updatePrice(postprice)
    }
    postprice
  }
  def tax(): Double = {
    var bprice: Double=price()
    var taxtotal: Double=0.0
    for (mods <- listofmods){
      taxtotal+=mods.computeTax(bprice)
    }
    taxtotal
  }

  def addModifier(modifier: Modifier): Unit ={
    listofmods=listofmods:+modifier

  }

}
