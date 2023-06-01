package academy.junit.service;

import academy.junit.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class PersonServiceTest {

    private Person adult;
    private Person notAdult;
    private PersonService personService;


    @BeforeEach  //Esse teste será feito antes de cada um.
    public void setUp(){
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }


    @Test
    @DisplayName("A person should be not adult when the age is lower than 18") //Ou vc pode usar essa anotação do junit que mostra essa msg como nome do teste.
    void isAdult_ReturnFalse_WhenAgeIsLowerThen18() { //Vc pode escrever o nome do método dizendo o que vc espera.
        Assertions.assertFalse(personService.isAdult(notAdult)); //Esse assertions é onde vc diz o que vc espera, nesse caso com o assertFalse, vc está dizendo que o resultado tem que ser
        //false
    }

    @Test
    @DisplayName("A person should be adult when the age is greater or equal than 18") //Clica com botao direito no arquivo de teste
    //e vai em run with coverage pra mostrar a cobertura do teste.
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualThen18() {
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw null pointer exception with message when person is null") //Se alguem muda o tipo de excessão la no servico, esse teste vai falhar pois espera outro tipo.
    void isAdult_shouldThrowNullPointerException_WhenPersonIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> personService.isAdult(null),  "Person can't be null");
    }

    @Test
    @DisplayName("Should return list with only adults") //Se alguem muda o tipo de excessão la no servico, esse teste vai falhar pois espera outro tipo.
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Person person1 = new Person(16);
        Person person2 = new Person(18);
        Person person3 = new Person(22);
        List<Person> personList = List.of(person1, person2, person3);
        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size()); //Vc esta esperando que retorne 2, pois 2 sao adultos na lista.
    }
}