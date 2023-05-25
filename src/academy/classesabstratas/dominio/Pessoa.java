package academy.classesabstratas.dominio;
public abstract class Pessoa {
    public abstract void imprime(); //Funcionario extende Pessoa, mas n vai precisar implementar esse metodo por tambem ser uma classe abstrata. Porem, as classes nao abstratas que serao derivadas 
}                                   //de Pessoa e Funcionario, precisarão implementar o metodo. Outra maneira de resolver, é implementando na classe Funcionario, ai as subclasses de funcionario nao
                                    //precisarão implementar o metodo.
