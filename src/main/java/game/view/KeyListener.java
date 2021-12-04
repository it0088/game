package game.view;

import game.controller.Controller;
import game.controller.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    Controller controller;

    public KeyListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                controller.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                controller.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                controller.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                controller.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_SPACE:
                controller.setShootModeOn();
                break;
            case KeyEvent.VK_A:
                controller.setDirection(Direction.STOP);
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);

        }
    }
}
