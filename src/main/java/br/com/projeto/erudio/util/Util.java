package br.com.projeto.erudio.util;

public class Util {


    public static Double convertToDouble(String strNumber) {
        if (strNumber.trim().isEmpty()) {
            return 0D;
        }
        String strNovoPadrao = strNumber.replaceAll(",", ".");
        if (isNumeric(strNovoPadrao)) {
            return Double.parseDouble(strNovoPadrao);
        }
        return 0D;
    }

    public static boolean isNumeric(String numberValue) {
        try {
            if (numberValue.trim().isEmpty()) {
                return false;
            }
            return numberValue.replaceAll(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+");
            //return numValue.matches("[-+]?[0-9]*\\.?[0-9]+");
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.getMessage();
        }
        return false;
    }
}
