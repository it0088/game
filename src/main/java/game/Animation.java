package game;


public class Animation extends Thread {
    private View view;
    private Model model;

    public Animation(View view, Model model) {
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

    public void delayProcces(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
