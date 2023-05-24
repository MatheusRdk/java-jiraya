package exception.runtimetest;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        try{ //Nunca pode criar um try sozinho. Tem q ser try catch ou try finally. Quase nunca é usado try finally.
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
            throw new RuntimeException();
            //System.out.println("Fechando recurso liberado pelo SO"); coloca essa parte no finally
        } catch (Exception e){
            e.printStackTrace();
        } finally{ //Finally é um bloco que sempre vai ser executado. Por exemplo, se na parte de escrever dados no arquivo ocorre uma exceçao, a parte seguinte que fecharia o recurso nao vai acontecer
                   // e recursos podem ser desperdiçados. O bloco finally vai ser responsável por fechar.
            System.out.println("Fechando recurso liberado pelo SO"); //Veja que mesmo ocorrendo uma exceçao la em cima, esse bloco ainda foi executado.
        }
    }
}
