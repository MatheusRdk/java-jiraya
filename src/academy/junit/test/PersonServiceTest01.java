package academy.junit.test;

import academy.junit.domain.Person;
import academy.junit.service.PersonService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonServiceTest01 { //Teste unitarios testam uma parte do seu codigo, como um método por exemplo. Se por acaso alguem troca alguma parte do seu codigo, como por ex. a
    //idade pra ser de maior, vc precisa testar pra ver se essa mudança nao vai afetar outras partes do seu código.
    public static void main(String[] args) {
        Person person = new Person(15);
        PersonService personService = new PersonService();
        log.info("Is adult? '{}'", personService.isAdult(person)); //Essa seria a forma que vc testava usualmente.
    }
}
