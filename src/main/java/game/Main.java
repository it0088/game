package game;

public class Main {
    public static void main(String[] args) {
        new Main().toStartGame();
    }

    public void toStartGame() {
        System.out.println("Game is starting!");
        Model model = new Model();
        KeyController keyController = new KeyController(model);
        Animation animation = new Animation(keyController.getView(),model);
        animation.start();
        }
    }



