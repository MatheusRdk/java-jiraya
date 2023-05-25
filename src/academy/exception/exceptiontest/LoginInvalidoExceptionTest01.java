package academy.exception.exceptiontest;

import java.util.Scanner;

import academy.exception.dominio.LoginInvalidoException;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try{
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    public static void logar() throws LoginInvalidoException {
        try (Scanner teclado = new Scanner(System.in)) {
            String usernameDB = "Goku";
            String senhaDB = "ssj";
            System.out.println("Digite seu usuário: ");
            String usernameDigitado = teclado.nextLine();
            System.out.println("Sua senha: ");
            String senhaDigitada = teclado.nextLine();
            if (!usernameDB.equals(usernameDigitado) || !senhaDB.equals(senhaDigitada)){
                throw new LoginInvalidoException("Usuário ou senha inválidos");
            }
        }
        System.out.println("Usuário logado com sucesso!");
    }
}
