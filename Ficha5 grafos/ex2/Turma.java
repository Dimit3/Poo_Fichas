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


/**
 * Classe Turma de Alunos (Ficha 5 exercício 2).
 * Turma contém um Map de Alunos.
 *
 * @author MaterialPOO
 * @version 20200331
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.List;

public class Turma {
    private String nome;
    private String codigo;
    private Map<String, Aluno> alunos;
    
    
    public Turma(){ 
      this.nome = new String();
      this.codigo = new String();
      this.alunos = new HashMap<>(); //decidimos que a implementação é HashMap
    }
    
    public Turma(String nome, String codUc, Map<String,Aluno> als) {
      this.nome = nome;
      this.codigo = codUc;
      //Solução errada em termos de encapsulamento.
      //this.alunos = als; // estou a partilhar o apontador dos alunos, mas tb o apontador 
      //                   // do map!!
      //composição
      //this.alunos = new HashMap();
      //for(Aluno a: als)
      //  alunos.put(a.getNumero(),a,clone());
      setAlunos(als);  
    }
      
    public Turma(Turma t) { 
      this.nome = t.getNome();
      this.codigo = t.getCodigo();
      this.alunos = t.getAlunos();
    }
    
    
    public String getNome() {return this.nome;}
    public String getCodigo() {return this.codigo;}
    
    /**
     * Este método é feito numa lógica de associação por
     * composição. Devolve um Map com cópias dos objectos
     * Aluno.
     */
    
    public Map<String,Aluno> getAlunos() {
      Map<String, Aluno> res =  new HashMap<>();
      //1) iterador externo e percorrendo os values()
      //for(Aluno a: this.alunos.values()) // values() devolve uma Collection<Aluno>
      //  res.put(a.getNumero(),a.clone()); 
      //return res;
      
      //2) iterador externo e utilizando entrySet
      for(Map.Entry<String,Aluno> entry: this.alunos.entrySet()) 
         res.put(entry.getKey(),entry.getValue().clone());
      return res;
      
      //3) utilizando streams e construindo um Map
      //public Map<String, Aluno> getAlunos() {
      //  return this.alunos.values().stream().collect(Collectors.toMap(Aluno::getNumero,Aluno::clone));
      //}
    
      //4) utilizando stream sobre o entrySet
      //public Map<String, Aluno> getAlunos() {
      //  return this.alunos.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone()));
      //}
      
      
    }
    
    public void setNome(String nome) {this.nome = nome;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    
    public void setAlunos(Map<String,Aluno> als) {
      this.alunos = new HashMap<>();
      als.values().forEach(a -> this.alunos.put(a.getNumero(),a.clone()));
      //1) ou iterador externo a percorrer os values()
      //for(Aluno a: als.values())
      //  this.alunos.put(a.getNumero(),a.clone());
      
      //2) exemplo de iterador interno com recurso a entrySet
      //this.alunos = new HashMap<>();
      //als.entrySet().forEach( e -> { this.alunos.put(e.getKey(),e.getValue().clone()); });
        
    }
    
    // ii)
    public void insereAluno(Aluno a) {
      this.alunos.put(a.getNumero(),a.clone());
    }
    
    // iii) //depois temos de pensar como fazer qd a chave não existir
    public Aluno getAluno(String codAluno) {
      
      // if (this.alunos.containsKey(codAluno)
      return this.alunos.get(codAluno).clone();
      
      /**
       * IMPORTANTE: Receita de como não fazer para ir buscar um
       * elemento a um Map. Se temos a chave não faz sentido iterar até encontrar.
       * for(Aluno a: this.alunos.values())
       *  if (a.getNumero().equals(codAluno))
       *     res = this.alunos.get(codAluno).clone();
       * return res; 
       */
      
    }
    
    // iv) temos de testar se codAluno existe e se não devolver um erro!!
    public void removeAluno(String codAluno) {
      this.alunos.remove(codAluno);
    }    
    
    // v)
    public Set<String> todosOsCodigos() {
      return new TreeSet(this.alunos.keySet());
      
      /**
       * NOTA: se devolvermos o resultado de this.alunos.keySet() será possível
       * destruir o map alunos (variável de instância da turma).
       * 
       * A título de exemplo façam o método com apenas
       *    return this.alunos.keySet();
       *    
       *    
       * E numa classe de teste façam:
       * 
       * Turma t = new Turma();
       * ...
       * Set<String> codigos = t.todosOsCodigos();
       * codigos.clear();
       * 
       * System.out.println(t.qtsAlunos());
       * 
       * Vejam o resultado e depois alterem o método para a versão que está acima 
       * (não comentada) e verifiquem novamente o resultado.
       */
      
    }

    
    // vi)
    
    public int qtsAlunos() {
      return this.alunos.size(); 
    }
        
    // vii)
    public Set<Aluno> alunosOrdemAlfabetica() {
      Set<Aluno> res = new TreeSet<>();
      for(Aluno a: this.alunos.values())
        res.add(a.clone()); // o add de conjunto vai utilizar a ordem natural de Aluno
      return res;  
    }
    
    public Set<Aluno> alunosOrdemAlfabeticaStreams() {
      return this.alunos.values().stream()
                                 .map(Aluno::clone)
                                 .collect(Collectors.toCollection(TreeSet::new));
      
    }
    
    
    /**
     * Método similar ao anterior, mas devolve um List<Aluno> em vez de 
     * um Set.
     * Recorre ao método sorted() das streams, que não tendo nenhum comparador como
     * parâmetro ordena pelo método de ordem natural.
     */
    public List<Aluno> alunosOrdemAlfabeticaStreamsL() {
      return this.alunos.values().stream()
                                 .sorted()
                                 .map(Aluno::clone)
                                 .collect(Collectors.toList());
      
    }
    
    
    // viii
    public Set<Aluno> alunosOrdemDecrescenteNumero() {
      TreeSet<Aluno> res = new TreeSet<>(new ComparatorAlunoNumero());
      for (Aluno a: this.alunos.values())
         res.add(a.clone());
      return res;   
        
    }    
    
    
    /**
     * Alternativas:
     * 
     * public Set<Aluno> alunosOrdemDecrescenteNumero() { 
     *   return this.alunos.values().stream()
     *                     .map(Aluno::clone)
     *                     .collect(Collectors.toCollection(() -> new TreeSet<Aluno>(new ComparatorAlunoNumero())));
     * }
     *
     * ou, caso não se pretenda escrever uma classe Comparator para ordenar pelo 
     * número de aluno:
     * 
     * public Set<Aluno> alunosOrdemDecrescenteNumero() { 
     *   return this.alunos.values().stream()
     *                     .map(Aluno::clone)
     *                     .collect(Collectors.toCollection(() -> new TreeSet<Aluno>(new ComparatorAlunoNumero())));
     * }
     * 
     */
    
    
    /**
     * Implementação do método toString da classe Turma.
     */
    public String toString() { 
      StringBuilder sb = new StringBuilder();
      sb.append("Turma:\n").append(this.nome).append("\n")
                           .append(this.codigo).append("\n")
                           .append(this.alunos);
      return sb.toString();
    }
    
    public boolean equals (Object o) { 
      if (o == this) return true;
      if (o == null || o.getClass() != this.getClass()) return false;
      Turma t = (Turma) o;
      return this.nome.equals(t.getNome()) &&
             this.codigo.equals(t.getCodigo()) &&
             this.alunos.equals(t.getAlunos());
    }
    
    public Turma clone() {
      return new Turma(this); 
    }
    
    // rever este compareTo para ser mais realista.
    // Neste momento a ordem natural das turmas é apenas pelo nome da turma.
    public int compareTo(Turma a) {  
      return this.nome.compareTo(a.getNome());
    }
    
    
}
