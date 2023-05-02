package suprise.shi_bibi_dream_factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.paint.Color.RED;

public class HelloApplication extends Application {
    public static Stage curStage;
    public static Stage instructionStage;
    public static Scene menuScene;
    public static Scene instructionScene;

    public static Scene achievementScene;
    public static Scene[] eventPageScene = new Scene[9];
    public static Scene[] clothScene = new Scene[5];

    public static int eventPage = 0;
    public static int[] csStatus = {0,0,0};
    public static int[] polStatus = {0,0,0};
    public static int[] actStatus = {0,0,0};

    public static int clothPage = 0;
    public static int[] clothStatus = {0,0,0,0,0};
    public Double width = 320.0;
    public Double left = 200.0;
    public String wear;
    public int smartLevel;
    public int major;
    public int visit[][]=new int[10][10];
    public int bomb[][]=new int[10][10];
    public int t=0,bombs=10;
    public TreeSet<Integer> s = new TreeSet<Integer>();
    public Button button[][]=new Button[10][10];
    public int a,b,time=0;

    public Button home = new Button("回主畫面");
    public Button exit = new Button("結束遊戲");

    private int scneneIdx;
    // 注册场景，返回场景的列表
    public List<MiniScene1> registerScene(){
        List<MiniScene1> sceneList = new ArrayList<>();
        switch (smartLevel) {
            case 3:

                MiniScene1 politician_high1 = new MiniScene1(
                        "https://i.imgur.com/3LqKKJd.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "施伯伯成功當選總統，施行油電雙漲政策。")
                );
                sceneList.add(politician_high1);

                MiniScene1 politician_high2 = new MiniScene1(
                        "https://i.imgur.com/3LqKKJd.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "你去凱道上面抗議，與施伯伯走向相愛相殺的道路。")
                );
                sceneList.add(politician_high2);

                break;

            case 2:

                MiniScene1 politician_normal1 = new MiniScene1(
                        "https://i.imgur.com/GLPJuMI.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "施伯伯選上了市長，帶領大家發大財。")
                );
                sceneList.add(politician_normal1);

                MiniScene1 politician_normal2 = new MiniScene1(
                        "https://i.imgur.com/GLPJuMI.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "你是他的忠實粉絲，在記者會上認識了他。")
                );
                sceneList.add(politician_normal2);

                MiniScene1 politician_normal3 = new MiniScene1(
                        "https://i.imgur.com/GLPJuMI.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "施伯伯與你日久生情，你們從此幸福快樂地生活在一起。")
                );
                sceneList.add(politician_normal3);

                break;

            case 1:

                MiniScene1 politician_low1 = new MiniScene1(
                        "https://i.imgur.com/t9F6ljZ.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "施伯伯成為了立委，但除了動用暴力什麼都不會。")
                );
                sceneList.add(politician_low1);

                MiniScene1 politician_low2 = new MiniScene1(
                        "https://i.imgur.com/t9F6ljZ.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "一個不小心就被打進醫院，遇見了剛好去看病的你。")
                );
                sceneList.add(politician_low2);

                MiniScene1 politician_low3 = new MiniScene1(
                        "https://i.imgur.com/t9F6ljZ.jpg",
                        new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                                "旁白", "施伯伯對你一見鐘情，你們從此幸福快樂地生活在一起。")
                );
                sceneList.add(politician_low3);

                break;
        }
        return sceneList;
    }

    public List<MiniScene> registerScene1(){
        List<MiniScene> sceneList = new ArrayList<>();
        MiniScene kid1 = new MiniScene(
                "https://i.imgur.com/APmTpFo.jpg",
                "https://i.imgur.com/ZfZTUJs.png",
                new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                        "旁白", "施伯伯漸漸長大，進入了學校就讀。")
        );
        sceneList.add(kid1);

        MiniScene kid2 = new MiniScene(
                "https://i.imgur.com/APmTpFo.jpg",
                "https://i.imgur.com/ZfZTUJs.png",
                new TextAnimEntity("https://i.imgur.com/A2kiJNQ.png",
                        "旁白", "學校安排了一場智力測驗，\n" +
                        "請幫施伯伯完成他的智力測驗吧！")
        );
        sceneList.add(kid2);

        return sceneList;
    }

    @FXML
    public void onExitPressed(){
        instructionStage.close();
    }
    @FXML
    public void onInstructionPressed() throws IOException {
        instructionStage.show();
    }
    @FXML
    public void onstartPressed() {
        this.baby(curStage);
    }
    @FXML
    public void onExitPressd(){
        curStage.close();
    }
    @FXML
    public void onCardPressed(){
        curStage.setScene(achievementScene);
        curStage.setTitle("施北北夢工廠：邂逅相簿");
        curStage.setScene(achievementScene);
        curStage.setResizable(false);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Image icon = new Image("https://i.imgur.com/MqmB2Wk.png");
        FXMLLoader fxmlLoaderMenu = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        menuScene = new Scene(fxmlLoaderMenu.load());
        curStage =  stage;
        curStage.setTitle("施北北夢工廠");
        curStage.getIcons().add(icon);
        curStage.setScene(menuScene);
        curStage.setResizable(false);
        curStage.show();

        FXMLLoader fxmlLoaderInstruction = new FXMLLoader(HelloApplication.class.getResource("instruction.fxml"));
        instructionStage = new Stage();
        instructionScene = new Scene(fxmlLoaderInstruction.load());
        instructionStage.setScene(instructionScene);
        instructionStage.setTitle("施北北夢工廠：遊戲說明");
        instructionStage.getIcons().add(icon);
        instructionStage.setResizable(false);

        FXMLLoader fxmlLoaderAchievent = new FXMLLoader(HelloApplication.class.getResource("achievement.fxml"));
        achievementScene = new Scene(fxmlLoaderAchievent.load());

        for (int i = 1; i <= 9; i++) {
            String str = "achievementEvent"+i+".fxml";
            FXMLLoader fxmlLoaderEventPage = new FXMLLoader(HelloApplication.class.getResource(str));
            eventPageScene[i-1] = new Scene(fxmlLoaderEventPage.load());
        }
        for (int i = 1; i <= 5; i++) {
            String str = "cloth"+i+".fxml";
            FXMLLoader fxmlLoaderClothPage = new FXMLLoader(HelloApplication.class.getResource(str));
            clothScene[i-1] = new Scene(fxmlLoaderClothPage.load());
        }
    }

    public  void menu(Stage stage){
        width = 320.0;
        left = 200.0;
        t=0;
        bombs=10;
        time = 0;
        s.clear();
        stage.setScene(menuScene);
    }

    public void baby(Stage stage) {
        Pane pane = new Pane();
        Image image = new Image("https://imgur.com/PVzIYEP.jpg");
        Image baby = new Image("https://i.ibb.co/87jn4gg/2022-04-21-2-48-47-ccexpress.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(640.0D);
        imageView.setFitHeight(400.0D);
        ImageView babyView = new ImageView(baby);
        babyView.setFitHeight(200.0D);
        babyView.setFitWidth(320.0D);
        babyView.setX(200.0D);
        babyView.setY(120.0D);
        Button feed = new Button("餵食");
        feed.setFont(Font.font(24.0D));
        feed.setLayoutX(280.0D);
        feed.setLayoutY(320.0D);
        Button next = new Button("下一階段");
        next.setFont(Font.font(24.0D));
        next.setLayoutX(500.0D);
        next.setLayoutY(10.0D);
        feed.setOnAction((e) -> {
            this.left = this.left - 12.5D;
            this.width = this.width + 25.0D;
            babyView.setX(this.left);
            babyView.setFitWidth(this.width);
        });
        pane.getChildren().add(imageView);
        pane.getChildren().add(babyView);
        pane.getChildren().add(feed);
        pane.getChildren().add(next);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        next.setOnAction((e) -> {
            this.child(stage);
        });
    }

    public  void child(Stage stage){
        Canvas canvas = new Canvas(640,400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // 初始化绘画器
        SceneDrawer drawer = new SceneDrawer(canvas, gc);
        // 注册场景
        List<MiniScene> sceneList = registerScene1();
        // 场景指针
        scneneIdx = 0;

        new Thread(()->{
            // 开始游戏循环，只要场景没有循环完，就一直执行游戏循环
            while(scneneIdx < sceneList.size()){
                //System.out.println("一帧");
                drawer.draw(sceneList.get(scneneIdx));
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Pane pane = new Pane();
        Scene child = new Scene(pane, 640,400);
        pane.getChildren().add(canvas);
        stage.setScene(child);

        // 这里需要给场景添加一个控制器，相应鼠标点击事件
        child.setOnMouseClicked(e -> {
            // 如果文字没有播放完，就播放文字
            // 如果文字播放完了，就播放下一个场景
            if(!sceneList.get(scneneIdx).getTextentity().isFinish()){
                sceneList.get(scneneIdx).getTextentity().setFinish(true);
            } else {
                if(scneneIdx < sceneList.size() - 1) {
                    scneneIdx++;
                }
                else {
                    this.test(stage);
                    //轉換到HelloApplication的智力測驗內容
                }
            }
            //System.out.println("點擊事件");
        });
    }

    public void test(Stage stage){
        final Alert instruct = new Alert(Alert.AlertType.INFORMATION);
        instruct.setTitle("規則說明"); //設定對話框視窗的標題列文字
        instruct.setHeaderText("""
                1. 謎底是一個四位數字，第一位可以是0，數字可重複！可重複！可重複！
                2. 根據所猜數字，遊戲會給予相應提示，請根據提示猜出正確謎底。
                3. A表示數字及位置皆正確的數目，B表示數字正確但位置錯誤的數目。
                例：謎底為0157，所猜數字為9175，則遊戲提示1A2B。"""); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
        VBox root = new VBox();
        TextField input = new TextField();
        input.setFont(Font.font(24));
        input.setMaxWidth(240);
        Text title = new Text("智力測驗");
        title.setFont(Font.font(30));
        title.setLayoutX(280);
        title.setLayoutY(50);
        Button submit = new Button("提交");
        submit.setFont(Font.font(24));
        submit.setPrefSize(80, 75);
        Button massage = new Button("說明");
        massage.setFont(Font.font(20));
        massage.setLayoutY(10);
        massage.setLayoutX(450);
        Button give_up = new Button("放棄");
        give_up.setFont(Font.font(20));
        give_up.setLayoutX(550);
        give_up.setLayoutY(10);
        Button next = new Button("下一階段");
        next.setFont(Font.font(20));
        next.setLayoutY(50);
        next.setLayoutX(500);
        next.setDisable(true);
        Pane L1 = new Pane();
        L1.getChildren().add(title);
        L1.getChildren().add(massage);
        L1.getChildren().add(give_up);
        L1.getChildren().add(next);
        root.getChildren().add(L1);

        // 數字鍵盤
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Button[] num = new Button[10];
        for (int i = 0; i < 10; i++) {
            String tem;
            tem = number[i];
            num[i] = new Button(number[i]);
            num[i].setFont(Font.font(30));
            num[i].setPrefSize(80, 75);
            num[i].setOnAction(e -> input.setText(input.getText() + tem));
        }
        Button del = new Button("<-");
        del.setPrefSize(80, 75);
        del.setFont(Font.font(30));
        del.setOnAction(e ->
                input.setText(input.getText().substring(0, input.getText().length() - 1))
        );

        GridPane idk = new GridPane();
        idk.add(input, 0, 0, 3, 1);
        idk.add(submit, 2, 4);
        for (int i = 1; i < 10; i++) {
            int a, b;
            a = Integer.parseInt(number[i]) % 3 - 1;
            b = (Integer.parseInt(number[i]) - 1) / 3 + 1;
            switch (a) {
                case 0 -> idk.add(num[i], 0, b);
                case 1 -> idk.add(num[i], 1, b);
                case -1 -> idk.add(num[i], 2, b);
            }
        }
        idk.add(del, 0, 4);
        idk.add(num[0], 1, 4);
        VBox guess = new VBox();
        idk.add(guess, 3, 0, 3, 5);
        idk.setLayoutX(20);
        idk.setLayoutY(150);
        root.getChildren().add(idk);


        int[] str = new int[4];
        int[] arr = new int[4];
        int[] ans = new int[4];

        int k;
        for(k=0;k<4;k++){
            arr[k] = (int)(Math.random()*10);
        }

        massage.setOnAction(e -> instruct.showAndWait());
        give_up.setOnAction((ActionEvent e)->{
            Text result = new Text("測驗結果 : 智商低");
            smartLevel=1;
            result.setFont(Font.font(20));
            result.setFill(RED);
            guess.getChildren().add(result);
            next.setDisable(false);
        });
        submit.setOnAction((ActionEvent e)->{
            int i,j;
            for(i=0;i<4;i++)
            {
                ans[i]=arr[i];
            }
            a=0;
            b=0;
            String s=input.getText(); //猜測內容
            input.setText("");
            if (s.length() == 4){
                time++;
                for(j=0;j<4;j++){
                    str[j]=(int)s.charAt(j)-48;
                }
                for(i=0;i<4;i++)
                {
                    if(ans[i]==str[i])
                    {
                        a+=1;
                        ans[i]=-1;
                        str[i]=10;
                    }
                }
                for(i=0;i<4;i++)
                {
                    for(j=0;j<4;j++)
                    {
                        if(ans[i]==str[j])
                        {
                            b+=1;
                            ans[i]=-1;
                            str[j]=10;
                            break;
                        }
                    }
                }
                Text t = new Text(Integer.toString(time)+". "+s+" : "+Integer.toString(a)+"A"+Integer.toString(b)+"B");
                t.setFont(Font.font(20));
                guess.getChildren().add(t);
            }
            else {
                final Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("注意"); //設定對話框視窗的標題列文字
                alert.setHeaderText("請輸入四位數字"); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
                alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
            }
            //System.out.println(str[0]);
            if(a==4){
                Text result = new Text("");
                result.setFont(Font.font(20));
                result.setFill(RED);
                if(time>10){
                    result.setText("測驗結果 : 智商中");
                    smartLevel=2;
                }
                else{
                    result.setText("測驗結果 : 智商高");
                    smartLevel=3;
                }
                guess.getChildren().add(result);
                next.setDisable(false);
            }
        });
        next.setOnAction(e->{
            this.teenager(stage);
        });

        Scene test = new Scene(root, 640, 400);
        stage.setScene(test);
        instruct.showAndWait();
    }

    public void teenager(Stage stage) {
        Pane pane = new Pane();
        Button next = new Button("下一階段");
        next.setFont(Font.font(24.0D));
        next.setLayoutX(500.0D);
        next.setLayoutY(10.0D);
        next.setDisable(true);
        Image image1 = new Image("https://hbimg.huabanimg.com/a55083d7ae8fcdaf3527b09a5ff342cef2e5b6063be5e-qgIVDx_fw236");//背景
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(400);
        imageView1.setFitWidth(640);

        Image image2 = new Image("https://i.ibb.co/LzKtB7z/8acef9efc81190f07d2d052a6a9b1bdf.png");//衣櫃
        ImageView imageView2 =  new ImageView(image2);
        imageView2.setFitHeight(380);
        imageView2.setFitWidth(350);

        Button btn1 = new Button();
        btn1.setGraphic(imageView2);
        btn1. setStyle("-fx-background-color: transparent; ");
        btn1.setLayoutX(140);

        Label label = new Label("快來幫你專屬的施伯伯搭配漂亮的小裙裙吧～");
        label.setLayoutX(180);
        label.setLayoutY(350);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(btn1);
                Image dress1 = new Image("https://i.ibb.co/23Cdf3J/501617a39a878f1d1635400104.png");
                ImageView dressView1 = new ImageView(dress1);
                dressView1.setFitWidth(100);
                dressView1.setFitHeight(200);
                Button btn2 = new Button();
                btn2.setGraphic(dressView1);
                btn2.setLayoutY(80);
                btn2. setStyle("-fx-background-color: transparent; ");
                Image dress2 = new Image("https://i.ibb.co/Xy4bBxQ/BC1803-A7-BDC1-4-A1-A-A0-AC-1900-C8-E350-FF.png");
                ImageView dressView2 = new ImageView(dress2);
                dressView2.setFitWidth(100);
                dressView2.setFitHeight(200);
                Button btn3 = new Button();
                btn3.setGraphic(dressView2);
                btn3.setStyle("-fx-background-color: transparent; ");
                btn3.setLayoutX(120);
                btn3.setLayoutY(80);



                Image dress3 = new Image("https://i.ibb.co/9ch0Qnz/3-B11097-E-3-A54-4104-95-C2-284112-F236-DC.png");
                ImageView dressView3 = new ImageView(dress3);
                dressView3.setFitHeight(200);
                dressView3.setFitWidth(100);
                Button btn4 = new Button();
                btn4.setGraphic(dressView3);
                btn4.setLayoutX(240);
                btn4.setLayoutY(80);

                btn4.setStyle("-fx-background-color: transparent; ");

                Image dress4 = new Image("https://i.ibb.co/8bbgHhF/95-C416-F0-CDAE-4-EEE-8-C2-D-43-CC55-B71-EA1.png" );
                ImageView dressView4 = new ImageView(dress4);
                dressView4.setFitHeight(200);
                dressView4.setFitWidth(100);
                Button btn5 = new Button();
                btn5.setGraphic(dressView4);
                btn5.setLayoutX(360);
                btn5.setLayoutY(80);
                btn5.setStyle("-fx-background-color: transparent; ");

                Image dress5 = new Image("https://i.ibb.co/bQ6NfKZ/2-EAAA224-E187-4-EB7-B16-D-CB52-EBF60-E81.png");
                ImageView dressView5 = new ImageView(dress5);
                dressView5.setFitHeight(200);
                dressView5.setFitWidth(100);
                Button btn6 = new Button();
                btn6.setGraphic(dressView5);
                btn6.setLayoutX(480);
                btn6.setLayoutY(80);
                btn6.setStyle("-fx-background-color: transparent; ");

                pane.getChildren().addAll(btn2,btn3,btn4,btn5,btn6);

                btn2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        pane.getChildren().removeAll(btn2,btn3,btn4,btn5,btn6);
                        wear="https://i.ibb.co/Vwj1SQZ/77-DF0127-3525-44-DD-8-D17-E23-E67-AAC7-FF.png";
                        Image wearDress1 = new Image(wear);
                        ImageView wearView1 = new ImageView(wearDress1);
                        wearView1.setFitWidth(width/3);
                        wearView1.setFitHeight(300);
                        wearView1.setLayoutX(250);
                        wearView1.setLayoutY(50);
                        pane.getChildren().addAll(wearView1);
                        label.setText("您選擇的是功夫寶貝施伯伯，真有眼光！");
                        next.setDisable(false);
                        clothStatus[0]=1;
                    }
                });
                btn3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        pane.getChildren().removeAll(btn2,btn3,btn4,btn5,btn6);
                        wear="https://i.ibb.co/VvKLb3r/0247-F418-F33-E-4-C71-98-DA-1599-BD20003-E.png" ;
                        Image wearDress2 = new Image(wear);
                        ImageView wearView2 = new ImageView(wearDress2);
                        wearView2.setFitWidth(width/3);
                        wearView2.setFitHeight(300);
                        wearView2.setLayoutX(250);
                        wearView2.setLayoutY(50);
                        pane.getChildren().add(wearView2);
                        label.setText("您選擇的是清冷仙子施伯伯，真有眼光！");
                        next.setDisable(false);
                        clothStatus[1]=1;
                    }
                });
                btn4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        pane.getChildren().removeAll(btn4,btn2,btn3,btn5,btn6);
                        wear="https://i.ibb.co/K9RRmHG/87270823-D0-AE-4-AF6-9-F97-6571-B51883-D8.png";
                        Image wearDress3 = new Image(wear);
                        ImageView wearView3 = new ImageView(wearDress3);
                        wearView3.setFitWidth(width/3);
                        wearView3.setFitHeight(300);
                        wearView3.setLayoutX(250);
                        wearView3.setLayoutY(50);
                        pane.getChildren().add(wearView3);
                        label.setText("您選擇的是可愛甜心施伯伯，真有眼光！");
                        next.setDisable(false);
                        clothStatus[2]=1;
                    }
                });

                btn5.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        pane.getChildren().removeAll(btn4,btn2,btn3,btn5,btn6);
                        wear="https://i.ibb.co/7gwPmgp/AEDC1-DA8-6-C94-462-E-B333-EDE207-EFD681.png" ;
                        Image wearDress4 = new Image(wear);
                        ImageView wearView4 = new ImageView(wearDress4);
                        wearView4.setFitWidth(width/3);
                        wearView4.setFitHeight(300);
                        wearView4.setLayoutX(250);
                        wearView4.setLayoutY(50);
                        pane.getChildren().add(wearView4);
                        label.setText("您選擇的是高雅太后施伯伯，真有眼光！");
                        next.setDisable(false);
                        clothStatus[3]=1;
                    }
                });
                btn6.setOnAction((e) ->{
                        pane.getChildren().removeAll(btn4,btn2,btn3,btn5,btn6);
                        wear="https://i.ibb.co/XtwmYfw/FFF662-EE-FDE6-422-A-A64-F-64-B2301-C5-C58.png";
                        Image wearDress5 = new Image(wear);
                        ImageView wearView5 = new ImageView(wearDress5);
                        wearView5.setFitWidth(width/3);
                        wearView5.setFitHeight(300);
                        wearView5.setLayoutX(250);
                        wearView5.setLayoutY(50);
                        pane.getChildren().add(wearView5);
                        label.setText("您選擇的是甜辣女僕施伯伯，真有眼光！");
                        next.setDisable(false);
                        clothStatus[4]=1;
                });

            }
        });
        next.setOnAction((e) -> {
            this.soldier(stage);
        });
        pane.getChildren().addAll(imageView1,btn1,label,next);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    public void soldier(Stage stage) {
        Pane pane = new Pane();
        Image image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRkQ-2KHgD4t1ShJVoshc21cAeQMZ-i8YwRQ&usqp=CAU");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(640.0D);
        imageView.setFitHeight(400.0D);
        Pane landmine = new Pane();
        while(true){
            int r = (int)(Math.random()*100);
            if(!s.contains(r))s.add(r);
            if(s.size()==10)break;
        }
        int a,b,i,j;
        for(i=0;i<10;i++){
            for(j=0;j<10;j++){
                bomb[i][j]=0;
                visit[i][j]=0;
            }
        }
        for(int e:s){
            a=e/10;
            b=e%10;
            bomb[a][b]=10;
            if(a-1>=0 && b-1>=0)bomb[a-1][b-1]+=1;
            if(a-1>=0)bomb[a-1][b]+=1;
            if(a-1>=0 && b+1<10)bomb[a-1][b+1]+=1;
            if(b-1>=0)bomb[a][b-1]+=1;
            if(b+1<10)bomb[a][b+1]+=1;
            if(a+1<10 && b-1>=0)bomb[a+1][b-1]+=1;
            if(a+1<10)bomb[a+1][b]+=1;
            if(a+1<10 && b+1<10)bomb[a+1][b+1]+=1;
        }
        VBox root = new VBox();
        HBox hbox[]=new HBox[10];
        HBox hbox_text = new HBox();
        Text text = new Text("剩餘炸彈 : ");
        Text bo = new Text(Integer.toString(10));
        Button hospital_btn = new Button("前往醫院");
        Button university_btn = new Button("前往大學");
        hospital_btn.setFont(Font.font(24.0D));
        hospital_btn.setLayoutX(500.0D);
        hospital_btn.setLayoutY(10.0D);
        university_btn.setFont(Font.font(24.0D));
        university_btn.setLayoutX(500.0D);
        university_btn.setLayoutY(10.0D);
        hbox_text.getChildren().addAll(text,bo);
        text.setFont(Font.font(24));
        bo.setFont(Font.font(24));
        root.getChildren().add(hbox_text);
        for(i=0;i<10;i++){
            hbox[i]=new HBox();
            for(j=0;j<10;j++){
                button[i][j]=new Button("");
                button[i][j].setMinWidth(30);
                button[i][j].setFont(Font.font(15));
                hbox[i].getChildren().add(button[i][j]);
            }
            root.getChildren().add(hbox[i]);
        }

        for(i=0;i<10;i++){
            for(j=0;j<10;j++){
                final int p=i,q=j;
                button[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        int m,n;
                        if(event.getButton().name().equals(MouseButton.PRIMARY.name())){
                            if(visit[p][q]==2){
                                text.setText("請解除flag");
                                bo.setText("");
                            }
                            else if(bomb[p][q]>=10){
                                //System.out.println("bomb");
                                text.setText("");
                                bo.setText("BOOM!!!");
                                pane.getChildren().add(hospital_btn);
                                for(m=0;m<10;m++){
                                    for(n=0;n<10;n++){
                                        button[m][n].setDisable(true);
                                    }
                                }
                            }
                            else{
                                f(p,q);
                                text.setText("剩餘炸彈 : ");
                                bo.setText(Integer.toString(bombs));
                            }
                            if(t==90){
                                //System.out.println("you win");
                                text.setText("");
                                bo.setText("You Win!!!");
                                pane.getChildren().add(university_btn);
                                for(m=0;m<10;m++){
                                    for(n=0;n<10;n++){
                                        button[m][n].setDisable(true);
                                    }
                                }
                            }
                        }
                        else if(event.getButton().name().equals(MouseButton.SECONDARY.name())){
                            if(visit[p][q]==0){
                                button[p][q].setText("f");
                                visit[p][q]=2;
                                bombs-=1;
                            }
                            else if(visit[p][q]==2) {
                                button[p][q].setText("");
                                visit[p][q] = 0;
                                bombs += 1;
                            }
                            text.setText("剩餘炸彈 : ");
                            bo.setText(Integer.toString(bombs));
                        }
                    }
                });
            }
        }
        hospital_btn.setOnAction((e) -> {
            this.hospital(stage);
        });
        university_btn.setOnAction((e) -> {
            this.university1(stage);
        });

        landmine.getChildren().add(root);
        landmine.setLayoutX(300);

        Image image1 = new Image("https://imgur.com/FbAmSEq.png");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(width*2/3);
        imageView1.setFitHeight(380);

        pane.getChildren().addAll(imageView,imageView1,landmine);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    public void f(int a,int b){
        if(visit[a][b]==1)return;
        visit[a][b]=1;
        if(bomb[a][b]!=0)button[a][b].setText((Integer.toString(bomb[a][b])));
        button[a][b].setDisable(true);
        button[a][b].setMinWidth(30);
        t++;
        if(bomb[a][b]>0)return;
        else{
            if(a-1>=0 && b-1>=0)f(a-1,b-1);
            if(a-1>=0)f(a-1,b);
            if(a-1>=0 && b+1<10)f(a-1,b+1);
            if(a+1<10 && b-1>=0)f(a+1,b-1);
            if(a+1<10)f(a+1,b);
            if(a+1<10 && b+1<10)f(a+1,b+1);
            if(b-1>=0)f(a,b-1);
            if(b+1<10)f(a,b+1);
        }
    }

    public void hospital(Stage stage){
        Pane pane = new Pane();
        Button act = new Button("請求交往");
        Button not_act = new Button("壓抑感情");
        Image image = new Image("https://ibw.bwnet.com.tw/ac_gallery/2020/08/863cd9df-041d-5bed-a85d-f435a0008829_620.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(640.0D);
        imageView.setFitHeight(400.0D);
        Image bi_bi = new Image(wear);
        ImageView bi_biView = new ImageView(bi_bi);
        bi_biView.setFitWidth(width*4/9);
        bi_biView.setFitHeight(380);
        Image love = new Image("https://memeprod.sgp1.digitaloceanspaces.com/user-resource/0a6f7f07b6534b5644213d8687c6bfed.png");
        ImageView loveView = new ImageView(love);
        loveView.setFitWidth(300);
        loveView.setFitHeight(150);
        loveView.setX(150);
        loveView.setY(50);
        Image nurse = new Image("https://i.ibb.co/FWtVZSb/C0506-EDF-F59-B-42-EC-B3-D0-62946649-BB68.png");
        ImageView nurseView = new ImageView(nurse);
        nurseView.setFitWidth(190);
        nurseView.setFitHeight(350);
        nurseView.setX(450);
        nurseView.setY(50);
        act.setFont(Font.font(24.0D));
        not_act.setFont(Font.font(24.0D));
        act.setLayoutX(150);
        act.setLayoutY(320);
        not_act.setLayoutX(350);
        not_act.setLayoutY(320);
        Label label = new Label("你對醫治你的護士產生好感，你會...");
        label.setStyle("-fx-background-color: white; ");
        label.setLayoutX(320);
        label.setLayoutY(20);
        pane.getChildren().addAll(imageView,bi_biView,loveView,nurseView,act,not_act,label);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        act.setOnAction((e) -> {
            this.marriage(stage);
        });
        not_act.setOnAction((e) -> {
            this.university1(stage);
        });
    }

    public void university1(Stage stage){
        Pane pane = new Pane();
        Label label = new Label("選擇就讀科系");
        label.setStyle("-fx-background-color: white; ");
        label.setLayoutX(280);
        label.setLayoutY(20);
        Image image = new Image("https://8.share.photo.xuite.net/james.woug/18f0ce8/16576006/892519650_m.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(640);
        Button superstar = new Button("表演系");
        Button csie = new Button("資工系");
        Button politic = new Button("政治系");
        superstar.setFont(Font.font(24.0D));
        csie.setFont(Font.font(24.0D));
        politic.setFont(Font.font(24.0D));
        superstar.setLayoutY(320);
        csie.setLayoutY(320);
        politic.setLayoutY(320);
        superstar.setLayoutX(100);
        csie.setLayoutX(250);
        politic.setLayoutX(400);
        pane.getChildren().addAll(imageView,superstar,csie,politic,label);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        superstar.setOnAction((e) -> {
            major=1;
            this.university2(stage);
        });
        csie.setOnAction((e) -> {
            major=2;
            this.university2(stage);
        });
        politic.setOnAction((e) -> {
            major=3;
            this.university2(stage);
        });
    }

    public void university2(Stage stage){
        Pane pane = new Pane();
        Label label = new Label("你想怎麼過大學生活");
        label.setStyle("-fx-background-color: white; ");
        label.setLayoutX(270);
        label.setLayoutY(20);
        Image image = new Image("https://cw1.tw/CW/images/blog/C1449459597812.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(640);
        Button work_hard = new Button("認真學習");
        Button play = new Button("放飛玩樂");
        Button ocean = new Button("成為海王");
        work_hard.setFont(Font.font(24.0D));
        play.setFont(Font.font(24.0D));
        ocean.setFont(Font.font(24.0D));
        work_hard.setLayoutY(320);
        play.setLayoutY(320);
        ocean.setLayoutY(320);
        work_hard.setLayoutX(100);
        play.setLayoutX(250);
        ocean.setLayoutX(400);
        pane.getChildren().addAll(imageView,work_hard,play,ocean,label);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        work_hard.setOnAction((e) -> {
            if(smartLevel<3)smartLevel+=1;
            if(major==1) this.superstar(stage);
            else if(major==2) this.computer(stage);
            else this.politics(stage);

        });
        play.setOnAction((e) -> {
            if(major==1) this.superstar(stage);
            else if(major==2) this.computer(stage);
            else this.politics(stage);
        });
        ocean.setOnAction((e) -> {
            this.ocean(stage);
        });
    }

    public void ocean(Stage stage){
        home.setVisible(false);
        exit.setVisible(false);
        Pane pane = new Pane();
        Image school = new Image("https://pic.pimg.tw/weng3309/1514981607-2266749041.jpg");
        ImageView schoolview = new ImageView(school);
        schoolview.setFitWidth(640);
        schoolview.setFitHeight(400);
        Label label1 = new Label("終於進入大學了，\n你的施伯伯單身十八年，\n是否要為他尋找一段美好姻緣？");
        label1.setLayoutX(200);
        label1.setLayoutY(40);
        Button btn1 = new Button("尋找良人");
        Button btn2 = new Button("忍痛拒絕");
        btn1.setLayoutY(300);
        btn1.setLayoutX(200);
        btn2.setLayoutY(300);
        btn2.setLayoutX(350);
        pane.getChildren().addAll(schoolview,label1,btn1,btn2);
        stage.setScene(new Scene(pane, 640, 400));

        btn2.setOnAction(e->{
            this.university2(stage);
        });

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Pane pane2 = new Pane();
                Image classroom = new Image("https://f.3dxy.com/sub/Manual/pic/2019/0710/08/1907090904_137021907100824_25564_750x680_2.png");
                ImageView classview = new ImageView(classroom);
                classview.setFitWidth(640);
                classview.setFitHeight(400);
                Button su = new Button();
                Image su_image = new Image("https://staff.csie.ncu.edu.tw/pochyisu/pic/pochyisu.jpg");
                ImageView su_view = new ImageView(su_image);
                su.setGraphic(su_view);
                su_view.setFitHeight(200);
                su_view.setFitWidth(150);

                su.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Pane pane3 = new Pane();
                        Image back = new Image("https://wimg.588ku.com/gif/20/04/16/06088a0f0a4dfe593159b568a4d5dfe1.gif");
                        ImageView backview = new ImageView(back);
                        backview.setFitWidth(640);
                        backview.setFitHeight(400);

                        Image people = new Image("https://i.ibb.co/hdHjZSc/088-B80-DE-C918-489-C-AD99-29-CB49-DD91-B1.png");
                        ImageView peopleview = new ImageView(people);
                        peopleview.setFitWidth(150);
                        peopleview.setFitHeight(400);
                        peopleview.setLayoutY(50);
                        peopleview.setLayoutX(220);

                        Button flower = new Button("鮮花送禮");
                        Button talk = new Button("花言巧語");
                        flower.setLayoutY(300);
                        flower.setLayoutX(200);
                        talk.setLayoutY(300);
                        talk.setLayoutX(350);

                        flower.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                flower.setVisible(false);
                                talk.setVisible(false);
                                Label flowerlabel = new Label("施伯伯掏出一束鮮花，走向工數魔王⋯⋯");
                                pane3.getChildren().add(flowerlabel);
                                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                                        new EventHandler<ActionEvent>() {
                                            int i = 1;
                                            @Override
                                            public void handle(ActionEvent actionEvent) {
                                                if(i==1){
                                                    i+=1;
                                                    flowerlabel.setText("剎那間，天雷勾動地火！！！");
                                                }
                                                else if(i==2){
                                                    flowerlabel.setText("蹦！他們焦了，魔王覺得施伯伯好清純好不做作");
                                                    i++;
                                                }
                                                else{
                                                    flowerlabel.setText("此後，魔王對施伯伯芳心暗許");
                                                    home.setVisible(true);
                                                    home.setFont(Font.font(20));
                                                    home.setLayoutY(10);
                                                    home.setLayoutX(500);
                                                    exit.setVisible(true);
                                                    exit.setFont(Font.font(20));
                                                    exit.setLayoutY(50);
                                                    exit.setLayoutX(500);
                                                }
                                            }
                                        }));
                                timeline1.setCycleCount(3);
                                timeline1.play();
                            }
                        });
                        talk.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                flower.setVisible(false);
                                talk.setVisible(false);
                                Label talklabel = new Label("施伯伯打算使出三寸不爛之舌攻略魔王");
                                pane3.getChildren().add(talklabel);
                                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                                        new EventHandler<ActionEvent>() {
                                            int i = 1;
                                            @Override
                                            public void handle(ActionEvent actionEvent) {
                                                if(i==1){
                                                    i+=1;
                                                    talklabel.setText("魔王看到他的瞬間，心跳不自覺加速");
                                                }
                                                else if(i==2){
                                                    talklabel.setText("想起了期中考時⋯⋯");
                                                    i++;
                                                }
                                                else{
                                                    talklabel.setText("那張空白試卷，反手就把施伯伯當掉，完。");
                                                    home.setVisible(true);
                                                    home.setFont(Font.font(20));
                                                    home.setLayoutY(10);
                                                    home.setLayoutX(500);
                                                    exit.setVisible(true);
                                                    exit.setFont(Font.font(20));
                                                    exit.setLayoutY(50);
                                                    exit.setLayoutX(500);
                                                }

                                            }
                                        }));
                                timeline1.setCycleCount(3);
                                timeline1.play();
                            }
                        });
                        stage.setScene(new Scene(pane3, 640, 400));
                        pane3.getChildren().addAll(backview,peopleview,flower,talk,home,exit);

                    }

                });

                Button soon = new Button();
                Image soon_image = new Image("https://i.ibb.co/1KDMKp2/su-min-de.jpg");
                ImageView soon_view = new ImageView(soon_image);
                soon.setGraphic(soon_view);
                soon_view.setFitHeight(200);
                soon_view.setFitWidth(150);

                soon.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Pane pane4 = new Pane();
                        Image back = new Image("https://wimg.588ku.com/gif/20/04/16/06088a0f0a4dfe593159b568a4d5dfe1.gif");
                        ImageView backview = new ImageView(back);
                        backview.setFitWidth(640);
                        backview.setFitHeight(400);

                        Image people = new Image("https://i.ibb.co/7JGT2SM/096-BED99-61-AB-4-D30-B699-30844-E1-D6-C21.png");
                        ImageView peopleview = new ImageView(people);
                        peopleview.setFitWidth(200);
                        peopleview.setFitHeight(400);
                        peopleview.setLayoutY(30);
                        peopleview.setLayoutX(220);

                        Button flower = new Button("鮮花送禮");
                        Button talk = new Button("花言巧語");
                        flower.setLayoutY(300);
                        flower.setLayoutX(200);
                        talk.setLayoutY(300);
                        talk.setLayoutX(350);

                        flower.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                flower.setVisible(false);
                                talk.setVisible(false);
                                Label flowerlabel = new Label("施伯伯掏出一本離散講義，走向道士⋯⋯");
                                pane4.getChildren().add(flowerlabel);
                                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                                        new EventHandler<ActionEvent>() {
                                            int i = 1;
                                            @Override
                                            public void handle(ActionEvent actionEvent) {
                                                if(i==1){
                                                    i+=1;
                                                    flowerlabel.setText("害羞的垂下眼，將手中的講義送給對方");
                                                }
                                                else if(i==2){
                                                    flowerlabel.setText("「這是我的心意，希望您收下」，道士心下感動");
                                                    i++;
                                                }
                                                else{
                                                    flowerlabel.setText("並回道「謝謝你，\n不過我用的是交大的上課ppt」，完");
                                                    home.setVisible(true);
                                                    home.setFont(Font.font(20));
                                                    home.setLayoutY(10);
                                                    home.setLayoutX(500);
                                                    exit.setVisible(true);
                                                    exit.setFont(Font.font(20));
                                                    exit.setLayoutY(50);
                                                    exit.setLayoutX(500);
                                                }
                                            }
                                        }));
                                timeline1.setCycleCount(3);
                                timeline1.play();
                            }
                        });
                        talk.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                flower.setVisible(false);
                                talk.setVisible(false);
                                Label talklabel = new Label("施伯伯打算使出三寸不爛之舌攻略道士");
                                pane4.getChildren().add(talklabel);
                                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                                        new EventHandler<ActionEvent>() {
                                            int i = 1;
                                            @Override
                                            public void handle(ActionEvent actionEvent) {
                                                if(i==1){
                                                    i+=1;
                                                    talklabel.setText("經過施伯伯不斷地尬聊");
                                                }
                                                else if(i==2){
                                                    talklabel.setText("他們的感情逐漸升溫");
                                                    i++;
                                                }
                                                else{
                                                    talklabel.setText("道士覺得他真是一個磨人的小妖精\n並對他春心萌芽");
                                                    home.setVisible(true);
                                                    home.setFont(Font.font(20));
                                                    home.setLayoutY(10);
                                                    home.setLayoutX(500);
                                                    exit.setVisible(true);
                                                    exit.setFont(Font.font(20));
                                                    exit.setLayoutY(50);
                                                    exit.setLayoutX(500);
                                                }
                                            }
                                        }));
                                timeline1.setCycleCount(3);
                                timeline1.play();
                            }
                        });

                        stage.setScene(new Scene(pane4, 640, 400));
                        pane4.getChildren().addAll(backview,peopleview,flower,talk,home,exit);

                    }
                });

                Button chen = new Button();
                Image chen_image = new Image("https://pairlabs.ai/wp-content/uploads/2020/04/sasa2.png");
                ImageView chen_view = new ImageView(chen_image);
                chen.setGraphic(chen_view);
                chen_view.setFitHeight(200);
                chen_view.setFitWidth(150);

                chen.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Pane pane5 = new Pane();
                        Image back = new Image("https://wimg.588ku.com/gif/20/04/16/06088a0f0a4dfe593159b568a4d5dfe1.gif");
                        ImageView backview = new ImageView(back);
                        backview.setFitWidth(640);
                        backview.setFitHeight(400);

                        Image people = new Image("https://i.ibb.co/S52w99j/85153-C6-E-754-B-47-E4-B664-726966-B9224-D.png" );
                        ImageView peopleview = new ImageView(people);
                        peopleview.setFitWidth(200);
                        peopleview.setFitHeight(400);
                        peopleview.setLayoutY(30);
                        peopleview.setLayoutX(200);

                        Button flower = new Button("鮮花送禮");
                        Button talk = new Button("花言巧語");
                        flower.setLayoutY(300);
                        flower.setLayoutX(200);
                        talk.setLayoutY(300);
                        talk.setLayoutX(350);

                        flower.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                flower.setVisible(false);
                                talk.setVisible(false);
                                Label flowerlabel = new Label("施伯伯掏出一塊FPGA開發板，走向大溼⋯⋯");
                                pane5.getChildren().add(flowerlabel);
                                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                                        new EventHandler<ActionEvent>() {
                                            int i = 1;
                                            @Override
                                            public void handle(ActionEvent actionEvent) {
                                                if(i==1){
                                                    i+=1;
                                                    flowerlabel.setText("施伯伯朱唇微啟道");
                                                }
                                                else if(i==2){
                                                    flowerlabel.setText("「大溼，今晚⋯⋯我想和您一起深入探討VHDL」");
                                                    i++;
                                                }
                                                else{
                                                    flowerlabel.setText("大溼為睿智的施伯伯傾倒，決定明年帶他回金門掃墓");
                                                    home.setVisible(true);
                                                    home.setFont(Font.font(20));
                                                    home.setLayoutY(10);
                                                    home.setLayoutX(500);
                                                    exit.setVisible(true);
                                                    exit.setFont(Font.font(20));
                                                    exit.setLayoutY(50);
                                                    exit.setLayoutX(500);
                                                }
                                            }
                                        }));
                                timeline1.setCycleCount(3);
                                timeline1.play();
                            }
                        });
                        talk.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                flower.setVisible(false);
                                talk.setVisible(false);
                                Label talklabel = new Label("施伯伯打算使出三寸不爛之舌攻略大溼");
                                pane5.getChildren().add(talklabel);
                                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                                        new EventHandler<ActionEvent>() {
                                            int i = 1;
                                            @Override
                                            public void handle(ActionEvent actionEvent) {
                                                if(i==1){
                                                    i+=1;
                                                    talklabel.setText("一日，施伯伯見大溼在工五的走廊上");
                                                }
                                                else if(i==2){
                                                    talklabel.setText("決定上前搭訕");
                                                    i++;
                                                }
                                                else{
                                                    talklabel.setText("大溼道「抱歉同學，我現在回金門掃墓，六點的飛機」，完");
                                                    home.setVisible(true);
                                                    home.setFont(Font.font(20));
                                                    home.setLayoutY(10);
                                                    home.setLayoutX(500);
                                                    exit.setVisible(true);
                                                    exit.setFont(Font.font(20));
                                                    exit.setLayoutY(50);
                                                    exit.setLayoutX(500);
                                                }
                                            }
                                        }));
                                timeline1.setCycleCount(3);
                                timeline1.play();
                            }
                        });

                        stage.setScene(new Scene(pane5, 640, 400));
                        pane5.getChildren().addAll(backview,peopleview,flower,talk,home,exit);

                    }
                });

                su.setLayoutX(20);su.setLayoutY(60);
                soon.setLayoutX(225);soon.setLayoutY(60);
                chen.setLayoutX(425);chen.setLayoutY(60);


                Label label2 = new Label("請為施伯伯找為適合他的良人！");
                Label su_label = new Label("工數魔王");
                Label soon_label = new Label("離散道士");
                Label chen_label = new Label("數導大溼");
                label2.setLayoutX(220);label2.setLayoutY(20);
                su_label.setLayoutX(80);su_label.setLayoutY(300);
                soon_label.setLayoutX(285);soon_label.setLayoutY(300);
                chen_label.setLayoutX(485);chen_label.setLayoutY(300);
                su_label.setStyle("-fx-text-fill:WHITE;");
                soon_label.setStyle("-fx-text-fill:WHITE;");
                chen_label.setStyle("-fx-text-fill:WHITE;");
                label2.setStyle("-fx-text-fill:WHITE;");

                pane2.getChildren().addAll(classview,su,soon,chen,label2,su_label,chen_label,soon_label);
                stage.setScene(new Scene(pane2, 640, 400));

            }
        });
        home.setOnAction(e->{
            this.menu(stage);
        });
        exit.setOnAction(e->{
            stage.close();
        });
    }

    public void politics(Stage stage){
        home.setVisible(false);
        exit.setVisible(false);
        polStatus[smartLevel-1]=1;
        Canvas canvas = new Canvas(640,400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // 初始化绘画器
        SceneDrawer1 drawer = new SceneDrawer1(canvas, gc);
        // 注册场景
        List<MiniScene1> sceneList = registerScene();
        // 场景指针
        scneneIdx = 0;

        new Thread(()->{
            // 开始游戏循环，只要场景没有循环完，就一直执行游戏循环
            while(scneneIdx < sceneList.size()){
                //System.out.println("一帧");
                drawer.draw(sceneList.get(scneneIdx));
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Pane pane = new Pane();
        Scene scene = new Scene(pane, 640,400);
        pane.getChildren().addAll(canvas,home,exit);
        stage.setScene(scene);

        // 这里需要给场景添加一个控制器，相应鼠标点击事件
        scene.setOnMouseClicked(e -> {
            // 如果文字没有播放完，就播放文字
            // 如果文字播放完了，就播放下一个场景
            if(!sceneList.get(scneneIdx).getTextentity().isFinish()){
                sceneList.get(scneneIdx).getTextentity().setFinish(true);
            } else {
                if (scneneIdx < sceneList.size() - 1) {
                    scneneIdx++;
                } else {
                    //System.out.println('y');
                    home.setVisible(true);
                    home.setFont(Font.font(20));
                    home.setLayoutY(10);
                    home.setLayoutX(500);
                    exit.setVisible(true);
                    exit.setFont(Font.font(20));
                    exit.setLayoutY(50);
                    exit.setLayoutX(500);
                }
            }
            //System.out.println("鼠标点击事件");
        });
        home.setOnAction(e->{
            this.menu(stage);
        });
        exit.setOnAction(e->{
            stage.close();
        });
    }

    public void superstar(Stage stage){
        home.setVisible(false);
        exit.setVisible(false);
        actStatus[smartLevel-1]=1;
        Pane pane = new Pane();
        if(smartLevel>=3){
            //pane1 內容
            Image high = new Image("https://i.ibb.co/rb8dgyq/F1256-D48-8-D99-428-F-AB33-DEEBA3-E0-EC4-C.png");
            ImageView highView = new ImageView(high);
            highView.setFitHeight(400);
            highView.setFitWidth(640);
            Label high_label = new Label("施伯伯發射偶像魅力，大眾魂牽夢縈！");
            high_label.setLayoutX(150);
            high_label.setLayoutY(350);
            high_label.setStyle("-fx-background-color: white; ");

            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                    new EventHandler<ActionEvent>() {
                        int i = 1;
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            if(i==1){
                                i+=1;
                                high_label.setText("並且成為全球少男少女殺手，走向人生巔峰！");
                            }
                            else if(i==2){
                                high_label.setText("賺到數十億資產後，你與施伯伯從此幸福快樂的生活在一起");
                                home.setVisible(true);
                                home.setFont(Font.font(20));
                                home.setLayoutY(10);
                                home.setLayoutX(500);
                                exit.setVisible(true);
                                exit.setFont(Font.font(20));
                                exit.setLayoutY(50);
                                exit.setLayoutX(500);
                            }
                        }
                    }));
            timeline1.setCycleCount(2);
            timeline1.play();
            pane.getChildren().addAll(highView,high_label,home,exit);
        }
        else if(smartLevel==2){
            Image medium = new Image("https://i.ibb.co/p3JbzFF/5-E0-AAFDC-EB36-4-C55-A15-A-94-FABFC12241.png");
            ImageView mediumView = new ImageView(medium);
            mediumView.setFitHeight(400);
            mediumView.setFitWidth(640);
            Label medium_label = new Label("施伯伯成為街頭表演大師，每日在西門町與你相遇！");
            medium_label.setLayoutX(150);
            medium_label.setLayoutY(350);
            medium_label.setStyle("-fx-background-color: white; ");

            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                    new EventHandler<ActionEvent>() {
                        int i = 1;
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            if(i==1){
                                i+=1;
                                medium_label.setText("你走上前，投了100元在帽子裡");
                            }
                            else if(i==2){
                                medium_label.setText("施伯伯對你一見鐘情，從此幸福快樂的生活在一起");
                                home.setVisible(true);
                                home.setFont(Font.font(20));
                                home.setLayoutY(10);
                                home.setLayoutX(500);
                                exit.setVisible(true);
                                exit.setFont(Font.font(20));
                                exit.setLayoutY(50);
                                exit.setLayoutX(500);
                            }
                        }
                    }));
            timeline1.setCycleCount(2);
            timeline1.play();
            pane.getChildren().addAll(mediumView,medium_label,home,exit);
        }
        else if(smartLevel<=1){
            Image medium = new Image("https://i.ibb.co/PxWdD0v/A5-FF699-A-D50-B-4-DE9-B57-E-7-BD9-AB01009-A.png");
            ImageView mediumView = new ImageView(medium);
            mediumView.setFitHeight(400);
            mediumView.setFitWidth(640);
            Label medium_label = new Label("施伯伯學藝不精，淪落街頭！");
            medium_label.setLayoutX(150);
            medium_label.setLayoutY(350);
            medium_label.setStyle("-fx-background-color: white; ");

            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000),
                    new EventHandler<ActionEvent>() {
                        int i = 1;
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            if(i==1){
                                i+=1;
                                medium_label.setText("你走上前，投了100元在碗公裏面");
                            }
                            else if(i==2){
                                medium_label.setText("施伯伯對你一見鐘情，從此幸福快樂的生活在一起");
                                home.setVisible(true);
                                home.setFont(Font.font(20));
                                home.setLayoutY(10);
                                home.setLayoutX(500);
                                exit.setVisible(true);
                                exit.setFont(Font.font(20));
                                exit.setLayoutY(50);
                                exit.setLayoutX(500);
                            }
                        }
                    }));
            timeline1.setCycleCount(2);
            timeline1.play();
            pane.getChildren().addAll(mediumView,medium_label,home,exit);
        }
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        home.setOnAction(e->{
            this.menu(stage);
        });
        exit.setOnAction(e->{
            stage.close();
        });
    }

    public void computer(Stage stage){
        csStatus[smartLevel-1]=1;
        Pane pane = new Pane();
        pane.setMinWidth(640);
        pane.setMinHeight(400);
        Image imagelow = new Image("https://i.imgur.com/r2jbdP1.png");
        ImageView csLowimageView = new ImageView(imagelow);
        Label text1 = new Label("經過大學四年的歷練，你與施伯伯在一堂通識課裡相遇");
        Label text2 = new Label("施北北因課業的繁重導致頭髮稀疏，最終是個在灰暗房間裡獨自努力的碼農");
        Label result1 = new Label("在黑暗的房間內，你是他唯一的光，讓施伯伯不至於在完全黑暗的環境寫程式");
        Label end = new Label("End");
        text1.setLayoutX(14);
        text1.setLayoutY(14.0);
        text2.setLayoutX(14);
        text2.setLayoutY(36);
        result1.setLayoutX(14);
        result1.setLayoutY(58);
        end.setLayoutX(600);
        end.setLayoutY(370);
        text1.setStyle("-fx-background-color:white");
        text2.setStyle("-fx-background-color:white");
        result1.setStyle("-fx-background-color:white");
        end.setStyle("-fx-background-color:white");
        home.setFont(Font.font(20));
        home.setLayoutY(10);
        home.setLayoutX(500);
        exit.setFont(Font.font(20));
        exit.setLayoutY(50);
        exit.setLayoutX(500);


        Image imagemid = new Image("https://i.imgur.com/wUNeidB.png");
        ImageView csMidimageView = new ImageView(imagemid);
        Label text3 = new Label("經過大學四年的歷練，施北北因課業的繁重導致頭髮稀疏");
        Label text4 = new Label("也因為長年努力，成為了工程師主管");
        Label result2 = new Label("你與施伯伯在公司裡的迎新會上相識，此後開會時，你總是會不經意的多看施伯伯一眼");
        Label end2 = new Label("End");
        text3.setLayoutX(14);
        text3.setLayoutY(14.0);
        text4.setLayoutX(14);
        text4.setLayoutY(36);
        result2.setLayoutX(14);
        result2.setLayoutY(58);
        end2.setLayoutX(600);
        end2.setLayoutY(370);
        text3.setStyle("-fx-background-color:white");
        text4.setStyle("-fx-background-color:white");
        result2.setStyle("-fx-background-color:white");
        end2.setStyle("-fx-background-color:white");


        Image imageHigh = new Image("https://i.imgur.com/5D8OPaO.jpg");
        ImageView csHighimageView = new ImageView(imageHigh);
        Label text5 = new Label("經過大學四年的辛苦磨練，施北北因系上巨大的壓力導致頭髮稀疏");
        Label text6 = new Label("由於施伯伯的天資聰穎，參與了許許多多的活動皆有精彩的表現");
        Label result3 = new Label("最終成為傳說中的施北北！！！！");
        Label end3 = new Label("End");
        text5.setLayoutX(14);
        text5.setLayoutY(14.0);
        text6.setLayoutX(14);
        text6.setLayoutY(36);
        result3.setLayoutX(14);
        result3.setLayoutY(58);
        end3.setLayoutX(600);
        end3.setLayoutY(370);
        text5.setStyle("-fx-background-color:white");
        text6.setStyle("-fx-background-color:white");
        result3.setStyle("-fx-background-color:white");
        end3.setStyle("-fx-background-color:white");


        if (smartLevel<=1){
            pane.getChildren().addAll(csLowimageView,text1,text2,result1,end,home,exit);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
        }
        else if (smartLevel==2){
            pane.getChildren().addAll(csMidimageView,text3,text4,result2,end2,home,exit);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
        }
        else{
            pane.getChildren().addAll(csHighimageView,text5,text6,result3,end3,home,exit);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
        }

        home.setOnAction(e->{
            this.menu(stage);
        });
        exit.setOnAction(e->{
            stage.close();
        });
    }

    public void marriage(Stage stage){
        Pane pane = new Pane();
        pane.setMinWidth(640);
        pane.setMinHeight(400);
        Image marry = new Image("https://i.ibb.co/8mzvGwv/5-C50-B597-85-D7-46-D1-A1-B5-96-AF04-C5-FCA5.png");
        ImageView marriage = new ImageView(marry);
        home.setFont(Font.font(20));
        home.setLayoutY(10);
        home.setLayoutX(500);
        exit.setFont(Font.font(20));
        exit.setLayoutY(50);
        exit.setLayoutX(500);
        home.setOnAction(e->{
            this.menu(stage);
        });
        exit.setOnAction(e->{
            stage.close();
        });
        pane.getChildren().addAll(marriage,home,exit);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
