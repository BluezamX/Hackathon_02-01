package Main.Game.VisualPane;

import javafx.scene.image.Image;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class Character {

  public Image image;
  private VisualPane pane;
  public int x;
  public int y;

  public Character(String path, VisualPane pane){
    image =  new Image((getClass().getResourceAsStream(path)));
    this.pane = pane;
    this.x = 0;
    this.y = 512;
  }

  public Character(String path, VisualPane pane, int x , int y){
    image =  new Image((getClass().getResourceAsStream(path)));
    this.pane = pane;
    this.x = x;
    this.y = y;
  }



  public void addX(int amount) {
    this.x += amount;
  }

  public void draw(){
    pane.drawImage(image, x, y);
  }

  public boolean checkSpeakable(double x , double y){
    if(image.getWidth() + this.x > x  && x > this.x ){
        System.out.println("Je moeder");
        return true;
    }
      System.out.println("sad");
   return false;
  }
}
