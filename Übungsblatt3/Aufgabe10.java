package Übungsblatt3;

public class Aufgabe10 {

    private double x;
    private double y;

    public Aufgabe10(int x , int y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void Drehen(double winkel){

        this.x = x * Math.cos(winkel) - y * Math.sin(winkel);
        this.y = x * Math.sin(winkel) + y * Math.cos(winkel);

    }
}
