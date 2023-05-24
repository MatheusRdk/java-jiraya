package threads.test;

import threads.dominio.Members;
import threads.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {
    public static void main(String[] args) {
        Members membros = new Members();
        Thread jiraya = new Thread(new EmailDeliveryService(membros), "Jiraya");
        Thread narruto = new Thread(new EmailDeliveryService(membros), "Narruto");
        jiraya.start();
        narruto.start();
        while(true){
            String email = JOptionPane.showInputDialog("Entre com seu email");
            if(email == null || email.isEmpty()){
                membros.close();
                break;
            }
            membros.addMemberEmail(email);
        }
    }
}
