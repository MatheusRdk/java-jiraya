package academy.padroesdeprojeto.test;

import academy.padroesdeprojeto.dominio.Country;
import academy.padroesdeprojeto.dominio.Currency;
import academy.padroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 { //Padrao Factory: Desacopla a classe da criação do objeto dela. Nao importa COMO a moeda esta sendo criada, o que importa é que vai ser criada.
    //Se vc precisar alterar alguma regra de negocio, nao mexe no currency, nao precisa sobrecarregar. Vc so mexe na factory.
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
