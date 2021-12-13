package game.model.objects;


import game.resource.Images;

public class AlienPlane extends Plane {


    public AlienPlane(int x, int y, String plainImg, String bulletImg) {
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

