package strings.test;

public class StringBuilderTest01{
    public static void main(String[] args) {
        String nome = "Matheus Rudek";
        nome.concat(" Hekavey");
        StringBuilder sb = new StringBuilder(); //Vc pode colocar um nome direto aqui, como new StringBuilder("Matheus Rudek"), pq o stringbuilder ja converte para string daí.
        //sb = nome; nao pode fazer isso, pq sb é um objeto diferente de string.
        sb.append("Matheus Rudek").append(" Hekavey");
        sb.substring(0, 2); //Perceba que o método substring nao atua sobre o stringbuilder, ele nao vai alterar aquele elemento que ja foi definido no objeto sb. Pra isso quando
        //                             vc chamar o método veja se ele diz stringbuilder do lado direito, igual o sb.reverse().
        sb.reverse();
        System.out.println(sb);
    }
}