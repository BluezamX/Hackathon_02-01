package Main.Game.VisualPane;

import Main.Util.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class UpdateHandler {
  GraphicsContext context;

  UpdateHandler(GraphicsContext context){
    this.context = context;

    //drawBackground
    draw(new Image(getClass().getResourceAsStream("testbackground.png")), 0, 0);
    draw(new Image(getClass().getResourceAsStream("test.png")), 512, 256);
  }

  public void draw(Image image, int x, int y){
    System.out.println(Constants.widthScale);
    System.out.println(Constants.heightScale);
    context.drawImage(image, (int) x / Constants.widthScale, (int) y / Constants.heightScale);
  }
}