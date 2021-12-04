package game.controller;


import game.model.Model;
import game.view.View;

public class Controller extends Thread {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void run() {

        while (true) {

            model.moveTheBackground();

            model.destroyCurrentPlainAndAddNew();

            model.controlAirPlaneLifeCycle();

            model.controlAliensPlainLifeCycle();

            model.detectCollisionOfPlanes();

            view.repaint();

            delayProcces(15);

        }
    }



    public void setDirection(Direction direction) {
       model.setOwnPlane(direction);
    }

    public void setShootModeOn() {
        model.setShootModeOn();
    }

    public void delayProcces(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
