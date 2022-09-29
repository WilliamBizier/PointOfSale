package store.view

import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.Button

class SelfCheckoutButton(display: String, action: EventHandler[ActionEvent], xScale: Double = 1.0, yScale: Double = 1.0, textSize: Double = 12.0) extends Button {
  val baseWidth = 90
  val baseHeight = 60

  minWidth = baseWidth * xScale
  minHeight = baseHeight * yScale
  onAction = action
  text = display
  style = "-fx-font: " + textSize.toString + " ariel;"
}
