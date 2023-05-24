package exception.runtimetest;

public class RuntimeExceptionTest01 {
    public static void main(String[] args) {
        //Checked e Uncheked.

        // ---> Checked é filha direta de Exception, e causa um erro em tempo de compilação. Vc precisa fazer o tratamento.
        // ---> Unchecked sao RuntimeException e filhas de RuntimeException (que e filha de exception tambem). Quase sempre acontece por erro no codigo, acontece em tempo de execução.



        //RuntimeException, vc n precisa fazer a validação para o código compilar. Quando ela acontece, geralmente é um erro de desenvolvimento.
        
        System.out.println("********O codigo é compilado e executado ate aqui*********"); //Perceba que o codigo é compilado e executado, até a parte em que se encontra a runtimeexception
        int [] nums = {1, 2};
        System.out.println(nums[2]); //Nao existe essa posição: ArrayIndexOutofBoundsException(filha de RuntimeException)
    }
}
