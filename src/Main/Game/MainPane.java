package Main.Game;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by jaspe on 03/01/2018.
 *
 */
class MainPane extends Pane {

  private GameBox gameBox;
  private OptionBox optionBox;
  private MenuBox menuBox;

  private Button startknop = new Button("Start");
  private Button optieknop = new Button("Opties");

  MainPane(){
    gameBox = new GameBox();
    optionBox = new OptionBox();
    startknop.setOnAction(
        e -> {
          getChildren().clear();
          getChildren().add(gameBox);
        });
    optieknop.setOnAction(
        e -> {
          getChildren().clear();
          getChildren().add(optionBox);
        });
    menuBox = new MenuBox(startknop, optieknop);
    getChildren().add(menuBox);
  }

  private void application(){
    getChildren().clear();
    getChildren().add(gameBox);
  }

  private void menu(){
    getChildren().clear();
    getChildren().add(menuBox);
  }
}
