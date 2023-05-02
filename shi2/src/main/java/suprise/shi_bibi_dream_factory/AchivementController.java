package suprise.shi_bibi_dream_factory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static suprise.shi_bibi_dream_factory.HelloApplication.*;

public class AchivementController {
    @FXML
    private Button eventButton;
    @FXML
    private Button clothButton;
    @FXML
    private Button backButton;

    @FXML
    public void onEventPressed(){
        curStage.setTitle("施北北邂逅相簿：事件紀錄簿");
        curStage.setScene(eventPageScene[eventPage]);
    }
    @FXML
    public void onClothPressed(){
        curStage.setTitle("施北北邂逅相簿：北北的衣櫃");
        curStage.setScene(clothScene[clothPage]);
    }
    @FXML
    public void onBackPressed(){
        curStage.setScene(menuScene);
        curStage.setTitle("施北北夢工廠");
    }

}
