package Java;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

public class MyMouseEvent extends Application{
    @Override
    public void start(Stage myStage) {
        BorderPane bPane = new BorderPane();
        TextField tf = new TextField();
        Circle c = new Circle(50, Color.RED);
        c.setOnMouseEntered(me -> tf.setText("鼠标进入圆内"));
        c.setOnMouseExited(me -> tf.setText("鼠标离开圆内"));
        c.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me)
            {tf.setText("鼠标被按住");}
        });
        bPane.setCenter(c);
        bPane.setBottom(tf);
        Scene scene = new Scene(bPane, 200, 150);
        myStage.setTitle("鼠标事件");
        myStage.setScene(scene);
        myStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
