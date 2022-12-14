package br.com.exactaworks.gestaodespesas.despesa.application.api;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pessoa/{idPessoa}/despesa")
public interface DespesaAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	DespesaResponse postDespesa(@PathVariable UUID idPessoa, @Valid @RequestBody DespesaRequest despesaRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<DespesaDaPessoaListResponse> getDepesaDaPessoaComId(@PathVariable UUID idPessoa);
	
	@GetMapping(value = "/{idDespesa}")
	@ResponseStatus(code = HttpStatus.OK)
	DespesaDetalhadoResponse getDespesaAtravesId(@PathVariable UUID idPessa, @PathVariable UUID idDespesa);
	
	@DeleteMapping(value = "/{idDespesa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaDespasDaPessoaComId(@PathVariable UUID idPessoa, @PathVariable UUID idDespesa);
	
	@PatchMapping(value = "/{idDespesa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchDespesa(@PathVariable UUID idPessoa,@PathVariable UUID idDespesa,
			@Valid @RequestBody DespesaAlteracaoRequest despesaAlteracaoRequest);
}
