package Main.Util;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * Created by jaspe on 02/01/2018.
 *
 */
public class Constants {
  static final Rectangle2D resolution = Screen.getPrimary().getVisualBounds();
  public static final int width = (int)resolution.getWidth();
  public static final int height = (int)resolution.getHeight();
  public static final float widthScale = (float) width / 1920;
  public static final float heightScale = (float) height / 1080;
}
