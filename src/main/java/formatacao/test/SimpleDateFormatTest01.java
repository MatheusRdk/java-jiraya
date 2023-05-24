package formatacao.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String pattern = "'Paraná,' dd 'de' MMMM 'de' yyyy"; //Criar padrões de formatação de datas. O que esta entre aspas simples sera ignorado pelo sdf e mostrado normalmente
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//Forma mais facil de mexer com datas
        System.out.println(sdf.format(new Date()));
    }
}
