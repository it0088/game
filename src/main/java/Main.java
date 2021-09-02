import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new Main().startAndRestart();
    }

    public void startAndRestart() {
        System.out.println("Game is starting!");
        System.out.println("Game is starting!");



        Model model = new Model();
        RemoteController remoteController = new RemoteController(model);
        Controller controller = new Controller(model);
        model.setController(controller);
        Animation animation = new Animation(controller.getView(),model);
        animation.start();


        }

    }



