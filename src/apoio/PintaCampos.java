/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Leonardo Krindges
 */
public class PintaCampos {

    public static void pintaBordaCampoVermelho(JFormattedTextField campoFormatado, JTextField campoTexto, JComboBox comboBox) {
        if (campoFormatado != null) {
            Border border = BorderFactory.createLineBorder(Color.RED, 2);
            campoFormatado.setBorder(border);
        }
        if (campoTexto != null) {
            Border border = BorderFactory.createLineBorder(Color.RED, 2);
            campoTexto.setBorder(border);
        }
        if (comboBox != null) {
            Border border = BorderFactory.createLineBorder(Color.RED, 2);
            comboBox.setBorder(border);
        }
    }

    public static void pintaBordaCampoVerde(JFormattedTextField campoFormatado, JTextField campoTexto, JComboBox comboBox) {
        if (campoFormatado != null) {
            Border border = BorderFactory.createLineBorder(Color.green, 2);
            campoFormatado.setBorder(border);
        }
        if (campoTexto != null) {
            Border border = BorderFactory.createLineBorder(Color.green, 2);
            campoTexto.setBorder(border);
        }
        if (comboBox != null) {
            Border border = BorderFactory.createLineBorder(Color.green, 2);
            comboBox.setBorder(border);
        }
    }

    public static void pintaBordaCampoCinza(JFormattedTextField campoFormatado, JTextField campoTexto, JComboBox comboBox) {
        if (campoFormatado != null) {
            Border border = BorderFactory.createLineBorder(Color.gray, 1);
            campoFormatado.setBorder(border);
        }
        if (campoTexto != null) {
            Border border = BorderFactory.createLineBorder(Color.gray, 1);
            campoTexto.setBorder(border);
        }
        if (comboBox != null) {
            Border border = BorderFactory.createLineBorder(Color.gray, 1);
            comboBox.setBorder(border);
        }

    }
}
