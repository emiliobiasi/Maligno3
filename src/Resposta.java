import java.io.Serializable;

public class Resposta extends Comunicado implements Serializable {
    private Integer resultado;

    // Construtor
    public Resposta(Integer resultado) {
        this.resultado = resultado;
    }

    // Getter para o resultado
    public Integer getResultado() {
        return resultado;
    }
}