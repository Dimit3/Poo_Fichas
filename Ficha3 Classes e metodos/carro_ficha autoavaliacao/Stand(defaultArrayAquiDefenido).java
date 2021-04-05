
/*
public class Stand {

       
    private Carro[] carros;
    private int pos; // size do array
    

    // construtores

    public Stand() {
        this.carros = new Carro[4];
        this.pos = 0;
    }

    public Stand(Stand s) {
        this.carros = s.getCarros();
        this.pos = s.getPos();
    }

    public Stand(Carro[] carros, int pos) {
        this.carros = carros.clone();
        this.pos = pos;
    }

    // set e get
    public Carro[] getCarros() {
        return this.carros.clone();
    }

    public void setCarros(Carro[] carros) {
        this.carros = carros.clone();
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    // equals

    public boolean equals(Stand o) {
        if (o == this)
            return true;
        if (!(o instanceof Stand)) {
            return false;
        }

        int i = 0;
        for (i = 0; i < pos; i++) {
            if (!(this.carros[i].equals(o.carros[i])))
                return false;
        }

        return true;
    }

    // to string
    public String toString() {
        String out = "";
        int i = 0;
        for (i = 0 ; i < pos; i++){
            out = out + "\n" + carros[i];
        }
        return "{    carros = " + out + "\npos = " + pos + "    }";
    }

    // clone

    public Stand clone() {
        return new Stand(this);
    }

} */