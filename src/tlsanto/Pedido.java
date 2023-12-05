package tlsanto;

import java.util.Collections;
import java.util.Vector;

public class Pedido extends Comunicado {

    private int[] vet;

    private int elemento;

    public Pedido(int[] vet, int elemento){
        this.vet = vet.clone();
        this.elemento = elemento;
    }

    public boolean encontrarElemento(){
        for(int i=0; i <= this.vet.length; i++){
            if(elemento == vet[i]){
                return true;
            }
        }
        return false;
    }

    public int getElemento(){
        return elemento;
    }


}
