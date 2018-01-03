package Main.Game;

import javafx.scene.Scene;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class ApplicationScene extends Scene{

  public ApplicationScene(){
    super(new ApplicationPane());
    getRoot().requestFocus();
  }
}
