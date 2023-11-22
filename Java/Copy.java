package Java;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Copy extends Application{
    Button b = new Button("复制");
    TextField L = new TextField();
    TextField R = new TextField();
    @Override
    public void start(Stage primaryStage){
        L.setPrefColumnCount(10);
        R.setPrefColumnCount(10);
        FlowPane fp = new FlowPane(5, 5);
        fp.getChildren().addAll(L, b, R);
        b.setOnAction(e -> R.setText(L.getText()));
        Scene scene = new Scene(fp);
        primaryStage.setTitle("动作事件");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
