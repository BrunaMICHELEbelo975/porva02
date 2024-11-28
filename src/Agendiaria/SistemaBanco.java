package Agendiaria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaBanco {


    private JButton btnAddComp;
    private JTable tbCompromissos;
    private JPanel panel02;
    private JPanel panel01;
    private JPanel panelabanco;
    private JButton on;
    private JButton butos;
    private JTextField txt4;
    private JTextField text2;
    private JFormattedTextField text;
    private JButton buttontnt;
    private JLabel name;
    private JLabel saldo;
    private JLabel valor;
    private JLabel saquwe;
    private JLabel informe;
    private String infComprimisso;
    private String infData;

    Interacoes inter = new Interacoes();

    public SistemaBanco() {
        butos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txt4.getText().equals("")) {

                    txt4.setText("");

                }else {

                    inter.operacao(txt4.getText(), 1);
                    txt4.setText(inter.getSaldo());
                    JTextArea.setText(inter.mensagem());
                    txt4.setText("");

                }

            }
        });
        text2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (text2.getText().equals("")) {

                    text2.setText("");

                }else {

                    inter.operacao(text2.getText(), 2);
                    txt4.setText(inter.getSaldo());
                    JTextArea.setText(inter.mensagem());
                    text2.setText("");
                }

            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextArea.setText("");
                inter.limpar();

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sistema Banco");
        frame.setContentPane(new SistemaBanco().panelTela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}


public class Interacoes {

    private Double valorFinal = 500.;
    private List<String> mensagem = new ArrayList<String>();


    public void operacao(String valor, int operacao) {

        try {



            if (operacao == 1) {

                if (valorFinal < Double.valueOf(valor)) {

                    mensagem.add("Erro Saldo Insuficiente");

                } else if (Double.valueOf(valor) < 0) {

                    mensagem.add("Erro Numero negativo");

                } else {

                    mensagem.add("Saque Bem Sucedido");
                    valorFinal = valorFinal - Double.valueOf(valor);

                }

            } else if (operacao == 2) {

                if (Double.valueOf(valor) >= 1000) {

                    mensagem.add("Erro Limite Maximo de Deposito é 1000");

                }else if (Double.valueOf(valor) < 0) {

                    mensagem.add("Erro Numero negativo");

                } else {

                    mensagem.add("Deposito Bem Sucedido");
                    valorFinal = valorFinal + Double.valueOf(valor);

                }


            }

        }catch (Exception e) {

            mensagem.add("Informar Valor Valido");

        }

    }

    public String getSaldo(){
        return "R$ " + valorFinal;
    }


    public String mensagem(){

        return String.join("\n", mensagem);

    }

    public void limpar(){

        mensagem.clear();

    }


}

