package store.view

import scalafx.scene.control.TextArea
import store.model.items.Item

class ReceiptDisplay() extends TextArea {

  val receiptDisplayWidth: Int = 30

  editable = false
  prefColumnCount = receiptDisplayWidth
  prefRowCount = 17
  style = "-fx-font: 12 consolas;"

  def addItem(item: Item): Unit = {
    this.text.value += formatReceiptLine(item.description(), item.price()) + '\n'
  }

  def addTotals(subtotal: Double, tax: Double, total: Double): Unit = {
    this.text.value += "\n" * 0.max((prefRowCount.value - 4) - this.text.value.count(_ == '\n'))
    this.text.value += "-" * this.receiptDisplayWidth + '\n'
    this.text.value += formatReceiptLine("subtotal", subtotal) + '\n'
    this.text.value += formatReceiptLine("tax", tax) + '\n'
    this.text.value += formatReceiptLine("total", total)
  }

  def formatReceiptLine(description: String, price: Double): String = {
    val priceString: String = "$%.2f".format(price)
    val remainingSpace = this.receiptDisplayWidth - priceString.length() - 1
    val truncatedDescription: String = description.substring(0, 0.max(remainingSpace.min(description.length())))
    val padding: String = " " * (this.receiptDisplayWidth - priceString.length - truncatedDescription.length)
    truncatedDescription + padding + priceString
  }

}
