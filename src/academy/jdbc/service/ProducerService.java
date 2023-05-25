package academy.jdbc.service;

import academy.jdbc.dominio.Producer;
import academy.jdbc.repository.ProducerRepository;

public class ProducerService { //Essa é a camada de serviço, ela serve pra ser mais uma camada entre o que o cliente esta consumindo e o a classe que ele usa. Por ex.: a classe repository
    //vai criar os métodos de inserção e delete no banco de dados. Mas vc nao usa ela diratemente no na classe main principal (que consome o serviço), vc cria essa de serviço que puxa
    //todos os métodos do repository e ai usa através dela lá na classe 'consumidora' (que tem o public static void main).
    //Aqui vc faz a regra de negócio também, por ex. os requisitos pra usar os métodos do repository, como o delete ali, vc checa aqui se o id é valido pra ser usado ou nao.

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete(int id){
        if (id <= 0){
            throw new IllegalArgumentException("Invalid value for id.");
        }
        ProducerRepository.delete(id);
    }
}