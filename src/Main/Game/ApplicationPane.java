package Main.Game;

import Main.Game.TextPane.TextPane;
import Main.Game.VisualPane.Level;
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
  ArrayList<Level> levels = new ArrayList<>();
  String background;
  String foreground;
  int walkCounter;

  ApplicationPane(){
    initialize();
    setLevels();
    setCharacters(0);

    this.setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case UP:
          System.out.println("jaa");
          characters.get(0).addX(20);
          visualPane.drawBackground(background);
          for(Character character : characters){
            character.draw();
          }
          visualPane.drawImage("Lopen F" + walkCounter + ".png", characters.get(0).x, characters.get(0).y);
          //visualPane.drawBackground(foreground);
          break;

        case DOWN:
          System.out.println("ne");
          characters.get(0).addX(-15);
          visualPane.drawBackground(background);
          for(Character character : characters){
            character.draw();
          }
          visualPane.drawFlip("Lopen F" + walkCounter + ".png", characters.get(0).x, characters.get(0).y);
          //visualPane.drawBackground(foreground);
          break;

        case ESCAPE:
          Platform.exit();
      }
    });

    this.setOnKeyReleased (event -> {
      switch (event.getCode()) {
        default:
          
          break;
      }
    });
  }

  public void addCharacter(Character character){
    characters.add(character);
  }

  void loadLevel(int levelNumber){
    Level level = levels.get(levelNumber);
    background = level.getBackground();
    foreground = level.getForeground();
    characters = level.getCharacters();
  }

  void setLevels(){
    ArrayList<Character> tempchars = new ArrayList<Character>();
    tempchars.add(new Character("test.png", visualPane));
    levels.add(new Level("testbackground.png", "testforeground.png", "cane", tempchars));
  }

  void setCharacters(int levelNumber) {
    for (Character character : levels.get(levelNumber).getCharacters()){
      character.draw();
      characters.add(character);
    }
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
  }
}
