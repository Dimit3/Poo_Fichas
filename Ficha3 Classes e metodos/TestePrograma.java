import java.util.Scanner;

// 1 - 9 - 7 - 8

public class TestePrograma {
    public static void main (String [] args) {
        Ponto p1 = new Ponto(1,1);
        Ponto p2 = new Ponto(1,3);
        Ponto p3 = new Ponto(3,2);

        Ponto pp1 = new Ponto(4,4);
        Ponto pp2 = new Ponto(4,8);
        Ponto pp3 = new Ponto(8,6);

        // Scanner sc = new Scanner (System.in);


        Triangulo t1 = new Triangulo(p1, p2, p3);
        Triangulo t2 = new Triangulo(pp1, pp2, pp3);

        System.out.println("distancia de p1- " + p1+ " a p2- " + p2 + " :   " + p1.distancia(p2));
        System.out.println("distancia de pp2- " + pp2 + " a  pp3- " + pp3 + " :   " + pp2.distancia(pp3));

        System.out.println("\nt1 -> \n" + t1);
        System.out.println("\nt2 -> \n" + t2);

        System.out.println("\nequals " + t1.equals(t2));
        
        System.out.println("\nperimetro t1 " + t1.calculaPerimetroTriangulo());
        System.out.println("perimetro t2 " + t2.calculaPerimetroTriangulo());

        System.out.println("\narea t1 " + t1.calculaAreaTriangulo());
        System.out.println("area t2 " + t2.calculaAreaTriangulo());

        System.out.println("\naltura t1 " + t1.alturaTriangulo());
        System.out.println("altura t2 " + t2.alturaTriangulo());


        
    }
}