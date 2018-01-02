package Main.Game.TextPane;

import Main.Util.Constants;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

/**
 * Created by jaspe on 02/01/2018.
 * 
 */
public class TextPane extends Pane{

    public TextPane(){
        setMaxHeight(Constants.height / 3);
        setMaxHeight(Constants.height / 3);

        setMinWidth(Constants.width);
        setMaxWidth(Constants.width);
        TextArea area = new TextArea();
        area.setWrapText(true);
        area.setEditable(false);
        area.setPrefWidth(Constants.width);
        area.setText("JEMOEDERISEENGROTEHOERMETEENDIKKENEUSENZEKANNIETEENSHEELGOEDKOKENWANTZEISINEENVUILNESBELTOPGEGROEIT");
        getChildren().add(area);



            this.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                            switch (event.getCode()) {
                                    case UP:  System.out.println("jaa"); break;

                            }
                    }
            });

    }

}
