package br.com.exactaworks.gestaodespesas.despesa.application.service;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import br.com.exactaworks.gestaodespesas.despesa.application.api.DespesaAlteracaoRequest;
import br.com.exactaworks.gestaodespesas.despesa.application.api.DespesaDaPessoaListResponse;
import br.com.exactaworks.gestaodespesas.despesa.application.api.DespesaDetalhadoResponse;
import br.com.exactaworks.gestaodespesas.despesa.application.api.DespesaRequest;
import br.com.exactaworks.gestaodespesas.despesa.application.api.DespesaResponse;
import br.com.exactaworks.gestaodespesas.despesa.application.repository.DespesaRepository;
import br.com.exactaworks.gestaodespesas.despesa.domain.Despesa;
import br.com.exactaworks.gestaodespesas.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.exactaworks.gestaodespesas.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class DespesaApplicationService implements DespesaService {
	private final PessoaService pessoaService;
	private final DespesaRepository despesaRepository;
	
	@Override
	public DespesaResponse criaDespesa(UUID idPessoa, @Valid DespesaRequest despesaRequest) {
		log.info("[inicia] DespesaApplicationService - criaDespesa");
		pessoaService.buscaPessoaAtravesID(idPessoa);
		Despesa despesa = despesaRepository.salvaDespesa(new Despesa(idPessoa, despesaRequest));
		log.info("[finaliza] DespesaApplicationService - criaDespesa");
		return new DespesaResponse(despesa.getIdDespesa());
	}

	@Override
	public List<DespesaDaPessoaListResponse> buscaDespesaDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] DespesaApplicationService - buscaDespesaDaPessoaComId");
		List<Despesa> despesaDaPessoa = despesaRepository.buscaDespesaDaPessoaComId(idPessoa);
		log.info("[finaliza] DespesaApplicationService - buscaDespesaDaPessoaComId");
		return DespesaDaPessoaListResponse.converte(despesaDaPessoa);
	}

	@Override
	public DespesaDetalhadoResponse buscaDespesaDaPessoaComId(UUID idPessoa, UUID idDespesa) {
		log.info("[inicia] DespesaApplicationService - buscaDespesaDaPessoaComId");
		PessoaDetalhadoResponse pessoaAtravesID = pessoaService.buscaPessoaAtravesID(idPessoa);
		Despesa despesa = despesaRepository.buscaDespesaPeloId(idDespesa);
		log.info("[finaliza] DespesaApplicationService - buscaDespesaDaPessoaComId");
		return new DespesaDetalhadoResponse(despesa,pessoaAtravesID);
	}

	@Override
	public void deletaDespesaDaPessoaComId(UUID idPessoa, UUID idDespesa) {
		log.info("[inicia] DespesaApplicationService - deletaDespesaDaPessoaComId");
		pessoaService.buscaPessoaAtravesID(idPessoa);
		Despesa despesa = despesaRepository.buscaDespesaPeloId(idDespesa);
		despesaRepository.deletaDespesaId(despesa);
		log.info("[finaliza] DespesaApplicationService - deletaDespesaDaPessoaComId");
	}

	@Override
	public void alteraDespesaDaPessoaComId(UUID idPessoa, UUID idDespesa,
			@Valid DespesaAlteracaoRequest despesaAlteracaoRequest) {
		log.info("[inicia] DespesaApplicationService - alteraDespesaDaPessoaComId");
		pessoaService.buscaPessoaAtravesID(idPessoa);
		Despesa despesa = despesaRepository.buscaDespesaPeloId(idDespesa);
		despesa.altera(despesaAlteracaoRequest);
		despesaRepository.salvaDespesa(despesa);
		log.info("[finaliza] DespesaApplicationService - alteraDespesaDaPessoaComId");
	}
}
