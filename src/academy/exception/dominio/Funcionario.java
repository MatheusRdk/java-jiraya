package academy.exception.dominio;

public class Funcionario extends Pessoa{

    public void salvar() throws LoginInvalidoException {   //Quando vc esta sobreescrevendo um método da classe extendida, vc nao é obrigado a usar as mesmas exceçoes.
        System.out.println("Salvando funcionario");     //Vc pode usar uma das exception de Pessoa, todas, ou adicionar alguma Unchecked.
    }                                                    // Vc NAO pode usar exceçoes mais genéricas ou do tipo checked. Pode usar uma mais específica, ex.: Pessoa tem IOexception e funcionario tem
                                                        //                                                                                                  FileNotFoundException
}
