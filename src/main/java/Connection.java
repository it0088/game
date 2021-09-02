import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class Connection {


    private int recognizeDevice;
    private String unique;

    BufferedReader reader ;
    PrintWriter writer;
    Socket socket;

    public Connection(Socket socket) {
        try {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void send(String data){
        writer.println(data);
    }

    public int getRecognizeDevice() {
        return recognizeDevice;
    }

    public void setRecognizeDevice(int recognizeDevice) {
        this.recognizeDevice = recognizeDevice;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return recognizeDevice == that.recognizeDevice &&
                Objects.equals(unique, that.unique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recognizeDevice, unique);
    }

    public void close(){
        try {
            socket.close();
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
