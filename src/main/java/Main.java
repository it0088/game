public class Main {
    public static void main(String[] args) {
        new Main().toStartGame();
    }

    public void toStartGame() {
        System.out.println("Game is starting!");
        Model model = new Model();
        Controller controller = new Controller(model);
        Animation animation = new Animation(controller.getView(),model);
        animation.start();
        }
    }



