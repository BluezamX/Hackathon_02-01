package Main;

import Main.Game.ApplicationScene;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by jaspe on 02/01/2018.
 *
 */

public class ApplicationRoot extends Application {

  public static Rectangle2D resolution;
  private Scene scene;

  @Override
  public void start(Stage stage) throws Exception {
    resolution = Screen.getPrimary().getVisualBounds();
    configure(stage);
  }

  private void configure(Stage stage){
    stage.setFullScreen(true);
    stage.setResizable(true);

    scene = new ApplicationScene();

    stage.setTitle("No Reception");
    stage.setFullScreenExitHint("");
    stage.setScene(scene);

    stage.show();
  }
}
