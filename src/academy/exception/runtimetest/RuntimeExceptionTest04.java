package academy.exception.runtimetest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {
    public static void main(String[] args) {
        try{
            throw new IllegalArgumentException();

            
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e){
            System.out.println("Dentro do IndexOutOfBoundsException");
        } catch (IllegalArgumentException e){
            System.out.println("Dentro do IllegalArgumentException");
        } catch (ArithmeticException e){
            System.out.println("Dentro do ArithmeticException");
        } catch (RuntimeException e){
            System.out.println("Dentro do RuntimeException");   //Exception mais genéricas sempre tem que vir no final. Pois se ela for a primeira, os outros códigos nunca serão executados, já que o 
                                                                  // RuntimeException é a superclasse de todas elas, abrange todas.
        }

        try {
            talvezLanceException();
        } catch (SQLException e){     //Ou em vez de usar os dois catchs, vc usa um  catch (Exception e), que capturaria qualquer exception.

        } catch (IOException e) { //Em vez de capturar diretamente o FileNotFoundException vc pode usar o IOException que é a exceçao mais genérica.

        }


        //Outra sintaxe para pegar várias exceçoes juntas

        try {
            throw new ArithmeticException();           //Vc pode pegar varias juntas desde que nao sejam da mesma linha de herança, como FileNotFoundException e IOException.
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e){
            System.out.println("Dentro do ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException");
        }   
    }



    private static void talvezLanceException() throws SQLException, FileNotFoundException{

    }
}
