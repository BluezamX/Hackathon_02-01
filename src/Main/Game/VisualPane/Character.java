package Main.Game.VisualPane;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class Character {

  private String path;
  public int x;
  public int y;

  Character(String path){
    this.path = path;
    this.x = 0;
    this.y = 512;
  }

  Character(String path, int x, int y){
    this.path = path;
    this.x = x;
    this.y = y;
  }

  public String getPath() {
    return path;
  }
}
