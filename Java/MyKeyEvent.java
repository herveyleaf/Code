package Java;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class MyKeyEvent extends Application{
    @Override
    public void start(Stage myStage){
        StackPane sPane = new StackPane();
        TextField tf = new TextField();
        tf.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke)
            {tf.setText("按下键：" + ke.getText());}
        });
        tf.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke)
            {tf.setText("释放键：" + ke.getText());}
        });
        sPane.getChildren().add(tf);
        Scene scene = new Scene(sPane, 180, 60);
        myStage.setTitle("键盘事件");
        myStage.setScene(scene);
        myStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
