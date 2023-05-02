package suprise.shi_bibi_dream_factory;

import javafx.scene.image.Image;

public class MiniScene1 {

    // 背景和人物
    private Image bg;
//    private Image role;

    private TextAnimEntity textentity;

    public MiniScene1(String bg_src, TextAnimEntity textentity){
        this.bg = new Image(bg_src);
//        this.role = new Image(role_src);
        this.textentity = textentity;
    }

    public Image getBg() {
        return bg;
    }

 /*   public Image getRole() {
        return role;
    }*/

    public TextAnimEntity getTextentity() {
        return textentity;
    }
}
