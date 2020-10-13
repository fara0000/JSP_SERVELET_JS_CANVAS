package java.models;

public class TableRow {
    private int x;
    private double y;
    private double r;
    private String currentTime;
    private String time;
    private String result;

    public TableRow(int x, double y, double r, String currentTime, String time, String result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.time = time;
        this.result = result;
    }

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getTime() {
        return time;
    }

    public String getResult() {
        return result;
    }
}