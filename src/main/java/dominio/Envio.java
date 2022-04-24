package dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Envio {
    private String codRastreio;
    private String formaEnvio;
    private Double valorFrete;
    private Endereco endereco;
}
