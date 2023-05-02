package suprise.shi_bibi_dream_factory;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

public class SceneDrawer1 {

    private Canvas canvas;
    private GraphicsContext gc;


    public SceneDrawer1(Canvas canvas, GraphicsContext gc) {
        this.canvas = canvas;
        this.gc = gc;
    }

    // 每次画的时候都需要传入一个场景实体类
    public void draw(MiniScene1 miniScene) {
        // 清空屏幕
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // 画背景
        gc.drawImage(miniScene.getBg(), 0, 0, canvas.getWidth(), canvas.getHeight());
        // 画人物
//        gc.drawImage(miniScene.getRole(), canvas.getWidth() * 0.3, 50, 350, 500);
        // 画对话框
        TextAnimEntity entity = miniScene.getTextentity();

        gc.drawImage(entity.getBgImage(), 0, canvas.getHeight() * 0.65, canvas.getWidth(), 150);

        // 绘制头像
//        gc.drawImage(entity.getImage(), canvas.getWidth()*0.7,canvas.getHeight()*0.7, 100,100);

        // 绘制说的话
        gc.setFont(Font.font(20));
        //System.out.println(entity.getnext());
        //gc.setFill(Color.BLACK);
        gc.strokeText(entity.getnext(), 100, canvas.getHeight() * 0.75);

    }
}