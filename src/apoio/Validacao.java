/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo Krindges
 */
public class Validacao {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validarCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCNPJ(JFormattedTextField campo) {
        String CnpjSemFormatacao = Formatacao.removerFormatacao(campo.getText());

        if ((campo.getText().isEmpty()) || (CnpjSemFormatacao.length() != 14)) {
            PintaCampos.pintaBordaCampoVermelho(campo, null, null);
            campo.requestFocus();
            return false;
        }
        Integer digito1 = calcularDigito(CnpjSemFormatacao.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(CnpjSemFormatacao.substring(0, 12) + digito1, pesoCNPJ);
        return CnpjSemFormatacao.equals(CnpjSemFormatacao.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarDataDMA(int d, int m, int a) {

        boolean correto = true;

        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarDataFormatada(String dataComFormato) {
        String[] data = dataComFormato.split("/");
        return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
    }

    public static boolean validarTelefone(JFormattedTextField campo) {
        if (campo.getText().trim().length() < 15) {
            PintaCampos.pintaBordaCampoVermelho(campo, null, null);
            campo.requestFocus();
            return false;
        } else {
            PintaCampos.pintaBordaCampoVerde(campo, null, null);
            return true;
        }
    }

    public static boolean validarEmail(JTextField campo) {
        if (campo.getText().indexOf("@") != -1) {
            PintaCampos.pintaBordaCampoVerde(null, campo, null);
            return true;
        } else {
            campo.requestFocus();
            PintaCampos.pintaBordaCampoVermelho(null, campo, null);
            return false;
        }
    }

    public static boolean verificaCampoFormatado(String conteudo, JFormattedTextField campoFormatado) {

        String conteudoSemFormatacao = Formatacao.removerFormatacao(campoFormatado.getText());
        String conteudoSemEspacoBranco = conteudoSemFormatacao.replaceAll(" ", "");

        if (conteudoSemEspacoBranco.isEmpty()) {
            PintaCampos.pintaBordaCampoVermelho(campoFormatado, null, null);
            return false;
        }
        return true;
    }

}
