package classesinternas.test;

public class OuterClassesTest01 {
    private static String name = "Macaaaco";
    //Nested class
    class Inner {    //Classes internas sao como atributos, vc pode colocar private, public, protected, etc...
        public void printOuterClassAttribute(){
            System.out.println(name);
            System.out.println(this); //Esse this faz referencia a classe dele, no caso a Inner.
            System.out.println(OuterClassesTest01.this); //Assim faz para ele fazer referencia a mais externa.

        }
    }

    public static void main(String[] args) { //Vc nao pode chamar criar uma classe Inner aqui no main, pois estão no mesmo nível, só consegue se ele for static
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        Inner inner = outerClass.new Inner(); //Com um objeto que referencia a classe de fora (outer) eu posso criar um objeto de classe de dentro;
        inner.printOuterClassAttribute();
    }
}
