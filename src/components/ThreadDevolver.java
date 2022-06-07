package components;

public class ThreadDevolver extends Thread{
    int quant;
    Cliente cliente;
    Livro livro;

    public ThreadDevolver(Cliente cliente, Livro livro){
        this.cliente = cliente;
        this.livro = livro;
    } 
  

    @Override
    /**
     * Execução: geração do vetor e sua ordenação em seguida
     */
    public void run(){
     this.cliente.devolverLivro(this.livro);
    }  
}
