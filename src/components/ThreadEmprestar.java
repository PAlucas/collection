package components;

import java.io.FileWriter;
import java.io.PrintWriter; 
import java.io.IOException;
import java.util.Random;

public class ThreadEmprestar extends Thread{
    int quant;
    Cliente cliente;
    Livro livro;

    public ThreadEmprestar(Cliente cliente, Livro livro){
        this.cliente = cliente;
        this.livro = livro;
    } 
  

    @Override
    /**
     * Execução: geração do vetor e sua ordenação em seguida
     */
    public void run(){
     this.cliente.alugarLivro(this.livro);
    }  
}
