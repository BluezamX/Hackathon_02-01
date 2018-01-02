package Main.Game.VisualPane;

import Main.Util.Constants;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

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
    drawBackground("testbackground1.png");
    //drawImage("test.png", 512, 256);
  }

  public void drawPath(String path, int x, int y){
    Image image = new Image((getClass().getResourceAsStream(path)));
    context.drawImage(new Image((getClass().getResourceAsStream(path))), x * Constants.widthScale, y * Constants.heightScale, image.getWidth() * Constants.widthScale, image.getHeight() * Constants.heightScale);
  }

  public void drawImage(Image image, int x, int y){
        context.drawImage(image , x * Constants.widthScale, y * Constants.heightScale, image.getWidth() * Constants.widthScale, image.getHeight() * Constants.heightScale);
  }

    public void drawFlip(String path, int x, int y){
    Image image = new Image((getClass().getResourceAsStream(path)));
    context.drawImage(new Image((getClass().getResourceAsStream(path))), x * Constants.widthScale + image.getWidth(), y * Constants.heightScale, -image.getWidth() * Constants.widthScale, image.getHeight() * Constants.heightScale);
  }

  public void drawBackground(String path){
    Image image = new Image((getClass().getResourceAsStream(path)));
    context.drawImage(image, 0, 0, image.getWidth() * Constants.widthScale, image.getHeight() * Constants.heightScale);
  }
}
