package threads.test;

import threads.dominio.Account;

public class ThreadAccountTest01 implements Runnable{
    private Account account = new Account();

    public static void main(String[] args) {   //Esse codigo exemplifica um problema de sincronismo de threads.
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01(); //As duas threads estao efetuando operacoes no mesmo objeto Account, e isso ocasiona problema de sincronismo,
        Thread t1 = new Thread(threadAccountTest01, "Banqueiro");     //pois uma thread pode parar dentro do if sem completar o saque, e outra iniciar e sacar mesmo sem dinheiro,
        Thread t2 = new Thread(threadAccountTest01, "Agiota");       //pois ja estava dentro do if. Isso ocasiona os valores negativos que podem aparecer quando executar o codigo.
        t1.start();                                                  //Ou seja: t1 chegou na linha 17 e verificou que tinha saldo, e parou na 18, ai a t2 fez a mesma coisa e parou tambem
        t2.start();                                               //Ai a t1 sacou o resto do dinheiro e zerou a conta, e a t2 sacou tambem, pois ja passsou do if que verificava o saldo.
    }

    private void withdrawal(int amount){
        if(account.getBalance() >= amount){
            System.out.println(getThreadName() + " está indo sacar dinheiro");
            account.withdrawal(amount);
            System.out.println(getThreadName() + " completou o saque. Valor atual da conta: " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque: " + account.getBalance());
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
