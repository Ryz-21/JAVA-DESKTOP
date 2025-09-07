package Capa_Datos;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Metodos_Generales {

    public static String generarNumero(int num_ing) {

        String num = "";

        if ((num_ing >= 100000) && (num_ing < 1000000)) {

            num = "A-00" + ++num_ing;
        }
        if ((num_ing >= 10000) && (num_ing < 100000)) {

            num = "A-000" + ++num_ing;
        }
        if ((num_ing >= 1000)&& (num_ing < 10000)) {

            num = "A-0000" + ++num_ing;
        }
        if ((num_ing >= 100) && (num_ing < 1000)) {

            num = "A-00000" + ++num_ing;
        }
        if ((num_ing >=9) && (num_ing < 100)) {

            num = "A-000000" + ++num_ing;
        }
        if (num_ing <9) {

            num = "A-0000000" + ++num_ing;
      
        }

        return num;

    }


}
