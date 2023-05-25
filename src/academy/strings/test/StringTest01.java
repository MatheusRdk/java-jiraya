package academy.strings.test;
public class StringTest01 {
    public static void main(String[] args) { //Strings sao imutaveis
        String nome = "Matheus"; //As strings ficam dentro da string constant pool
        String nome2 = "Matheus";
        nome.concat(" Rudek");  //Perceba que após esse concat mesmo assim da true. A imutabildade de Strings nao deixa ela ser alterada. Foi criado dentro do string pool a string Rudek
        //                              e a string Matheus Rudek, porem sem uma referencia.

        nome = nome.concat(" Rudek"); /// Dessa forma vc altera a referencia, ai sim a variavel nome é alterada. Mas a string "Matheus" sozinha ainda existe dentro do string pool
        //nome += " Rudek";
        System.out.println(nome == nome2); //Dessa forma vc compara se o nome e nome2 fazem referencia pra mesma coisa dentro do string pool.

        String nome3 = new String("Matheus"); //Nessa linha vc criou: 1 - variavel de referencia, 2 - objeto do tipo string, 3 - uma string no pool de strings. Nao e certo fazer dessa forma
        System.out.println(nome2 == nome3); //Essa comparacao da false, pq aquela forma de criar a string do nome3, cria um objeto fora do pool de strings.

        System.out.println(nome2 == nome3.intern()); //Essa da true pq o intern pega o que o objeto esta referenciando la no pool de strings.
    }
}
