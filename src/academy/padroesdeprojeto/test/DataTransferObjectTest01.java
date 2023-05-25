package academy.padroesdeprojeto.test;

import academy.padroesdeprojeto.dominio.*;

public class DataTransferObjectTest01 { //O Dto tipo compactar informaçoes. Ao inves de vc mandar vários objetos por uma API por ex., vc manda so o ultumo objeto ReportDto, que contem
    //todas informações que vc julgar necessárias.

    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Pessoa pessoa = Pessoa.PessoaBuilder.builder()
                .firstName("Matheus")
                .lastName("Rudek")
                .build();
        ReportDto build = ReportDto.ReportDtoBuilder.builder()
                .aircraftName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(pessoa.getFirstName())
                .build();

        System.out.println(build);
    }
}
