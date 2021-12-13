package game.model.objects;

import game.resource.Images;

public class OwnPlane extends Plane {


    public OwnPlane(int x, int y, String plainImg, String bulletImg) {
        super(x, y, plainImg, bulletImg);
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

    @Override
    public void toDestroy() {
        super.toDestroy();
        setPlainImage(Images.BOOM);
    }
}
