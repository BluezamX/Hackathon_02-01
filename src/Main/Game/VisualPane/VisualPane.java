package Main.Game.VisualPane;

import Main.Util.Constants;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class VisualPane extends Pane {

  GraphicsContext context;
  Image image;

  public VisualPane(Canvas canvas){
    setMaxHeight(Constants.height * 2 / 3);
    setMaxHeight(Constants.height * 2 / 3);
    setMinWidth(Constants.width);
    setMaxWidth(Constants.width);
    context = canvas.getGraphicsContext2D();
    System.out.println("kek");
    context.drawImage(new Image(getClass().getResourceAsStream("test.png")), 0, 0);
  }
}
