
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import components.Cliente;
import components.Emprestimo;
import components.Livro;
import components.ThreadEmprestar;

public class App {
    static String nomeArq1 = "clientes.txt";
    static String nomeArq2 = "livros.txt";
    static String nomeArq3 = "guardarCliente.ser";
    

    public static List<Cliente> carregarCliente(String nomeArq) throws IOException {
        Scanner total =  new Scanner(new File(nomeArq));
        List<Cliente>  unidades = new ArrayList<>();
        while(total.hasNextLine()){
            String cliente = total.nextLine();
            String[] infoCliente = cliente.split(";");
            Cliente novo = new Cliente(infoCliente[1], Integer.parseInt(infoCliente[0]));
            unidades.add(novo);
        }

        total.close();
        return unidades;
    }

    public static List<Livro> carregarLivro(String nomeArq) throws IOException {
        Scanner total =  new Scanner(new File(nomeArq));
        List<Livro>  unidades = new ArrayList<>();
        while(total.hasNextLine()){
            String livro = total.nextLine();
            String[] infoLivro = livro.split(";");
            Livro novo = new Livro(infoLivro[1], Integer.parseInt(infoLivro[0]));
            unidades.add(novo);
        }

        total.close();
        return unidades;
    }

    public static void gravadorObjeto(List<?extends Serializable> serializables, String nomeArquivo) throws IOException{
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Serializable s: serializables) {
            oos.writeObject(s);
        }
        oos.close();
        
    }

    public static List<?extends Serializable> LeitorObjeto(String nomeArquivo) throws IOException{
        FileInputStream fos = new FileInputStream(nomeArquivo);
        ObjectInputStream oos = new ObjectInputStream(fos);
        List<Serializable> objeto = new ArrayList<>();
        try {
            while(true){
                Serializable obj = (Serializable) oos.readObject();
                objeto.add(obj);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(EOFException e) {
            
        }
        
        return objeto;
        
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String cliente = "";
        String livro = "";
        String terminarPrograma;
        List<Cliente> todosOsClientes = new ArrayList<>(carregarCliente(nomeArq1));
        List<Livro> todosOsLivros = new ArrayList<>(carregarLivro(nomeArq2));
        List<? extends Serializable> serie = LeitorObjeto(nomeArq3);
        List<Emprestimo> emprestimos = (List<Emprestimo>)LeitorObjeto("guardarEmprestimos.ser");
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Ver arquivo\n");
            System.out.println(emprestimos);
            System.out.print("Emprestar Livros\n");
            System.out.print("Nome cliente : ");
            cliente = scanner.nextLine();
            System.out.print("Nome livro : ");
            livro = scanner.nextLine();
    
            Cliente clienteAux = null;
            Livro livroAux = null;
            for(Cliente c : todosOsClientes) {
                if(c.getNome().equals(cliente)){
                    clienteAux = c;
                }
            }
            for (Livro l : todosOsLivros) {
                if(l.getNome().equals(livro)){
                    livroAux = l;
                }
            }
            if(clienteAux != null && livroAux != null){
                new ThreadEmprestar(clienteAux, livroAux).start();
                gravadorObjeto(todosOsClientes, "guardarCliente.ser");
                gravadorObjeto(clienteAux.getEmprestimo(), "guardarEmprestimos.ser");
            } else {
                System.out.print("Cliente ou livro n�o encontrado");
            }
            System.out.println("Continuar com o programa ?");
            terminarPrograma = scanner.nextLine();
        }while(terminarPrograma.equals("sim"));

    }
    
}
