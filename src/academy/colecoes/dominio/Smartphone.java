package academy.colecoes.dominio;

public class Smartphone {
    private String serialNumber;   //Para vc dizer ao java que para comparar dois smartphone por ex, para serem o mesmo ou nao depende do serialNumber, vc sobreescreve equals.
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Regras para redefinir o metodo equals:
    //Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null;
    //Simétrico: para x e y diferentes de null, se x.equals(y) == True logo y.equals(x) também tem que ser true;
    //Transitividade: para x, y, z diferentes de null, se x.equals(y) == True, e x.equals(z) == True, logo y.equals(z) também tem que ser True;
    //Consistente: x.equals(x) sempre retorna true se x for diferente de null;
    //Para x diferente de null, x.equals(null) tem que retornar false;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true; //Essa logica é igual quando vc fez Smartphone s2 = s1.
        if (this.getClass() != obj.getClass()) return false;  //Aqui vc ja sabe que o obj é um smartphone
        Smartphone smartphone = (Smartphone) obj;   //Entao aqui vc pode fazer o cast dele como smartphone
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber); //E aqui vem o resultado do equals, true se for diferente de null E o serial do objeto que esta
                                            //      ^ Esse equals é o normal        //usando esse metodo for igual ao serial do smartphone obj.
    }


    //Regras para redefinir o metodo hashCode:
    //Se x.equals(y) == True, y.hashCode() == x.hashCode();
    //y.hashCode() == x.hashCode() nao necessariamente y.equals(x) == True;
    //Se x.equals(y) == False o hashCode tem que ser diferente;
    //Se y.hashCode() != x.hashCode(), x.equals(y) deverá ser false.

    @Override
    public int hashCode() { //Se vc entrar no super.hashCode vai ver public native, significa que foi escrito em outra linguagem que não Java.
                           //HashCode é um número (único de preferência, mas pode ter o mesmo para dois objetos) gerado para os objetos.
                          //O hashCode e o equals tem que estar em sintonia. Se vc usa o serialNumber para o equals, ele precisa ser usado no hashCode para ter lógica.
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
