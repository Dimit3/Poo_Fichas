import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;



public class TurmaAlunos 
{
    private Map<String,Aluno> alunos;
    private String nome;
    private String codigo;


    //b) i

    public TurmaAlunos (){
        this.nome = new String ();
        this.codigo = new String();
        this.alunos = new HashMap<>();  //diamond notation
        //this.alunos = new HashMap<String, Aluno>();
    } 


    public TurmaAlunos (Map<String,Aluno> als, String nome, String codigo ){
        this.nome = nome;
        this.codigo = codigo;
        setAlunos(als);
    } 

    public TurmaAlunos (TurmaAlunos t){
        this.nome = t.getNome ();
        this.codigo = t.getCodigo ();
        setAlunos (t.getAlunos());
    }

    public String getNome () {
        return this.nome;
    }

    public String getCodigo () {
        return this.codigo;
    }

    public Map<String, Aluno> getAlunos () {
        Map<String, Aluno>  ret = new HashMap<>(); 
        for (Map.Entry<String,Aluno> e : this.alunos.entrySet()){
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public void setCodigo (String codigo){
        this.codigo = codigo;
    }

    public void setAlunos (Map<String,Aluno> als){
        this.alunos = new HashMap<>();
        als.entrySet().forEach(e -> this.alunos.put(e.getKey(), e.getValue().clone()));

    }
    
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma: \n").append(this.nome).append("\n")
                            .append(this.codigo).append("\n")
                            .append(this.alunos).append("\n");
        return sb.toString();
    }

    public boolean equals (Object o){
        if (o==this) return true;
        if (o==null || o.getClass() != this.getClass()) return false;
        TurmaAlunos t = (TurmaAlunos) o;

        return this.nome.equals(t.getNome()) && 
                this.codigo.equals(t.getCodigo()) &&
                this.alunos.equals(t.getAlunos());

    }

    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }

    public int compareTo (TurmaAlunos t){
        return this.nome.compareTo(t.getNome());
    }

    //ii)
    public void insereAluno (Aluno a){
        this.alunos.put(a.getNumero(), a.clone());
    }

    //iii)

    public Aluno getAluno (String codAluno){
        return this.alunos.get(codAluno).clone();
    }

    //iv)

    public void removeAluno (String codAluno){
        this.alunos.remove(codAluno);
    }

    //v)

    public Set<String> todosOsCodigos(){
        //return this.alunos.keySet(); retorna parte da estrutura nao pode
        return new TreeSet<>(this.alunos.keySet());
    }
    //vi)
    public int qtsAlunos() {
        return this.alunos.size();
    }

    //vii)
    public Set<Aluno> alunosOrdemAlfabetica(){
        return this.alunos.values().stream()
                                    .map(Aluno::clone)
                                    .collect(Collectors.toCollection(TreeSet::new));
    }



    public Set<Aluno> alunosOrdemAlfabeticaExterno(){
        Set<Aluno> ret = new TreeSet<>();
        for (Aluno a: this.alunos.values()){
            ret.add(a.clone());
        }
        return ret;
    }


    //viii)

    public Set<Aluno> alunosOrdemDescrescenteNumero(){
        Set<Aluno> ret = new TreeSet<>(new ComparatorAlunoNumero());
        for (Aluno a: this.alunos.values()){
            ret.add(a.clone());
        }
        return ret;
    }












}