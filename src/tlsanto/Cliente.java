package tlsanto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {

    private Pedido pedido;

    public void run() throws IOException, ClassNotFoundException {

        ServerSocket serverSocket =  new ServerSocket(12345);
        while (true) {
            Socket conexao = serverSocket.accept();

            System.out.println("Connected");

            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());

            Pedido pedido = (Pedido) receptor.readObject();

            System.out.println(receptor.readObject());
            System.out.println(pedido.getElemento());
        }
    }
    public static void main(String []args) throws IOException, ClassNotFoundException {
        new Cliente().run();
    }
}
