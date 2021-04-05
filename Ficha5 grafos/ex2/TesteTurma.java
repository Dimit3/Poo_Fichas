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
 * Classe de Teste para o exemplo da Turma
 * (Ficha 5 exercício 2).
 *
 * @author MaterialPOO
 * @version 20200330 
 */

import java.util.Set;
import java.util.List;

public class TesteTurma {
    public static void main (String[] args) {
      Aluno a1 = new Aluno("1","Ze");
      Aluno a2 = new Aluno("2","Ana");
      Aluno a3 = new Aluno("3","To");
      
      Turma t = new Turma();
      t.setNome("Turma PL POO");
      t.setCodigo("c1");
      
      t.insereAluno(a1);
      t.insereAluno(a2);
      t.insereAluno(a3);
        
      System.out.println("Numero Alunos na turma: " + t.qtsAlunos());
      
      System.out.println("toString da Turma "+ t.getNome());
      System.out.println(t.toString());
      
      System.out.println("Ordem Alfabetica:");
      
      Set<Aluno> res = t.alunosOrdemAlfabeticaStreams();
      for (Aluno a: res) 
          System.out.println(a.toString());
            
      System.out.println("\n\n");
      
      
      System.out.println("Ordem Alfabetica List:");
      
      List<Aluno> resL = t.alunosOrdemAlfabeticaStreamsL();
      for (Aluno a: resL) 
          System.out.println(a.toString());
      
      System.out.println("\n\n");
   
      
      System.out.println("Ordem Numerica:");
      
      System.out.println(t.alunosOrdemDecrescenteNumero());
           
        
    }
}
