package Main.Game;

import Main.Game.OptionPane.OptionPane;
import Main.Game.TextPane.TextPane;
import Main.Game.VisualPane.Level;
import Main.Game.VisualPane.VisualPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import Main.Util.Constants;
import Main.Game.VisualPane.Character;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.util.*;

/**
 * Created by jaspe on 02/01/2018.
 *
 */

public class ApplicationPane extends Pane {

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

  // Audio
  private int volume;

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
      switch (event.getCode()) {
        case EQUALS:
          if (volume < 10) volume++;
          break;

        case MINUS:
          if (volume > 0) volume--;
          break;
      }
      if(!holdGame) {
        switch (event.getCode()) {
          case RIGHT:
            if (player.x > Constants.width) {
              levelnummer++;
              levelnext();
              player.x = 50;
            }
            if(levelnummer == 9 && player.x > 60 && Heks ){
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
            for (Character character1 : characters) {
              character1.draw();
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
                if(!character.inventory.isEmpty()) {
                  if (character.inventory.get(0) == "Broek") {
                    player.addtoinventory("Broek");
                  }
                }
                String string = character.speak(player.inventory);
//                if("PLAY".equals(string.substring(0,4))){
//                  playvideo(character, string.substring(5, string.length() - 1));
//                } else {
                  textPane.print(string, textspeed);
               // }
                break;
              }
            }
            if (!printed) {
              textPane.print("Nothing important here.", textspeed);
            }
            printed = false;
            break;

          case ESCAPE:
            System.out.println("Quit");
            Platform.exit();
            break;
        }
      }
    });

    this.setOnKeyReleased (event -> {
      reverse = false;
      visualPane.drawBackground(background);
      for (Character character : characters) {
        character.draw();
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
    ArrayList<Character> broeklevel = new ArrayList<>();
    ArrayList<Character> Level2 = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> broekleveltekst = new ArrayList<>();
    ArrayList<String> pastoor = new ArrayList<>();


    text.add("Man with the beardjacket: YOoooUOUUUouuuuu, with the Magic lightbox. You have to destroy it.");
    text.add("Jake: What? Nobody commands me. I am not the one who should do something. You should go see a barber.");
    text.add("Man with the beardjacket: But haven’t you heard?");
    text.add("Man with the beardjacket: That if you want reception you have to destroy it?");
    text.add("Jake: Wait what? There is a way to get reception? Please mister tell me.");
    text.add("Man with the beardjacket: If you destroy the magic artifact. The world will be a better place. EVIL WILL BE DEFEATED!!!!");
    text.add("Jake:  Yeah Yeah Sure Sure, cool cool, but where is this so called magic artifact?");
    text.add("Man with the beardjacket: I will tell you where you can find it, if you can find my pants for me.");
    pastoor.add("Pastoor: Hello young Padawan, what are you looking for? ");
    pastoor.add("Jake: I am looking for this so called magic artefact.");
    pastoor.add("Pastoor:  Ohh I can help you, but first I need you to do something for me. You need to fill my hole. This hole. With dirt.");
    broekleveltekst.add("Jake: Aah de broek");

    String nee= "Ik vind hem anders heel goed jasper daarintegen kan niks";
    String ja = "Mee eens Jasper daarintegen...";
    tempchars.add(new Character("Langsvliegheks.png", visualPane, text, -500, 0));
    Character Haarman = new Character("Haarman.png", visualPane, text, 1200, 50, ja , nee);
    Haarman.addNeed("Broek");
    Haarman.addBericht("Man with the beardjacket: Hallelujah my son, I haven’t seen these in ages. You need to go the graveyard. There you will find your next answer.");
    tempchars.add(Haarman);
    Character Pastoor = new Character("Pastoor.png", visualPane, pastoor, 1200, 50, ja , nee);
    Character broek = new Character("Broek.png" , visualPane , broekleveltekst , 1200 , 0);
    Level2.add(Pastoor);
    broek.addtoinventory("Broek");
    broeklevel.add(broek);
    //Level2.add(new Character("Langsvliegheks.png", visualPane, text, 0, 0));
    levels.add(new Level("background.png", "testforeground.png", "cane", tempchars));
    levels.add(new Level("testbackground1.png", "testforeground.png", "cane", broeklevel));
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

    Canvas canvas = new Canvas(Constants.width, (Constants.height * 1 / 3) / Constants.heightScale);
    this.visualPane = new VisualPane(canvas);
    this.textPane = new TextPane();
    BorderPane root = new BorderPane();
    root.setTop(canvas);
    BorderPane bottom =  new BorderPane();
    root.setBottom(textPane);
    getChildren().add(root);

    volume = 8;
    player = new Character("Staand.png", visualPane, null, 50, 300);
  }

  private void levelnext () {
      loadLevel(levelnummer);
      player.draw();
  }

  private void witchEntrance() {
    holdGame = true;
    Timeline timeline = new Timeline(
      new KeyFrame(
        Duration.millis(30),
        event -> {
          counter += 25;
          visualPane.drawBackground(background);
          for (int i = 1; i < characters.size(); i++) {
            characters.get(i).draw();
          }
          visualPane.drawPath("Staand" + ".png", player.x, player.y);
          characters.get(0).y = characters.get(0).y - 2;
          visualPane.drawImage(characters.get(0).image, counter, characters.get(0).y);
          if (counter >= 2000) holdGame = false;
        }
      )
    );
    timeline.setCycleCount(100);
    timeline.play();
  }

  public void praat(boolean jaofnee) {
    for (Character character : characters) {

      if (character.x < player.x + player.image.getWidth() * 3 / 4 && player.x < character.x + character.image.getWidth() * 3 / 4) {
        printed = true;
        if(character.speak(jaofnee) != null) {
          textPane.print(character.speak(jaofnee), textspeed);
          break;
        }
        textPane.print("Ik heb daar geen antwoord op" , textspeed);
        break;
      }
    }

    if(!printed){
      textPane.print("Waarom praat je tegen jezelf?" , textspeed);

    }
    printed = false;
  }

  private void playvideo(Character character, String path){
//    Media media = new Media("test.mp4");
//    try{
//      File video = new File(path);
//      String url = video.toURI().toURL().toString();
//      media = new Media(url);
//    } catch (Exception e){
//    }
    MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource(path).toExternalForm()));
    mediaPlayer.play();
    MediaView mediaView = new MediaView(mediaPlayer);
    mediaView.setFitHeight(Constants.height / Constants.heightScale);
    getChildren().add(mediaView);
  }
}