package Main.Game;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Created by jaspe on 03/01/2018.
 *
 */
class MainPane extends Pane {

  ApplicationPane applicationPane;
  ApplicationMenu menu;

  Button startknop = new Button("Start");
  Button optieknop = new Button("Opties");

  MainPane(){
    startknop.addEventHandler(MouseEvent.MOUSE_CLICKED,
        e -> {
          application();
        });
    optieknop.addEventHandler(MouseEvent.MOUSE_CLICKED,
        e -> {
          application();
        });
    applicationPane = new ApplicationPane();
    menu = new ApplicationMenu(startknop, optieknop);
    getChildren().add(menu);
  }

  private void application(){
    getChildren().clear();
    getChildren().add(applicationPane);
  }

  private void menu(){
    getChildren().clear();
    getChildren().add(menu);
  }
}
