package Main.Game;

import Main.Game.TextPane.TextPane;
import Main.Game.VisualPane.VisualPane;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import Main.Util.Constants;
import Main.Game.VisualPane.Character;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import java.util.*;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
class ApplicationPane extends Pane {

  VisualPane visualPane;
  TextPane textPane;
  ArrayList<Character> characters = new ArrayList<>();
  String background;
  String foreground;

  ApplicationPane(){
    initialize();

    this.setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case UP:
          System.out.println("jaa");
          characters.get(0).addX(5);
          visualPane.drawBackground(background);
          for(Character character : characters){
            character.draw();
          }
          visualPane.drawImage(characters.get(0).getPath(), characters.get(0).x, characters.get(0).y);
          //visualPane.drawBackground(foreground);
          break;

        case DOWN:
          System.out.println("ne");
          characters.get(0).addX(-5);
          visualPane.drawBackground(background);
          for(Character character : characters){
            character.draw();
          }
          visualPane.drawImage(characters.get(0).getPath(), characters.get(0).x, characters.get(0).y);
          //visualPane.drawBackground(foreground);
          break;

        case ESCAPE:
          Platform.exit();
      }
    });
  }

  public void addCharacter(Character character){
    characters.add(character);
  }

  void initialize(){
    background = "testbackground.png";
    foreground = "testforeground.png";
    Canvas canvas = new Canvas(Constants.width, (Constants.height * 6 / 8));
    this.visualPane = new VisualPane(canvas);
    this.textPane = new TextPane();
    BorderPane root = new BorderPane();
    root.setTop(canvas);
    root.setBottom(textPane);
    getChildren().add(root);

    addCharacter(new Character("test.png", visualPane));
  }
}
