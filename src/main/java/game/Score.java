package game;

public class Score {
    private int crashedShips;
    private int record;


    public void increase() {
        crashedShips++;
    }

    public void setToZero() {
        crashedShips = 0;
    }

    public int getScore() {
        return crashedShips;
    }

    public int getRecord() {
        return record;
    }

    public void calcRecord() {
        record = Math.max(crashedShips, record);
    }
}
