package Main.Game.VisualPane;

import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class Level {

  private String background;
  private String foreground;
  private Button clickable;
  private ArrayList<Character> characters = new ArrayList<>();

  public Level (String background, String foreground, String button, ArrayList<Character> characters){
    this.background = background;
    this.foreground = foreground;
    this.clickable = new Button(button);
    this.characters = characters;
  }

  public String getBackground(){
    return background;
  }

  public String getForeground(){
    return foreground;
  }

  public ArrayList<Character> getCharacters(){
    return characters;
  }
}
