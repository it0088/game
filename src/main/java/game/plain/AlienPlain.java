package game.plain;


public class AlienPlain extends Plain {


    public AlienPlain(int x, int y,String plainImg, String bulletImg) {
        super(x, y, plainImg, bulletImg);

    }


    @Override
    public void setTheBulletPositionOnThePlane() {
        shiftBulletX(0);
        shiftBulletY(0);
    }

}

