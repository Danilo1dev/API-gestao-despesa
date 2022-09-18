package br.com.exactaworks.gestaodespesas.despesa.application.service;

import java.util.UUID;
import javax.validation.Valid;
import br.com.exactaworks.gestaodespesas.despesa.application.api.DespesaRequest;
import br.com.exactaworks.gestaodespesas.despesa.application.api.DespesaResponse;

public interface DespesaService {
	DespesaResponse criaDespesa(UUID idPessoa, @Valid DespesaRequest despesaRequest);
}