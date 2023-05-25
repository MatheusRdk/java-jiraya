package academy.enumeracao.dominio;

public enum TipoCliente { //Isso e uma enumeracao, nao precisa colocar mais nada, so os valores que ficarao disponiveis.
    PESSOA_FISICA(1, "Pessoa Física"), //Esses valores sao como constantes, estaticos e finais.
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    public final int VALOR; //Faz final para nao poder ser alterado. Faz public para ser colocado uma vez e nao poder mais ser alterado. Ou pode fazer private e usar um get
    private String nomeRelatorio;

    TipoCliente(int valor, String nomeRelatorio){ //Esse construtor faz com que quando vc escolha uma das opcoes do enum la de cima, esse valor vai ser atribuido conforme a opçao ali de cima tambem.
        this.nomeRelatorio = nomeRelatorio;
        this.VALOR = valor;
    }

    
    public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio){ //Esse metodo busca o nome do enum, por meio de uma string que e um atributo, caso precise saber o nome.
        for (TipoCliente client : values()){
            if (client.getNomeRelatorio().equals(nomeRelatorio)) {
                return client;
            }
        }
        return null;
    }


    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

}
