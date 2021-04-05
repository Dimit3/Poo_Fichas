import java.lang.Math;

public class Circle {

    private double x;
    private double y;
    private double r;

    public Boolean equals (Circle circle){
        return (this.x == circle.getX() && this.y == circle.getY() && this.r == circle.getRaio());
    }

    public String toString (){
        return ("X =" + this.x + " Y = " + this.y + "R = " + this.r);
    }

    public Circle clone() {
        return new Circle(this);    
      }

    public Circle () {
        this.x = 0;
        this.y = 0;
        this.r = 1;
      }

    public Circle (double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
      }
    
    public Circle (Circle circle) {
        this.x = circle.getX();
        this.y = circle.getY();
        this.r = circle.getRaio();
      }
    
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getRaio(){
        return this.r;
    }

    public void setX (double x){
        this.x = x;
    }

    public void setY (double y){
        this.y = y;
    }

    public void setRaio (double raio){
        this.r = raio;
    }

    public void alteraCentro( double x, double y){
        this.x = x;
        this.y = y;
    }

    public Double calculaArea(){
        Double area = (double) 0;
        area = Math.PI * Math.pow(this.r,2);
        return area;
    }

    public Double calculaPerimetro(){
        Double perimetro = (double) 0;
        perimetro = 2 * Math.PI * this.r;
        return perimetro;
    }
}