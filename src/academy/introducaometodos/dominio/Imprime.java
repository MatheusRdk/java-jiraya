package academy.introducaometodos.dominio;

public class Imprime {


    public void imprime(Estudante estudante){
        System.out.println("---------------------------");

        System.out.println(estudante.nome);
        System.out.println(estudante.idade);
        System.out.println(estudante.sexo);
        estudante.nome = "Gohan";  //Quando vc faz isso, altera o valor original la das variáveis, pois ele pega a referencia do estudante01 por ex., e altera ela. Não é bom fazer isso.
    }
    
}
