package Java;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;

public class MyWindow extends Application{
    @Override
    public void start(Stage primaryStage){
        BorderPane rootPane = new BorderPane();
        rootPane.setPadding(new Insets(8, 8, 8, 8));
        Image imb = new Image("file:D:\\Code\\Java\\国旗.jpg");
        ImageView iv = new ImageView(imb);
        iv.setFitWidth(80);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        Pane pane = new Pane();
        pane.getChildren().add(iv);
        Button bt = new Button("北部区域");
        rootPane.setTop(bt);
        rootPane.setBottom(new Button("南部区域"));
        rootPane.setLeft(new Button("西部区域"));
        rootPane.setRight((new Button("显示信息")));
        rootPane.setCenter(pane);
        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("界面布局");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

