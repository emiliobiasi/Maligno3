import java.io.*;
import java.net.*;

public class Receptor {

    public static void main(String[] args) {
        try {
            // a) Declarar ServerSocket
            ServerSocket pedido = new ServerSocket(12345);

            while (true) {
                // b) Aceitar conexão
                Socket conexao = pedido.accept();
                ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());
                ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());

                // c) Receber Pedido
                Pedido pedidoRecebido = (Pedido) receptor.readObject();

                // d) Processar Pedido
                Integer resultado = pedidoRecebido.getPosicao();

                // e) Enviar Resposta
                Resposta resposta = new Resposta(resultado);
                transmissor.writeObject(resposta);

                // f) Voltar ao passo b

                // g) Thread para verificar o comando "FIM"
                new Thread(() -> {
                    // Implementar lógica para esperar o comando FIM
                    // ...

                    // Encerrar programa
                    System.exit(0);
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}