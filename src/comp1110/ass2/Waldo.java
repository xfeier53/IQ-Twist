package comp1110.ass2;

import javafx.scene.image.Image;
// by u6406312


public class Waldo {
    public static Image waldo(int number){
        Image a = new Image("comp1110/ass2/gui/assets/a.png",100,96,false,false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png",100,97,false,false);
        Image c = new Image("comp1110/ass2/gui/assets/c.png",100,98,false,false);
        Image d = new Image("comp1110/ass2/gui/assets/d.png",100,99,false,false);
        Image e = new Image("comp1110/ass2/gui/assets/e.png",100,100,false,false);
        Image f = new Image("comp1110/ass2/gui/assets/f.png",100,101,false,false);
        Image g = new Image("comp1110/ass2/gui/assets/g.png",100,102,false,false);
        Image h = new Image("comp1110/ass2/gui/assets/h.png",100,103,false,false);


        if(number%8==0){return a;}
        if(number%8==1){return b;}
        if(number%8==2){return c;}
        if(number%8==3){return d;}
        if(number%8==4){return e;}
        if(number%8==5){return f;}
        if(number%8==6){return g;}
        if(number%8==7){return h;}
        return a;
    }
    public static int ImageAnal (Image image){
        int a = (int) image.getHeight();
        System.out.println(a);
        return a;


    }
}
