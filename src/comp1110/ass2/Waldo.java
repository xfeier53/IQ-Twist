package comp1110.ass2;

import javafx.scene.image.Image;
// by u6406312


public class Waldo {
    public static Image waldo(int number){
        Image a = new Image("comp1110/ass2/gui/assets/a.png",96,96,true,false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png",97,97,true,false);
        Image c = new Image("comp1110/ass2/gui/assets/c.png",98,98,true,false);
        Image d = new Image("comp1110/ass2/gui/assets/d.png",99,99,true,false);
        Image e = new Image("comp1110/ass2/gui/assets/e.png",100,100,true,false);
        Image f = new Image("comp1110/ass2/gui/assets/f.png",101,101,true,false);
        Image g = new Image("comp1110/ass2/gui/assets/g.png",102,102,true,false);
        Image h = new Image("comp1110/ass2/gui/assets/h.png",103,103,true,false);


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
        int a = (int) image.getWidth();
        System.out.println(a);
        return a;


    }
}
