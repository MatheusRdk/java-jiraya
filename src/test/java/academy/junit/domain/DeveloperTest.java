package academy.junit.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    @Test
    public void instaceOf_ExecutesChildClassMethods_WhenObjectIsOfChildType(){
         Employee employeeDeveloper = new Developer("1", "Java");
//         if(employeeDeveloper instanceof Developer){                              //Esse é o jeito antigo de lidar com essa situaçao de cast e instaceOf.
//             Developer developer = (Developer) employeeDeveloper;
//             Assertions.assertEquals("Java", developer.getMainLanguage());
//         }

        if(employeeDeveloper instanceof Developer developer){ //Esse é o jeito novo Pattern Matching for instanceOf. Vc pode criar a referencia developer diretamente no if.
            //Se o if der true ele ja retorna essa variavel.
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }
    }
}