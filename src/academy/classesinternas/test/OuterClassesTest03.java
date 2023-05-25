package academy.classesinternas.test;

public class OuterClassesTest03 { //Classes aninhadas estaticas. Servem para criar classes que so sao utilizadas por outras de fora, que nao compensaria deixar no mesmo nivel delas.
    private String name = "Matheus";
    static class Nested{
        void print(){
            System.out.println(new OuterClassesTest03().name); //Para acessar um atributo de fora dentro de uma static, tem que criar um objeto da outer class.
        }
    }
    public static void main(String[] args) {
        Nested nested = new Nested(); //Nao precisamos do OuterClassesTest03 para criar a nested.
        nested.print();
    }
}
