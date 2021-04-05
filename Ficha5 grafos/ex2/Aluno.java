/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/
 
 
public class Aluno implements Comparable<Aluno>
{
    private String numero;
    private String nome;
   
   
    public Aluno()
    { this.numero = new String();
      this.nome = new String();
    }
   
    public Aluno (String num, String nom)
    { this.numero = num;
      this.nome = nom;
    }
   
    public Aluno (Aluno al)
    { this.numero = al.getNumero();
      this.nome = al.getNome();
    }  
   
    public String getNome()
    { return this.nome; }
   
    public String getNumero()
    { return this.numero; }
   
   
    public String toString()
    { StringBuilder sb = new StringBuilder();
      sb.append("Aluno: ").append(this.numero).append(" , ")
                          .append(this.nome).append("\n");
      return sb.toString();
    }
   
    public boolean equals (Object o)
    { if (o == this) return true;
      if (o == null || o.getClass() != this.getClass()) return false;
      Aluno a = (Aluno) o;
      return this.numero.equals(a.getNumero()) &&
             this.nome.equals(a.getNome());
    }
   
    public Aluno clone()
    { return new Aluno(this); }
   
    public int compareTo(Aluno a)
    { return this.nome.compareTo(a.getNome());
    }
     
}