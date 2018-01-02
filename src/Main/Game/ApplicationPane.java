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

  private VisualPane visualPane;
  private TextPane textPane;
  private ArrayList<Character> characters = new ArrayList<>();
  private Character player;
  private ArrayList<Level> levels = new ArrayList<>();
  private String background;
  private String foreground;
  private int walkCounter = 1;
  private boolean flip = false;

  ApplicationPane(){
    initialize();
    setLevels();
    setCharacters(0);
    loadLevel(0);
    player.draw();

    setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case UP:
          System.out.println("jaa");
          player.addX(20);
          visualPane.drawBackground(background);
          for(int i = 0; i < characters.size(); i++){
            characters.get(i).draw();
          }
          visualPane.drawPath("Lopen F" + walkCounter + ".png", player.x, player.y);
          walkCounter++;
          if(walkCounter > 5){
            walkCounter = 1;
          }
          flip = false;
          //visualPane.drawBackground(foreground);
          break;

        case DOWN:
          System.out.println("ne");
          player.addX(-15);
          visualPane.drawBackground(background);
          for(int i = 0; i < characters.size(); i++){
            characters.get(i).draw();
          }
          visualPane.drawFlip("Lopen F" + walkCounter + ".png", player.x, player.y);
          walkCounter++;
          if(walkCounter > 5){
            walkCounter = 1;
          }
          flip = true;
          //visualPane.drawBackground(foreground);
          break;

          case ENTER:
              System.out.println("Dit wordt redelijk hard geprint.");
              for (Character character : characters) {
                  if (character.x < player.x + player.image.getWidth() && player.x < character.x + character.image.getWidth()){
                    System.out.println(character.speak());
                  }
              }
              break;


          case ESCAPE:
          Platform.exit();
          break;
      }
    });

    this.setOnKeyReleased (event -> {

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

//  public void addCharacter(Character character){
//    characters.add(character);
//  }

  private void loadLevel(int levelNumber){
    Level level = levels.get(levelNumber);
    background = level.getBackground();
    foreground = level.getForeground();
    characters = level.getCharacters();
  }

  private void setLevels(){
    ArrayList<Character> tempchars = new ArrayList<>();
    tempchars.add(new Character("test.png", visualPane, 1000, 200));
    levels.add(new Level("testbackground1.png", "testforeground.png", "cane", tempchars));
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

    Canvas canvas = new Canvas(Constants.width, (Constants.height * 6 / 8));
    this.visualPane = new VisualPane(canvas);
    this.textPane = new TextPane();
    BorderPane root = new BorderPane();
    root.setTop(canvas);
    root.setBottom(textPane);
    getChildren().add(root);

    player = new Character("Staand.png", visualPane, 50, 400);
  }
}
