/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vendademercadorias;

import apoio.ConexaoBD;
import java.sql.*;
import javax.swing.JOptionPane;
import tela.FrmPrincipal;

/**
 *
 * @author Leonardo Krindges
 */
public class VendadeMercadorias {
    
    static Connection conexao = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (ConexaoBD.getInstance().getConnection() != null) {
            new FrmPrincipal().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados");
        }
    }

}
