package game.plain;


import game.Images;

public class AlienPlain extends Plain {


    public AlienPlain(int x, int y,String plainImg, String bulletImg) {
        super(x, y, plainImg, bulletImg);

    }


    @Override
    public void setTheBulletPositionOnThePlane() {
        shiftBulletX(0);
        shiftBulletY(0);
    }

    @Override
    public void toDestroy() {
        super.toDestroy();
        setPlainImage(Images.BOOM);
    }
}

