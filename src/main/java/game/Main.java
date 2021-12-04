package game;

import game.controller.Controller;
import game.controller.DataForView;
import game.model.Model;
import game.view.View;

public class Main {
    public static void main(String[] args) {
        new Main().toStartGame();
    }

    public void toStartGame() {
        System.out.println("Game is starting!");
        Model model = new Model();
        DataForView dataForView = new DataForView(model);
        View view = new View(dataForView);
        Controller controller = new Controller(view, model);
        view.setController(controller);
        controller.start();
    }
}



