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

  private GraphicsContext context;
  private UpdateHandler updateHandler;

  public VisualPane(Canvas canvas){
    context = canvas.getGraphicsContext2D();
    //context.drawImage(new Image(getClass().getResourceAsStream("testbackground.png")), 0, 0);
    //context.drawImage(new Image(getClass().getResourceAsStream("test.png")), 0, 0);
    updateHandler = new UpdateHandler(context);
  }

  public void setBackground(String path){
    updateHandler.draw(new Image((getClass().getResourceAsStream("test.png"))), 0, 0);
  }
}
