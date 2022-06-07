package components;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Livro implements Comparable<Livro>,Serializable{
    private static final long serialVersionUID = 6539685098267757690L;
    private int cod;
    private String nome;

    public Livro(String nome, int cod){
        this.nome = nome;
        this.cod = cod;
    }
    
    public String getNome(){
        return this.nome;
    }

    @Override
    public int compareTo(Livro o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override 
    public String toString(){
        return "Livro nº"+String.format("%02d", this.cod)+": "+this.nome;
    }

}