package dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "senha")
@AllArgsConstructor
public abstract class Pessoa {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
}
