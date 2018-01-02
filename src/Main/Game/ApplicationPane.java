package Main.Game;

import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class ApplicationPane extends Pane {

  private final TabPane tabs;

  ApplicationPane(){
    this.tabs = new TabPane();
    getChildren().add(tabs);
  }
}
