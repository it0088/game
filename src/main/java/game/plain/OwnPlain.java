package game.plain;

import game.Images;

public class OwnPlain extends Plain{

    private static final OwnPlain ownPlain = new OwnPlain(50,50, Images.RED_AIRPLANE, Images.BULLETNONFIRE);

    private OwnPlain(int x, int y,String plainImg, String bulletImg) {
        super(x, y, plainImg, bulletImg);
    }


    public static OwnPlain getOwnPlain(){
        return ownPlain;
    }

    @Override
    public void setTheBulletPositionOnThePlane() {
        shiftBulletX(50);
        shiftBulletY(90);
    }

    @Override
    public void shootingModeOn() {
        super.shootingModeOn();
        setBulletImage(Images.FIRE_BULLET);

    }

    @Override
    public void shootingModeOff() {
        super.shootingModeOff();
        setBulletImage(Images.BULLETNONFIRE);
    }
}
