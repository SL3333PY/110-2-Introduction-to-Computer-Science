package suprise.shi_bibi_dream_factory;

import javafx.scene.image.Image;

public class TextAnimEntity {
    // 这个属性是说话的人
    private String name;
    // 这个属性是说的话
    private String text;
    // 人物的头像
//    private Image image;

    // 背景图片
    private Image bgImage;

    private int width = 640;
    private int height = 100;
    // 指针，指向下一个要显示的字
    private int textIdx;
    // 定义一个延时计数器，只有计数器到达一定值的时候才将指针前移
    private int clock;
    private int clock_max;

    // 是否完全显示标志位
    private boolean finish;

    public TextAnimEntity(String bg_img,String name, String text){
//        this.image = new Image(image, width, height, true, true);
        this.bgImage = new Image(bg_img);
        this.name = name;
        this.text = text;
        this.textIdx = 0;
        this.finish = false;
        this.clock = 0;
        this.clock_max = 5;
    }

    private String getsub(){
        if (textIdx == 0) {
            return "";
        }
        char[] c = new char[textIdx+1];
        for(int i=0; i<textIdx; i++){
            c[i] = text.charAt(i);
        }
        return new String(c);
    }

    // 获取要显示的字
    public synchronized String getnext(){
        if(finish){
            //return name + "：" + text;
            return text;
        }
        if(clock < clock_max){
            //System.out.println(textIdx);
            clock++;
            //return name + "：" + getsub();
            return getsub();
        } else {
            clock = 0;
            //String rst = name + "：" + getsub();
            String rst = getsub();
            textIdx++;
            if (textIdx == text.length()) {
                finish = true;
            }
            return rst;
        }
    }

    public Image getBgImage() {
        return bgImage;
    }

//    public Image getImage() {
//        return image;
//    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean b) {
        finish = b;
    }
}
