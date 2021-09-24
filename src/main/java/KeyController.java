import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
    public Model model;
    View view;

    public KeyController(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.ownPlain.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.ownPlain.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            model.ownPlain.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            model.ownPlain.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.ownPlain.shootingModeOn();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            model.ownPlain.setDirection(Direction.STOP);
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);;
        }

    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
