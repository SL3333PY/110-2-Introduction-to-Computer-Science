package suprise.shi_bibi_dream_factory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import static suprise.shi_bibi_dream_factory.HelloApplication.*;

public class EventPageController {
    @FXML
    Button eventButton;
    @FXML
    Button clothButton;
    @FXML
    Button rightButton;
    @FXML
    Button leftButton;
    @FXML
    Button backButton;
    @FXML
    ImageView csLowLocked;
    @FXML
    Label csLowLabel;
    @FXML
    ImageView csMidLocked;
    @FXML
    Label csMidLabel;
    @FXML
    ImageView csHighLocked;
    @FXML
    Label csHighLabel;
    @FXML
    ImageView politicLowLocked;
    @FXML
    Label polLowLabel;
    @FXML
    ImageView politicMidLocked;
    @FXML
    Label polMidLabel;
    @FXML
    ImageView politicHighLocked;
    @FXML
    Label polHighLabel;
    @FXML
    ImageView actLowLocked;
    @FXML
    Label actLowLabel;
    @FXML
    ImageView actMidLocked;
    @FXML
    Label actMidLabel;
    @FXML
    ImageView actHighLocked;
    @FXML
    Label actHighLabel;



    @FXML
    public void onEventPressed(){}
    @FXML
    public void onClothPressed(){
        curStage.setScene(clothScene[clothPage]);
    }
    @FXML
    public void onLeftPressed(){
        try {
            Status();
        } catch (Exception e) {}
        if (eventPage >0){
            eventPage--;
        }
        else{
            eventPage = 8;
        }

        curStage.setScene(eventPageScene[eventPage]);
    }
    @FXML
    public void onRightPressed(){
        try {
            Status();
        } catch (Exception e) {}
        if (eventPage <8){
            eventPage++;
        }
        else{
            eventPage = 0;
        }
        curStage.setScene(eventPageScene[eventPage]);
    }
    @FXML
    public void onBackPressed(){
        curStage.setScene(menuScene);
        curStage.setTitle("施北北夢工廠");
    }
    public void Status(){
        if (csStatus[0] == 1){
            csLowLocked.setVisible(false);
            csLowLabel.setVisible(true);
        }
        if (csStatus[1] == 1){
            csMidLocked.setVisible(false);
            csMidLabel.setVisible(true);
        }
        if (csStatus[2] == 1){
            csHighLocked.setVisible(false);
            csHighLabel.setVisible(true);
        }
        if (polStatus[0] == 1){
            politicLowLocked.setVisible(false);
            polLowLabel.setVisible(true);
        }
        if (polStatus[1] == 1){
            politicMidLocked.setVisible(false);
            polMidLabel.setVisible(true);
        }
        if (polStatus[2] == 1){
            politicHighLocked.setVisible(false);
            polHighLabel.setVisible(true);
        }
        if (actStatus[0] == 1){
            actLowLocked.setVisible(false);
            actLowLabel.setVisible(true);
        }
        if (actStatus[1] == 1){
            actMidLocked.setVisible(false);
            actMidLabel.setVisible(true);
        }
        if (actStatus[2] == 1){
            actHighLocked.setVisible(false);
            actHighLabel.setVisible(true);
        }

    }


}
