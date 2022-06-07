package components;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Cliente implements Comparable<Cliente>, Serializable{ 
    
    private int cod;
    private String nome;
    private List<Emprestimo> emprestimo;

    public Cliente(String nome, int cod){
        this.nome = nome;
        this.cod = cod;
        this.emprestimo = new ArrayList<>();
    }

    public void alugarLivro(Livro novo){
        this.emprestimo.add(new Emprestimo(novo));
    }

    public void devolverLivro(Livro remover){
        for (Emprestimo e : emprestimo) {
            if(e.getLivro().equals(remover)){
                e.devolver();
            }
        }
    }

    public void renovarLivro(Livro renovar){
        for (Emprestimo e : emprestimo) {
            if(e.getLivro().equals(renovar)){
                e.revovar();
            }
        }
    }

    public String getNome(){
        return this.nome;
    }

    public List<Emprestimo> getEmprestimo(){
        return this.emprestimo;
    }
    
    @Override
    public int compareTo(Cliente o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override 
    public String toString(){
        return "Cliente nº"+String.format("%02d", this.cod)+": "+this.nome;
    }

    public Object getNomeDeUsuario() {
        return null;
    }

}
