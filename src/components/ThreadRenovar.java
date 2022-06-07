package components;

public class ThreadRenovar extends Thread{
    int quant;
    Cliente cliente;
    Livro livro;

    public ThreadRenovar(Cliente cliente, Livro livro){
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
