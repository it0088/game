import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RemoteController {
    Model model;
    Connection conn;

    public RemoteController(Model model) {
        this.model = model;
        Socket socket = null;
        try {
            socket = new Socket("192.168.0.109", 8888);
            conn = new Connection(socket);
            initializeDevice(conn);
            startListConnection(conn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void startListConnection(Connection conn) {
        new Thread(() -> {
            while (true) {
                String action = conn.receive();
                if (action.equals(Host.UP)) {
                    model.direction = Direction.UP;
                } else if (action.equals(Host.DOWN)) {
                    model.direction = Direction.DOWN;
                } else if (action.equals(Host.RIGHT)) {
                    model.direction = Direction.RIGHT;
                } else if (action.equals(Host.LEFT)) {
                    model.direction = Direction.LEFT;
                } else if (action.equals(Host.SHOOT)) {
                    model.setShoot(true);
                } else if (action.equals(Host.STOP)) {
                    model.direction = Direction.STOP;
                } else if (action.equals(Host.EXIT)) {
                    conn.close();
                    model.direction = Direction.ESC;
                    break;
                }
            }
        }).start();
    }

    private void initializeDevice(Connection conn) throws NumberFormatException {
        JFrame frame = new JFrame();
        frame.setTitle("");
        frame.setLocation(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        conn.setRecognizeDevice(Host.GAME);
        conn.send(String.valueOf(Host.GAME));

        Object[] object = new Object[]{"Ключ"};
        while (true) {

            String s = JOptionPane.showInputDialog(
                    frame, object, "Введите ключ", JOptionPane.QUESTION_MESSAGE);

            if (s == null) break;
            if (s.isEmpty()) continue;
            conn.send(s);
            String receive = conn.receive();
            if (receive.equals(Host.CONTROLLEREXIST)) {
                conn.setUnique(receive);
                break;
            }
            Toolkit.getDefaultToolkit().beep();
        }
        frame.dispose();

    }


}
