package Main.Game;

import Main.Game.TextPane.TextPane;
import Main.Game.VisualPane.VisualPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class ApplicationPane extends Pane {


  ApplicationPane(){
    VisualPane visualPane =  new VisualPane();
    TextPane textpane = new TextPane();
    BorderPane root = new BorderPane();
    root.setTop(visualPane);
    root.setBottom(textpane);
    getChildren().add(root);
  }
}
