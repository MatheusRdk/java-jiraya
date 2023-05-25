package academy.exception.dominio;

public class LoginInvalidoException extends Exception {   //Exception customizada. Se vc quer que ela seja obrigatoriamente tratada pelo usuario, extende Exception para ser Checked. 
                                                          //                       Se vc quer que nao seja obrigatoriamente tratada pelo usuario, extende RuntimeException para ser unchecked.
    public LoginInvalidoException(){ //Construtor
        super("Login invalido");
    }    //Esse construtor sem nada é para jogar no super com uma mensagem padrao, para caso quem usar essa exception nao colocar nenhuma mensagem


    public LoginInvalidoException(String message){ 
        super(message); //Já esse joga no construtor da superclasse com uma mensagem definida pelo usuario.
    }
}
