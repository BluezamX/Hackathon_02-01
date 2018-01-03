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
  public String Antwoordja;
  public String Antwoordnee;
  public boolean Beantwoord;
  public ArrayList<String> inventory = new ArrayList<>();
  public String need;
  public String Bendankbericht;

  public Character(String path, VisualPane pane, ArrayList<String> text){
    image =  new Image((getClass().getResourceAsStream(path)));
    this.pane = pane;
    this.text = text;
    this.x = 0;
    this.y = 400;
  }

  public Character(String path, VisualPane pane, ArrayList<String> text, int x , int y ){
    image =  new Image((getClass().getResourceAsStream(path)));
    this.pane = pane;
    this.text = text;
    this.x = x;
    this.y = y;

  }

  public Character(String path, VisualPane pane, ArrayList<String> text, int x , int y , String ja  , String nee){
    image =  new Image((getClass().getResourceAsStream(path)));
    this.pane = pane;
    this.text = text;
    this.x = x;
    this.y = y;
    this.Antwoordja = ja ;
    this.Antwoordnee = nee;

  }

  public void addX(int amount) {
    this.x += amount;
  }

  public void draw(){
    pane.drawImage(image, x, y);
  }

  public String speak(ArrayList list){
    for (int i = 0; i < list.size(); i++) {
      if(list.get(i) == need ){
        return Bendankbericht;
      }
    }

    if (printCounter >= text.size()) printCounter = text.size() - 1;
    String tempString = text.get(printCounter);
    printCounter++;
    return tempString;
  }


  public String speak(boolean jaofnee){


      if (jaofnee) {
        return Antwoordja;
      } else {
        return Antwoordnee;
      }


  }




  public void setAntwoordja(String antwoordja) {
    Antwoordja = antwoordja;
  }

  public void setAntwoordnee(String antwoordnee) {
    Antwoordnee = antwoordnee;
  }

  public void addtoinventory(String voorwerp){
    inventory.add(voorwerp);
  }

  public String getneed(){
    return need;
  }

  public void addNeed(String need){
    this.need =  need;
  }

  public void addBericht(String zin){
    Bendankbericht = zin;
  }

}
