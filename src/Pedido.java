import java.io.Serializable;

public class Pedido extends Comunicado implements Serializable {
    private int[] vetor;
    private int numero;

    // Construtor
    public Pedido(int[] vetor, int numero) {
        this.vetor = vetor;
        this.numero = numero;
    }

    // Getter
    public Integer getPosicao() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                return i; // Retorna a posição onde o número foi encontrado
            }
        }
        return null; // Retorna null se o número não foi encontrado
    }
}