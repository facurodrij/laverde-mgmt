package edu.unam.jte.controladores;

public class cuitControlador {
    private static long digito(long numero, int digi) {
        long exacto = 1;
        for (int i = 1; i <= digi; i++) {
            exacto *= 10;
        }
        long masUno = exacto * 10;
        if (digi < 0) {
            return 0;
        }
        System.out.println(numero % masUno);
        System.out.println(numero % masUno / exacto);
        return numero / exacto % masUno;
    }

    static boolean cuitValido(long cuil) {
        if (cuil < 0) {
            return false;
        }
        switch ((int)(cuil / 1000000000)) {
            case 30: break;
            case 33: break;
            case 34: break;
            default: return false;
        }
        long original = 0;
        long codigo = 5432765432l;
        long suma = 0;
        if (cuil / 1000000000l == 33) {
            switch ((int)(cuil % 10)) {
                case 9: original = (cuil % 1000000000l) + 30000000000l; break;
                case 3: original = (cuil % 1000000000l) + 34000000000l;
            }
            for (int i = 0; i < 10; i++) {
                suma = suma + (digito(original, i+1) * digito(codigo, i));
            }
            if ((11 - (suma % 11)) == 1) {
                return true;
            }
            return false;
        }
        switch ((int)(cuil / 1000000000)) {
            case 30: if ((cuil % 11) == 9) {return false;} break;
            case 34: if ((cuil % 11) == 3) {return false;}
        }
        for (int i = 0; i < 10; i++) {
            suma = (suma + (digito(cuil, i+1) * digito(codigo, i)));
        }
        switch (11 - (int)(suma % 11)) {
            case 0: return false;
            case 11: suma = 0; break;
            case 10: suma = 1; break;
            default: suma = 11-(suma % 11);
        }
        if (suma != (cuil % 10)) {
            return false;
        }
        return true;
    }
}
