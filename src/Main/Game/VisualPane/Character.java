package Main.Game.VisualPane;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class Character {

  private String path;
  private VisualPane pane;
  public int x;
  public int y;

  public Character(String path, VisualPane pane){
    this.path = path;
    this.pane = pane;
    this.x = 0;
    this.y = 512;
  }

  public Character(String path, VisualPane pane, int x){
    this.path = path;
    this.pane = pane;
    this.x = x;
    this.y = 512;
  }

  public String getPath() {
    return path;
  }

  public void addX(int amount) {
    this.x += amount;
  }

  public void draw(){
    pane.drawImage(path, x, y);
  }
}
