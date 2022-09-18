package br.com.exactaworks.gestaodespesas.despesa.application.api;

import java.time.LocalDate;
import java.util.UUID;
import br.com.exactaworks.gestaodespesas.despesa.domain.Despesa;
import br.com.exactaworks.gestaodespesas.despesa.domain.TipoDespesa;
import lombok.Value;

@Value
public class DespesaDetalhadoResponse {
	private UUID idPessoa;
	private UUID idDespesa;
	private String descricao;
	private Double valorDespesa;
	private TipoDespesa tipoDespesa;
	private LocalDate dataDaDespesa;

	public DespesaDetalhadoResponse(Despesa despesa) {
		this.idPessoa = despesa.getIdPessoaCadastrada();
		this.idDespesa = despesa.getIdDespesa();
		this.descricao = despesa.getDescricao();
		this.valorDespesa = despesa.getValorDespesa();
		this.tipoDespesa = despesa.getTipoDespesa();
		this.dataDaDespesa = despesa.getDataDaDespesa();
	}
}

