package game.view;

import game.controller.Controller;
import game.controller.DataForView;
import game.model.Background;
import game.model.DataInfo;
import game.model.Score;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View extends JFrame {


    public View(DataForView dataForView) {
        super("Clash of Aliens");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 500);
        setVisible(true);
        add(new ScreenGame(dataForView));

    }

    public void setController(Controller controller) {
        addKeyListener(new KeyListener(controller));
    }


    static class ScreenGame extends JComponent {

        Font font;
        DataForView data;

        public ScreenGame(DataForView data) {

            this.font = new Font("Impact", Font.BOLD, 30);
            this.data = data;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D d2 = ((Graphics2D) g);

            d2.setFont(font);

            paintBackground(d2);

            paintScore(d2);

            paintOwnPlane(d2);

            paintAliensPlane(d2);

        }

        private void paintBackground(Graphics2D d2) {
            List<Background> backgrounds = data.getBackground();
            for (Background back : backgrounds) {
                d2.drawImage(back.getBackgroundImage(), back.getX(), back.getY(), null);
            }
        }

        private void paintScore(Graphics2D d2) {
            Score score = data.getScore();
            d2.drawString("Crashed ships: " + score.getScore(), 20, 50);
            d2.drawString("Record: " + score.getRecord(), 400, 50);
        }

        private void paintOwnPlane(Graphics2D d2) {
            DataInfo plane = data.getOwnPlaneInfo();

            d2.drawImage(plane.getPlainImage(), plane.getX(), plane.getY(), null);

            d2.drawImage(plane.getBulletImage(), plane.getBulletX(), plane.getBulletY(), null);

        }

        private void paintAliensPlane(Graphics2D d2) {
            List<DataInfo> planeList = data.getAlienPlanes();
            for (DataInfo plane : planeList) {
                d2.drawImage(plane.getBulletImage(), plane.getBulletX(), plane.getBulletY(), null);
                d2.drawImage(plane.getPlainImage(), plane.getX(), plane.getY(), null);
            }
        }

    }

}
