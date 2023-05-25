package academy.classesinternas.test;

class Animal{
    public void walk(){
        System.out.println("Animal walking...");
    }
}
//class Cachorro extends Animal{        Nao tem pq criar uma classe a mais para usar só uma vez. Ao invés disso crie uma classe anonima igual abaixo.
//   @Override
//   public void walk() {
//       System.out.println("Cachorro walking...");
//     }
//}

public class AnonymousClassTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal(){ //Para criar classe anonima, abre chaves assim e cria um tipo subclasse de animal. Isso se confirma pois so de abrir parenteses vc ja pode
            //sobreescrever o método do animal.

            @Override
            public void walk() {
                System.out.println("I come to walk with you again....");
            }
        };
        animal.walk();
    }
}
