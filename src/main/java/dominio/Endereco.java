package dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Endereco {
    private String rua;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
}
