package components;

import java.io.FileWriter;
import java.io.PrintWriter; 
import java.io.IOException;
import java.util.Random;

public class ThreadSort extends Thread{
    private int[] vet;
    int quant;

    public ThreadSort(int quant, int[] vetor){
        this.quant = quant;
        this.vet = vetor;
    } 
  
     public void ordenar(){
        for(int i = 0; i<vet.length; i++){     //ORDENAÇÃO POR SELEÇÃO
           int menor = i;
           for(int j = i+1; j<vet.length; j++){
              if(vet[j]<vet[menor]) menor = j;
           }
           int aux = vet[menor];
           vet[menor] = vet[i];
           vet[i] = aux;
          
        }
    }

    @Override
    /**
     * Execução: geração do vetor e sua ordenação em seguida
     */
    public void run(){
       vet = this.vet;
       ordenar(); 
       System.out.print("vetor ordenado");
    }  
}
