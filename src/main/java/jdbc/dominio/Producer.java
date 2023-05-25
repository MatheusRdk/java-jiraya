package jdbc.dominio;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;


@Value   //Isso sao anotações que vieram da dependencia lombok. Elas facilitam muito, vc n precisa criar os getter hashcode equals nem builder, so coloca eles que ele cria.
@Builder //O value transforma tudo em imutavel e o builder adiciona o builder.
public class Producer {
    Integer id;   //Vc nao precisa nem colocar o private, pq as anotaçoes ja fazem isso tambem. Pra verificar isso é só executar e ir na mesmo arquivo so que na pasta target.
    String name;  //Nem final class nem nada, o lombok faz tudo isso. Com o value esses atributos sao final e private.
}
