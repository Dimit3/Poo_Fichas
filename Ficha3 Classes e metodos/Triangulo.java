public class Triangulo {
    
    //a




    private Ponto p1;
    private Ponto p2;
    private Ponto p3;

    public Triangulo (Ponto p1, Ponto p2, Ponto p3) {
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
      }

    public Triangulo (Triangulo triangulo) {
        this.p1 = triangulo.getP1();
        this.p2 = triangulo.getP2();
        this.p3 = triangulo.getP3(); 
        // pode ser preciso clone depende dos geters
        // Triangulo(triangulo.getP1(),triangulo.getP2(),triangulo.getP3())
        //faz clone na Triangulo
      }

    /**
     * Construtor de triangulo por omissao
     * tem 3 pontos na posiçao (0,0)
     */
    public Triangulo (){
        this.p1 = new Ponto();
        this.p2 = new Ponto();
        this.p3 = new Ponto();
    }
    
    public Ponto getP1 (){
        return this.p1.clone();
    }
    public Ponto getP2 (){
        return this.p2.clone();
    }
    public Ponto getP3 (){
        return this.p3.clone();
    }
    
    public void setP1 (Ponto x){
        this.p1 = x.clone();
    }
    public void setP2 (Ponto x){
        this.p2 = x.clone();
    }
    public void setP3 (Ponto x){
        this.p3 = x.clone();
    }

    
    public Triangulo clone() {
        return new Triangulo(this);    
    }

    public String toString (){
        return ("P1: " + this.p1.toString() + "\nP2: " + this.p2.toString() + "\nP3: " + this.p3.toString());
    }

    /**
     * metodos que compara dois triangulos.
     * Assume-se que sao iguais se tiverem os mesmos 3 pontos,
     * independemente da ordem
     * 
     * tem bug se tiver 2 pontos iguais
     * 
     * @return truee se forem triangulos iguais
     */
    public Boolean equals(Triangulo t){
        Boolean result = true;
        result = result && (this.p1.equals(t.getP1()) || this.p1.equals(t.getP1()) || 
        this.p1.equals(t.getP1()));

        result = result && (this.p2.equals(t.getP1()) || this.p2.equals(t.getP1()) || 
        this.p2.equals(t.getP1()));

        
        result = result && (this.p3.equals(t.getP1()) || this.p3.equals(t.getP1()) || 
        this.p3.equals(t.getP1()));

        return result;

    }

    //b      
    //Heron's Formula
    //calcular sem precisar de altura 

    public double calculaAreaTriangulo(){
        Double dist1 = this.p1.distancia(this.p2);
        Double dist2 = this.p1.distancia(this.p3);
        Double dist3 = this.p2.distancia(this.p3);

        Double S = (dist1+dist2+dist3)/2;
        Double area = Math.sqrt(S*(S-dist1)*(S-dist2)*(S-dist3));

        return area;
    }


    //c
    public double calculaPerimetroTriangulo(){
        Double dist1 = this.p1.distancia(this.p2);
        Double dist2 = this.p1.distancia(this.p3);
        Double dist3 = this.p2.distancia(this.p3);

        return dist1 + dist2 + dist3;
    }
    

    //d

    public double alturaTriangulo(){
        int y1 = this.p1.getY();
        int y2 = this.p2.getY();
        int y3 = this.p3.getY();
        int max,min;

        max = Math.max(y1, Math.max(y2, y3));
        min = Math.min(y1, Math.min(y2, y3));

        return max-min;
    }
}

    