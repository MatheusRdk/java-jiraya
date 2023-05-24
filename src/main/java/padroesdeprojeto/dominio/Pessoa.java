package padroesdeprojeto.dominio;

public class Pessoa {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;

    //Padrao de projeto Builder
    // 1.Deixa privado o construtor. Cria uma classe static com o mesmo nome e 'Builder' no fim. Faz o construtor de cada atributo em um método diferente nessa classe.
    private Pessoa(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class PessoaBuilder {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;

        public PessoaBuilder() {
        }

        public static PessoaBuilder builder() {
            return new PessoaBuilder();
        }

        public PessoaBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PessoaBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PessoaBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public PessoaBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Pessoa build() {    //Vc precisa criar esse metodo build nesse padrao, pois ele que vai retornar uma Pessoa e nao mais um PessoaBuilder
            return new Pessoa(firstName, lastName, userName, email);
        }
    }

    public String getFirstName() {
        return firstName;
    }
}

