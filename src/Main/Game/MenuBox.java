package Main.Game;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by jaspe on 03/01/2018.
 *
 */
class MenuBox extends VBox {
  MenuBox(Button button1, Button button2){
    getChildren().add(button1);
    getChildren().add(button2);
  }
}
