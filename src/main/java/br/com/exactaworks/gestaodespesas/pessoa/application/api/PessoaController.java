package br.com.exactaworks.gestaodespesas.pessoa.application.api;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import br.com.exactaworks.gestaodespesas.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
	private final PessoaService pessoaService;

	@Override
	public PessoaResponse postPessoa(@Valid pessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaResponse pessoaCriado = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriado;
	}

	@Override
	public List<PessoaListResponse> getTodasPessoas() {
		log.info("[inicia] PessoaController - getTodasPessoas");
		List<PessoaListResponse> pessoas = pessoaService.buscaTodasPessoas();
		log.info("[finaliza] PessoaController - getTodasPessoas");
		return pessoas;
	}

	@Override
	public PessoaDetalhadoResponse getPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - getPessoaAtravesId");
		log.info("[idPessoa] {}", idPessoa);
		PessoaDetalhadoResponse pessoaDetalhado = pessoaService.buscaPessoaAtravesID(idPessoa);
		log.info("[finaliza] PessoaController - getPessoaAtravesId");	
		return pessoaDetalhado;
	}

	@Override
	public void deletaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - deletaPessoaAtravesId");
		log.info("[idPessoa] {}", idPessoa);
		pessoaService.deletaPessoaAtravesID(idPessoa);
		log.info("[finaliza] PessoaController - deletaPessoaAtravesId");
	}

	@Override
	public void patchAlteraPessoa(UUID idPessoa, @Valid PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		log.info("[inicia] PessoaController - patchAlteraPessoa");
		log.info("[idPessoa] {}", idPessoa);
		pessoaService.patchAlteraPessoa(idPessoa, pessoaAlteracaoRequest);
		log.info("[finaliza] PessoaController - patchAlteraPessoa");
	}
}
