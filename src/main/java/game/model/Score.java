package game.model;

public class Score {
    private int crashedShips;
    private int record;


    void increase() {
        crashedShips++;
    }

    void setToZero() {
        crashedShips = 0;
    }

    public int getScore() {
        return crashedShips;
    }

    public int getRecord() {
        return record;
    }

    void calcRecord() {
        record = Math.max(crashedShips, record);
    }
}
