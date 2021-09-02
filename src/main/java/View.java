import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {
        Font font = new Font("Impact",Font.BOLD,30);
        Font font1 = new Font("Impact",Font.BOLD,10);
      List<Background> imgBackground = new ArrayList<>();



    BufferedImage image ;
    Controller controller;

    public View(Controller controller)  {

        super("Clash of Aliens");
        setResizable(false);
        this.controller = controller;
        try {
            image = ImageIO.read(Images.BOOM1());
        } catch (IOException e) {
            e.printStackTrace();
        }

        imgBackground.add(new Background(1,1));
        imgBackground.add(new Background(1792,1));


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200,100,950,500);
        setVisible(true);
        add(gameMotion);


        addKeyListener(controller);

    }
    JComponent gameMotionStr = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D d2 = ((Graphics2D) g);
            d2.setFont(font1);

        }
    };

    JComponent gameMotion = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D d2 = ((Graphics2D) g);

            d2.setFont(font);

            if(imgBackground.get(0).x+1792 < 0){
                int x = imgBackground.get(1).x+1792;;
                Background back = imgBackground.remove(0);
                back.x = x;
                imgBackground.add(back);
            }

            d2.drawImage(imgBackground.get(0).bombImage,imgBackground.get(0).x,imgBackground.get(0).y,null);
            d2.drawImage(imgBackground.get(1).bombImage,imgBackground.get(1).x,imgBackground.get(1).y,null);
            imgBackground.get(0).x--; imgBackground.get(1).x--;
            d2.drawString("Crashed ships: "+controller.model.aliencount,20,50);
            d2.drawString("Record : "+controller.model.getRecord(),400,50);

            if (controller.model.ownPlainIsAlive()) {
                d2.drawImage(controller.getModel().ownPlain.getBufferedImage(),
                        controller.getModel().ownPlain.x,
                        controller.getModel().ownPlain.y,null);
                d2.drawImage(controller.getModel().bullet.bufferedImage,
                        controller.getModel().bullet.getX(),
                        controller.getModel().bullet.getY(),null);

                for (int i = 0; i < controller.model.countAliens; i++) {
                    AlienPlain plain = controller.getModel().alienPlains.get(i);
                    if(plain.isAliveb){
                        d2.drawImage(plain.bombImage,plain.xbomb,plain.ybomb,null);
                        d2.drawImage(plain.getBufferedImage(),plain.x,plain.y,null);

                    }
                    else if(!plain.isAliveb) {
                        d2.drawImage(image,plain.x,plain.y,null);
                        plain.isAliveb = true;
                    }
                }
            }else {
                d2.drawImage(image,controller.model.ownPlain.x,controller.model.ownPlain.y,null);
            }

        }
    };

}
