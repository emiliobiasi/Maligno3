import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.Vector;

public class Distribuidor {

    public static void main(String[] args) {
        try {
            String[] vet = {"172.16.21.133", "172.16.21.136"};

            // b) Preencher vetor imenso de int
            int tamVetor = 100;
            System.out.println("Tamanho do Vetor: " + tamVetor);

            Vector<Integer> vetorGigante = new Vector<>(tamVetor);
            for (int i = 0; i < tamVetor; i++) {
                vetorGigante.add(i);
            }
            //Collections.shuffle(vetorGigante);


            // f) Separar vet.length pedaços de vet
            Pedido[] pedidos = new Pedido[vet.length];


            // g) Estabelecer vet.length conexões
            for (int i = 0; i < vet.length; i++) {
                Socket socket = new Socket(vet[i], 33377);
                System.out.println("Conectado: " + socket);
                ObjectOutputStream transmissor = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream receptor = new ObjectInputStream(socket.getInputStream());

                // h) Enviar Pedido
                transmissor.writeObject(pedidos[i]);

                // i) Receber Resposta
                Resposta resposta = (Resposta) receptor.readObject();

                // j) Verificar e imprimir
                if (resposta.getResultado() != null) {
                    System.out.println("Número encontrado na posição: " + resposta.getResultado());
                } else {
                    System.out.println("Número não encontrado");
                }

                // k) Fechar conexão
                transmissor.close();
                receptor.close();
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}