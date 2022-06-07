package components;

import java.io.Serializable;
import java.time.LocalDate;

public class Emprestimo implements Serializable{
    private static final long serialVersionUID = 6529685098567757690L;
    private Livro livro;
    private LocalDate data;
    private LocalDate devolucaoData;
    private StatusEmprestimo status;

    public Emprestimo(Livro livro){
        this.livro = livro;
        this.data = LocalDate.now();
        this.devolucaoData = this.data.plusDays(7);
        this.status = StatusEmprestimo.ALUGADO;
    }

    public void devolver(){
        this.status = StatusEmprestimo.DISPONIVEL;
    }

    public void revovar(){
        this.devolucaoData = this.devolucaoData.plusDays(7);
    }

    public Livro getLivro(){
        return this.livro;
    }

    @Override 
    public String toString(){
        return "Cliente do livro"+this.livro.getNome()+": "+this.data+"até"+this.devolucaoData;
    }
}
