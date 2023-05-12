package threads.test;

import threads.dominio.Account;

public class ThreadAccountTest01 implements Runnable{
    private final Account account = new Account();

    public static void main(String[] args) {   //Esse codigo exemplifica um problema de sincronismo de threads.
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01(); //As duas threads estao efetuando operacoes no mesmo objeto Account, e isso ocasiona problema de sincronismo,
        Thread t1 = new Thread(threadAccountTest01, "Banqueiro");     //pois uma thread pode parar dentro do if sem completar o saque, e outra iniciar e sacar mesmo sem dinheiro,
        Thread t2 = new Thread(threadAccountTest01, "Agiota");       //pois ja estava dentro do if. Isso ocasiona os valores negativos que podem aparecer quando executar o codigo.
        t1.start();                                                  //Ou seja: t1 chegou na linha 17 e verificou que tinha saldo, e parou na 18, ai a t2 fez a mesma coisa e parou tambem
        t2.start();                                               //Ai a t1 sacou o resto do dinheiro e zerou a conta, e a t2 sacou tambem, pois ja passsou do if que verificava o saldo.
                                                                //Pra isso vc coloca o synchronized no metodo, pq indica que duas threads nao vao poder trabalhar ao mesmo tempo nele
                                                               //Nao vai haver paralelismo na execuçao dela, se comecou o metodo a thread tem que terminar ela.
                                                               //Isso se chama lock. O lock esta no objeto threadAccountTest01. E o metodo ou classe sera executado de forma "atomica",
                                                              //isso quer dizer que vai ser executado ate o final.
    }

    private void withdrawal(int amount){ //vc pode por na assinatura (public synchronized void) ou coloca um bloco dentro do metodo somente.
        //synchronized (account){} vc pode fazer isso com um objeto tambem, coloca todo o codigo abaixo dentro dessas chaves. Pra isso o objeto account tem que ser final.
        //Se fizer dessa forma, so o que estiver dentro do bloco do synchronized que vai ser executado ate o fim quando uma thread entrar nela
        System.out.println(getThreadName() + " está fora do syncrhonized");
        synchronized (account){
            System.out.println(getThreadName() + " está dentro do syncrhonized");
        if(account.getBalance() >= amount){
            System.out.println(getThreadName() + " está indo sacar dinheiro");
            account.withdrawal(amount);
            System.out.println(getThreadName() + " completou o saque. Valor atual da conta: " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque: " + account.getBalance());
        }
        }
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            withdrawal(10);
            if (account.getBalance() < 0){
                System.out.println("Ferrou rapaz corra emprestar dinheiro.");
            }
        }
    }
}
