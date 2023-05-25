package academy.enumeracao.dominio;

public enum TipoPagamento {   //Dessa forma fazemos um override do metodo definido fora do enum, para ele ser usado conforme a opção do enum.
    DEBITO {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.1;
        }
    },
    CREDITO {

        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.05;
        }
        
    };

    public abstract double calcularDesconto(double valor); //O abstract diz que o metodo nao existe, o que existe é a implementacao do override la de cima
}
