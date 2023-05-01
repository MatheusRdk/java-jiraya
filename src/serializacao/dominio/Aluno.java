package serializacao.dominio;

import java.io.*;

public class Aluno implements Serializable {//Para conseguir serializar o objeto precisa implementar essa interface.
    @Serial
    private static final long serialVersionUID = 7523543801423662478L;  //Cria uma chave de controle pro java, para saber que é a mesma versao serializada q foi descerializada.
    private Long id;
    private String nome;
    private transient String password;  //Para esse atributo ser ignorado na serialização e nao ser visto por quem ter o arquivo, usa transient. Ele nao é serializado daí
    private static final String NOME_ESCOLA = "Escola doidona";  //Atributos estaticos nao sao serializados, pois pertencem a classe e nao ao objeto.
    private transient Turma turma; //É melhor nao serializar objetos que vc nao tem controle (nesse caso vc poderia fazer turma extender Serializable, porém, imagine que vc está usando

    //                                                                uma classe de alguem por uma api, que nao pode ser modificada. Ai tem que fazer
    //                                                                                                                                          o seguinte
    public Aluno(Long id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeUTF(turma.getNome()); //Vc nao pode serializar turma, mas pode escrever os valores dela.
        } catch (IOException e) {           //Aqui vc escreve ela
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois) {   //Aqui vc lê ela.
        try {
            ois.defaultReadObject();
            String nomeTurma = ois.readUTF();                //Vc tem que fazer esse write e read object para CADA ATRIBUTO da turma.
            turma = new Turma(nomeTurma);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", Turma='" + turma + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
