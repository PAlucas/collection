
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import components.Cliente;
import components.Livro;
import components.ThreadSort;

public class App {
    static String nomeArq1 = "clientes.txt";
    static String nomeArq2 = "livros.txt";
    static String nomeArq3 = "olhar.txt";
    

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

    public static void gravadorObjeto(List<Livro> livros) throws IOException{
        FileOutputStream fos = new FileOutputStream("guardarCliente.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Livro livro : livros) {
            oos.writeObject(livro);
        }
        oos.close();
        
    }

    public static List<Livro> LeitorObjeto() throws IOException{
        FileInputStream fos = new FileInputStream("guardarCliente.ser");
        ObjectInputStream oos = new ObjectInputStream(fos);
        List<Livro> livros = new ArrayList<>();
        try {
            for(;;){
                livros.add((Livro)oos.readObject());
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return livros;
        
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Cliente> todosOsClientes = new ArrayList<>(carregarCliente(nomeArq1));
        List<Livro> todosOsLivros = new ArrayList<>(carregarLivro(nomeArq2));
        
        gravadorObjeto(todosOsLivros);

        System.out.print(LeitorObjeto());
            

        long tempoInicial = System.currentTimeMillis();  
        long tempoFinal = System.currentTimeMillis();  
        System.out.print(tempoFinal-tempoInicial);




    }
    
}
