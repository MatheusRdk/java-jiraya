package academy.enumeracao.dominio;

public class Cliente {

//  public enum TipoCliente { // Vc pode criar um enum dentro da propria classe. Mas nao e o melhor jeito
       // PESSOA_FISICA,
        // PESSOA_JURIDICA

    private String nome;
    private TipoCliente tipoCliente;
    private TipoPagamento tipoPagamento;
    
    public Cliente(String nome, TipoCliente tipoCliente, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", tipoCliente=" + tipoCliente.getNomeRelatorio() + ", tipoClienteInt=" + tipoCliente.VALOR + ", tipoPagamento=" + tipoPagamento + "]";
    }

    
    
}
