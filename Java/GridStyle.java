package Java;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

public class GridStyle extends Application{
    Label lab1 = new Label("姓名：");
    Label lab2 = new Label("职业：");
    Label lab3 = new Label("性别：");
    Font fon = new Font("Times New Roman", 20);
    @Override
    public void start(Stage primaryStage){
        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(10, 8, 10, 8));
        gPane.setHgap(5);
        gPane.setVgap(5);
        lab1.setTextFill(Color.RED);
        lab1.setFont(fon);
        lab2.setFont(new Font("黑体", 20));
        lab2.setStyle("-fx-border-color:blue");
        gPane.add(lab1, 0, 0);
        gPane.add(new TextField(), 1, 0);
        gPane.add(lab2, 0, 1);
        gPane.add(new TextField(), 1, 1);
        gPane.add(lab3, 0, 2);
        gPane.add(new TextField(), 1, 2);
        Button but = new Button("确认");
        gPane.add(but, 1, 3);
        Scene scene = new Scene(gPane);
        primaryStage.setTitle("网格与文本组件");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
