package Main.Game;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


class ApplicationMenu extends Pane {

  ApplicationMenu(Button button1, Button button2) {
    BorderPane root = new BorderPane();
    root.setTop(button1);
    root.setBottom(button2);
    getChildren().add(root);

  }
}
