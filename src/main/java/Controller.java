import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    public Model model;
    View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.direction = Direction.UP;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.direction = Direction.DOWN;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            model.direction = Direction.RIGHT;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            model.direction = Direction.LEFT;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.setShoot(true);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            model.direction = Direction.STOP;
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            model.direction = Direction.ESC;
        }

    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
