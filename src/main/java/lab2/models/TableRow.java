package lab2.models;

public class TableRow {
    private double x;
    private double y;
    private int r;
    private String currentTime;
    private String time;
    private String result;

    public TableRow(double x, double y, int r, String currentTime, String time, String result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.time = time;
        this.result = result;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
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
