package br.com.exactaworks.gestaodespesas.pessoa.application.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.exactaworks.gestaodespesas.pessoa.domain.Sexo;
import lombok.Value;

@Value
public class PessoaAlteracaoRequest {
	@NotBlank
	private String nomePessoa;
	@NotBlank
	private String cpf;
	@NotBlank
	private String idade;
	private Sexo sexo;
	@NotBlank
	private String telefone;
	@Email
	private String email;
	@NotNull
	private double renda;
}
