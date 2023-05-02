package suprise.shi_bibi_dream_factory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import static suprise.shi_bibi_dream_factory.HelloApplication.*;

public class ClothPageController {
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
    ImageView Locked1;
    @FXML
    Label Title1;
    @FXML
    Label txt1;
    @FXML
    ImageView Locked2;
    @FXML
    Label Title2;
    @FXML
    Label txt2;
    @FXML
    ImageView Locked3;
    @FXML
    Label Title3;
    @FXML
    Label txt3;
    @FXML
    ImageView Locked4;
    @FXML
    Label Title4;
    @FXML
    Label txt4;
    @FXML
    ImageView Locked5;
    @FXML
    Label Title5;
    @FXML
    Label txt5;




    @FXML
    public void onEventPressed(){curStage.setScene(eventPageScene[eventPage]);}
    @FXML
    public void onClothPressed(){}
    @FXML
    public void onLeftPressed(){
        try {
            Status();
        } catch (Exception e) {}
        if (clothPage >0){
            clothPage--;
        }
        else{
            clothPage = 4;
        }
        curStage.setScene(clothScene[clothPage]);
    }
    @FXML
    public void onRightPressed(){
        try {
            Status();
        } catch (Exception e) {}
        if (clothPage <4){
            clothPage++;
        }
        else{
            clothPage = 0;
        }
        curStage.setScene(clothScene[clothPage]);
    }
    @FXML
    public void onBackPressed(){
        curStage.setScene(menuScene);
        curStage.setTitle("施北北夢工廠");
    }
    public void Status(){
        if (clothStatus[0]==1){
            Locked1.setVisible(false);
//            Title1.setVisible(true);
            txt1.setVisible(true);
        }
        if (clothStatus[1]==1){
            Locked2.setVisible(false);
//            Title2.setVisible(true);
            txt2.setVisible(true);
        }
        if (clothStatus[2]==1){
            Locked3.setVisible(false);
//            Title3.setVisible(true);
            txt3.setVisible(true);
        }
        if (clothStatus[3]==1){
            Locked4.setVisible(false);
//            Title4.setVisible(true);
            txt4.setVisible(true);
        }
        if (clothStatus[4]==1){
            Locked5.setVisible(false);
//            Title5.setVisible(true);
            txt5.setVisible(true);
        }

    }



}
