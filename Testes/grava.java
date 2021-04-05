import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

public class grava implements Serializable {

    public grava (){
    }
    
    //csv

    public void gravaCSV (String nomeFicheiro, List<Veiculo> vList) throws FileNotFoundException{
        try {
            PrintWriter pw = new PrintWriter(nomeFicheiro);
            pw.println("Coisas");
            pw.println("coisas2");
            for (Aluno a: this.alunos.values()){
                pw.println(a.toStringCSV()); //Devolve linha csv
            }
            pw.flush();
            pw.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Ficheiro invalido!" + e.getMessage());
        }
    }

    //bin

    public void gravaEmFicheiro (String nomeFicheiro) throws FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }


    public static TurmaAlunos leFicheiro (String nomeFicheiro){
        FileInputStream fis = new FileInputStream(nomeFicheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TurmaAlunos r = (TurmaAlunos) ois.readObject();
        ois.close();
        return r;
    }

    
}