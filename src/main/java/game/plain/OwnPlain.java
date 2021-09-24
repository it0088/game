package game.plain;

public class OwnPlain extends Plain{

    private static final OwnPlain ownPlain = new OwnPlain(50,50);

    private OwnPlain(int x, int y) {
        super(x, y);
    }


    public static OwnPlain getOwnPlain(){
        return ownPlain;
    }

    @Override
    public void setTheBulletPositionOnThePlane() {
        shiftX(50);
        shiftY(90);
    }
}
