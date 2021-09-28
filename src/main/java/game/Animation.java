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
        Sound.plainSound.playSound(5);
        while (true) {

            model.controlAirPlaneLifeCycle();

            model.controlAliensPlainLifeCycle();

            model.whereOwnAlienAndBombAlien();

            view.repaint();

            delayProcces(10);

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
