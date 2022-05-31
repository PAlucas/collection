package components;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Cliente implements Comparable<Cliente>{ 
    private int cod;
    private String nome;
    private ArrayList<Livro> livro;

    public Cliente(String nome, int cod){
        this.nome = nome;
        this.cod = cod;
        this.livro = new ArrayList<>();
    }

    public void alugarLivro(Livro novo){
        this.livro.add(novo);
    }

    public ArrayList<Livro> show(){
        return this.livro;
    }

    public String getNome(){
        return this.nome;
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

}
