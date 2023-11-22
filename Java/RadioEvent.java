package Java;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Toggle;

public class RadioEvent extends Application{
    Label resp = new Label("");
    @Override
    public void start(Stage myStage){
        FlowPane fp = new FlowPane(10, 10);
        fp.setAlignment(Pos.CENTER);
        RadioButton rbJ = new RadioButton("Java");
        RadioButton rbP = new RadioButton("Python");
        RadioButton rbC = new RadioButton("C++");
        ToggleGroup tg = new ToggleGroup();
        rbJ.setToggleGroup(tg);
        rbP.setToggleGroup(tg);
        rbC.setToggleGroup(tg);
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> changes, Toggle oldVal, Toggle newVal){
                RadioButton rb = (RadioButton)newVal;
                resp.setText("你选择的是：" + rb.getText());
            }            
        });
        rbJ.setSelected(true);
        fp.getChildren().addAll(rbJ, rbP, rbC, resp);
        Scene myScene = new Scene(fp, 250, 120);
        myStage.setTitle("单选按钮属性绑定事件");
        myStage.setScene(myScene);
        myStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
