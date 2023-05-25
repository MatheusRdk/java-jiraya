package academy.formatacao.test;

import java.util.Locale;

public class LocalTest02 {   //Exibindo conteudo ja formatado para os locais escolhidos
    public static void main(String[] args) {
        System.out.println(Locale.getDefault()); //Linguagem do sistema atual.
        String[] isoCountries = Locale.getISOCountries(); //Lista de todas isos
        String[] isoLanguages = Locale.getISOLanguages(); //Lista de todas linguagens
        
        for (String countries: isoCountries){
            System.out.print(countries + " ");
        }
        System.out.println();
        for (String languages: isoLanguages){
            System.out.print(languages + " ");
        }
    }
}