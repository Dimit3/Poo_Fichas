package send;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.stream.Collector;

public class FBPost implements Comparable<FBPost> {

    private int identificador;
    private String nome;
    private LocalDateTime time;
    private String post;
    private int likes;
    private List<String> comments;
    


    //Construtores
    public FBPost() {
        this.identificador = 0;
        this.nome = "NULL";
        this.time = LocalDateTime.now();
        this.post = "NULL";
        this.likes = 0;
        this.comments = new ArrayList<String>();  
    }

    public FBPost(int identificador, String nome, LocalDateTime time, String post, int likes, List<String> comments1) {
        this.identificador = identificador;
        this.nome = nome;
        this.time = time;
        this.post = post;
        this.likes = likes; 
        List <String> aux = new ArrayList<>();
        for (String c : comments1){
            aux.add(c);
        }
        this.comments = aux;
    }


    public FBPost(FBPost p){
        this.identificador = p.getIdentificador();
        this.nome = p.getNome();
        this.time = p.getTime();
        this.post = p.getPost();
        this.likes = p.getLikes();
        this.comments = p.getComments();
    }


    //getters
    public int getIdentificador() {
        return this.identificador;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public String getPost() {
        return this.post;
    }

    public int getLikes() {
        return this.likes;
    }

    public List<String> getComments() {
        List <String> aux = new ArrayList<>();
        for (String c : this.comments){
            aux.add(c);
        }
        return aux;
    }



    //setters
   
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }   
   
    public void setNome(String nome) {
        this.nome = nome;
    }    
    
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
      
    public void setPost(String post) {
        this.post = post;
    }


    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComents(List<String> comment) {
        this.comments = new ArrayList<String>();
        for (String c : comment){
            this.comments.add(c);
        }
    }

    public void addComment(String comment){
        this.comments.add(comment);
    }

    public int getCommentsSize(){
        return this.comments.size();
    }

    public void addLike (){
        this.likes++;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FBPost)) {
            return false;
        }
        FBPost fb = (FBPost) o;
        return identificador == fb.getIdentificador() && 
        this.nome.equals(fb.getNome()) && 
        fb.getTime().equals(this.time) &&
        fb.getPost().equals(this.post) &&
        likes == fb.getLikes() &&
        fb.comments.equals(this.comments); 
    
    }


    public String toString() {
        String out ="";
        Iterator<String> it = comments.iterator();
        String aux ="";
        while(it.hasNext()){
            aux = it.next();
            out += aux + "\n";
        }
        
        
        return "{" +
            " identificador='" + getIdentificador() + "'" +
            ", nome='" + getNome() + "'" +
            ", time='" + getTime() + "'" +
            ", post='" + getPost() + "'" +
            ", likes='" + getLikes() + "'" +
            ", \ncoments=\n'" + out + "'" +
            "}";
    }
    

    public FBPost clone() {
        return new FBPost(this);
    }



    public int compareTo(FBPost p){
        if(this.comments.size()>=p.getCommentsSize()){
            return 1;
        }
        return -1;
        
    }


}