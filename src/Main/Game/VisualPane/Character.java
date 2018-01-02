package Main.Game.VisualPane;

import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class Character {

  public Image image;
  private VisualPane pane;
  public int x;
  public int y;
  private ArrayList<String> text = new ArrayList<>();
  private int printCounter = 0;

  public Character(String path, VisualPane pane, ArrayList<String> text){
    image =  new Image((getClass().getResourceAsStream(path)));
    this.pane = pane;
    this.text = text;
    this.x = 0;
    this.y = 400;
  }

  public Character(String path, VisualPane pane, ArrayList<String> text, int x , int y){
    image =  new Image((getClass().getResourceAsStream(path)));
    this.pane = pane;
    this.text = text;
    this.x = x;
    this.y = y;
  }

  public void addX(int amount) {
    this.x += amount;
  }

  public void draw(){
    pane.drawImage(image, x, y);
  }

  public String speak(){
    if (printCounter >= text.size()) printCounter = text.size() - 1;
    String tempString = text.get(printCounter);
    printCounter++;
    return tempString;
  }

}
