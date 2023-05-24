package serializacao.test;

import serializacao.dominio.Aluno;
import serializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1L, "Matheus Rudekkkk", "123456");
        Turma turma = new Turma("Turma braba"); //Agora sim vc vai serializar um objeto turma. O problema é que turma nao é serializavel.
        aluno.setTurma(turma);
        serializar(aluno);
        deserializar(); //Ele lê o arquivo.
    }

    private static void serializar(Aluno aluno){ //Serializaçao é salvar o estado do arquivo, em baixo nível (array de bytes). Geralmente, baixo nível significa usar os Stream.
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(aluno);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void deserializar(){ //Deserialização nao recebe nada, faz um output do arquivo serializado. O que é deserializado é o OBJETO.
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
