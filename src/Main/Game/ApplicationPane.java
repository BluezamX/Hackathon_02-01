package Main.Game;

import Main.Game.TextPane.TextPane;
import Main.Game.VisualPane.VisualPane;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import Main.Util.Constants;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
class ApplicationPane extends Pane {

  VisualPane visualPane;
  TextPane textPane;

  ApplicationPane(){
    Canvas canvas = new Canvas(Constants.width, (Constants.height * 6 / 8));
    this.visualPane = new VisualPane(canvas);
    this.textPane = new TextPane();
    BorderPane root = new BorderPane();
    root.setTop(canvas);
    root.setBottom(textPane);
    getChildren().add(root);

    this.setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case UP:  System.out.println("jaa"); break;

        case DOWN: System.out.println("ne"); break;

        default:
          Platform.exit();
      }
    });


  }
}
