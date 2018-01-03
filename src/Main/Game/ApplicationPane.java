package Main.Game;

import Main.Game.TextPane.TextPane;
import Main.Game.VisualPane.Level;
import Main.Game.VisualPane.VisualPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import Main.Util.Constants;
import Main.Game.VisualPane.Character;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.*;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
class ApplicationPane extends Pane {

  // Panes
  private VisualPane visualPane;
  private TextPane textPane;

  // Characters
  private ArrayList<Character> characters = new ArrayList<>();
  private Character player;

  // Levels
  private ArrayList<Level> levels = new ArrayList<>();
  private int levelnummer = 0;

  // Graphics
  private String background;
  private String foreground;
  private int walkCounter = 1;
  private boolean flip = false;
  private boolean reverse = false;

  // Gameflow
  private boolean printed = false;
  private boolean holdGame = false;
  private int textspeed = 10;
  private int counter = -500;
  private boolean Heks = true;

  ApplicationPane(){
    initialize();
    setLevels();
    setCharacters(0);
    loadLevel(levelnummer);
    player.draw();

    setOnKeyPressed(event -> {
      if(!holdGame) {
        switch (event.getCode()) {
          case RIGHT:
            if (player.x > Constants.width) {
              levelnummer++;
              levelnext();
              player.x = 50;
            }
            if(levelnummer==0 && player.x > 60 && Heks ){
              Heks = false;
              witchEntrance();
            }
            player.addX(20);
            visualPane.drawBackground(background);
            for (Character character : characters) {
              character.draw();
            }
            visualPane.drawPath("Lopen F" + walkCounter + ".png", player.x, player.y);
            if (reverse) {
              walkCounter--;
            } else {
              walkCounter++;
            }
            if (walkCounter > 5) {
              this.reverse = true;
              walkCounter--;
            } else if (walkCounter < 1) {
              this.reverse = false;
              walkCounter++;
            }
            flip = false;
            //visualPane.drawBackground(foreground);
            break;

          case LEFT:
            if (player.x < 0) {
              if (levelnummer == 0) {
                break;
              }
              levelnummer--;
              levelnext();
              player.x = Constants.width;
            }

            player.addX(-20);
            visualPane.drawBackground(background);
            for (int i = 0; i < characters.size(); i++) {
              characters.get(i).draw();
            }
            visualPane.drawFlip("Lopen F" + walkCounter + ".png", player.x, player.y);
            if (reverse) {
              walkCounter--;
            } else {
              walkCounter++;
            }
            if (walkCounter > 5) {
              this.reverse = true;
              walkCounter--;
            } else if (walkCounter < 1) {
              this.reverse = false;
              walkCounter++;
            }
            flip = true;
            //visualPane.drawBackground(foreground);
            break;

          case ENTER:
            for (Character character : characters) {
              if (character.x < player.x + player.image.getWidth() * 3 / 4 && player.x < character.x + character.image.getWidth() * 3 / 4) {
                printed = true;
                textPane.print(character.speak(), textspeed);
                break;
              }
            }
            if (!printed) {
              textPane.print("Nothing important here.", textspeed);
            }
            printed = false;
            break;

          case ESCAPE:
            Platform.exit();
            break;
        }
      }
    });

    this.setOnKeyReleased (event -> {
      reverse = false;
      visualPane.drawBackground(background);
      for(int i = 0; i < characters.size(); i++){
        characters.get(i).draw();
      }
      if (flip){
        visualPane.drawFlip("Staand.png", player.x, player.y);
      } else {
        visualPane.drawPath("Staand.png", player.x, player.y);
      }
      walkCounter = 1;

    });
  }

  private void loadLevel(int levelNumber){
    Level level = levels.get(levelNumber);
    background = level.getBackground();
    foreground = level.getForeground();
    characters = level.getCharacters();
  }

  private void setLevels() {
    ArrayList<Character> tempchars = new ArrayList<>();
    ArrayList<Character> Level2 = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    text.add("Yvan is een goede programmeur.");
    text.add("PRANKED");
    tempchars.add(new Character("Langsvliegheks.png", visualPane, text, -500, 0));
    tempchars.add(new Character("test.png", visualPane, text, 1000, 0));
    //Level2.add(new Character("Langsvliegheks.png", visualPane, text, 0, 0));
    levels.add(new Level("testbackground1.png", "testforeground.png", "cane", tempchars));
    levels.add(new Level("kerkhof.png", "testforeground.png", "cane", Level2));
  }

  private void setCharacters(int levelNumber) {
    for (Character character : levels.get(levelNumber).getCharacters()){
      character.draw();
      characters.add(character);
    }
  }

  private void initialize(){
    background = "testbackground1.png";
    foreground = "testforeground.png";

    Canvas canvas = new Canvas(Constants.width, (Constants.height * 2 / 3) / Constants.heightScale);
    this.visualPane = new VisualPane(canvas);
    this.textPane = new TextPane();
    BorderPane root = new BorderPane();
    root.setTop(canvas);
    root.setBottom(textPane);
    getChildren().add(root);

    player = new Character("Staand.png", visualPane, null, 50, 300);
  }

  public void levelnext () {
      loadLevel(levelnummer);
      player.draw();
  }

  void witchEntrance() {
    holdGame = true;
    Timeline timeline = new Timeline(
      new KeyFrame(
        Duration.millis(40),
        event -> {
          counter += 25;
          visualPane.drawBackground(background);
          for (Character character : characters) {
            character.draw();
          }
          visualPane.drawPath("Staand" + ".png", player.x, player.y);
          characters.get(0).x = counter;
          visualPane.drawImage(characters.get(0).image, counter, 0);
          if (counter >= 2000) holdGame = false;
        }
      )
    );
    timeline.setCycleCount(100);
    timeline.play();
  }
}