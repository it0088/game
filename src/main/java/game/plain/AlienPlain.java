package game.plain;


import java.util.ArrayList;

public class AlienPlain extends Plain {


    public AlienPlain  (int x, int y) {
        super(x,y);

    }


    @Override
    public void setTheBulletPositionOnThePlane() {
        shiftX(50);
        shiftY(90);
    }
}

