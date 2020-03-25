package br.edu.jogoDaVelha.components;

import br.edu.jogoDaVelha.controls.Controle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelha extends JFrame{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel jogadores;
    private JPanel jogodavelha;
    private JPanel southJpanel;
    private JPanel northJpanel;
    private JPanel centerJpanel;
    private JButton reiniciarButton;
    private JButton sairButton;
    private JLabel labelNomeO;
    private JLabel labelNomeX;

    private Controle controle;
    private String nomeJogadorX, nomeJogadorO;

    public JogoDaVelha(String nomeJogadorX, String nomeJogadorO) {
        this.nomeJogadorO = nomeJogadorO;
        this.nomeJogadorX = nomeJogadorX;

        controle = new Controle(nomeJogadorX, nomeJogadorO);
        inicializarComponents();
        listeners();
    }

    private void inicializarComponents() {
        getContentPane().setLayout(new BorderLayout(0, 0));

        /// Declarações menu Jogadores ///

        jogadores = new JPanel();
        getContentPane().add(jogadores, BorderLayout.NORTH);
        jogadores.setLayout(new BorderLayout(0,0));

        northJpanel = new JPanel();
        reiniciarButton = new JButton("Reiniciar");
        northJpanel.add(reiniciarButton);

        sairButton = new JButton("Sair");
        northJpanel.add(sairButton);
        jogadores.add(northJpanel, BorderLayout.NORTH);

        centerJpanel = new JPanel();
        centerJpanel.setBorder(new TitledBorder(null, "Jogador X", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        labelNomeX = new JLabel(nomeJogadorX);
        centerJpanel.add(labelNomeX);
        jogadores.add(centerJpanel, BorderLayout.CENTER);

        southJpanel = new JPanel();
        southJpanel.setBorder(new TitledBorder(null, "Jogador O", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        labelNomeO = new JLabel(nomeJogadorO);
        southJpanel.add(labelNomeO);
        jogadores.add(southJpanel, BorderLayout.SOUTH);

        /// Declarações Jogo da Velha ///

        jogodavelha = new JPanel();
        jogodavelha.setLayout(new GridLayout(3,3));
        getContentPane().add(jogodavelha, BorderLayout.CENTER);

        button1 = new JButton("");
        jogodavelha.add(button1);

        button2 = new JButton("");
        jogodavelha.add(button2);

        button3 = new JButton("");
        jogodavelha.add(button3);

        button4 = new JButton("");
        jogodavelha.add(button4);

        button5 = new JButton("");
        jogodavelha.add(button5);

        button6 = new JButton("");
        jogodavelha.add(button6);

        button7 = new JButton("");
        jogodavelha.add(button7);

        button8 = new JButton("");
        jogodavelha.add(button8);

        button9 = new JButton("");
        jogodavelha.add(button9);

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void listeners() {
        controle.mostarJogadorDaVez();

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1.setText(controle.marcar(1));
                button1.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2.setText(controle.marcar(2));
                button2.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button3.setText(controle.marcar(3));
                button3.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button4.setText(controle.marcar(4));
                button4.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button5.setText(controle.marcar(5));
                button5.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button6.setText(controle.marcar(6));
                button6.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button7.setText(controle.marcar(7));
                button7.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button8.setText(controle.marcar(8));
                button8.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button9.setText(controle.marcar(9));
                button9.setEnabled(false);
                mudarJogadorSeNaoTerminouOjogo();
            }
        });

        reiniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciar();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void terminarJogo() {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }

    private void mudarJogadorSeNaoTerminouOjogo() {
        if (controle.terminouOjogo()) {
            terminarJogo();
        } else {
            controle.mudarJogador();
        }
    }

    private void reiniciar() {
        String nomeJogadorX = "Jogador X: ";
        nomeJogadorX += JOptionPane.showInputDialog(null, "Digite o nome do jogador X:");
        labelNomeX.setText(nomeJogadorX);

        String nomeJogadorO = "Jogador O: ";
        nomeJogadorO += JOptionPane.showInputDialog(null, "Digite o nome do jogador O:");
        labelNomeO.setText(nomeJogadorO);

        button1.setText("");
        button1.setEnabled(true);

        button2.setText("");
        button2.setEnabled(true);

        button3.setText("");
        button3.setEnabled(true);

        button4.setText("");
        button4.setEnabled(true);

        button5.setText("");
        button5.setEnabled(true);

        button6.setText("");
        button6.setEnabled(true);

        button7.setText("");
        button7.setEnabled(true);

        button8.setText("");
        button8.setEnabled(true);

        button9.setText("");
        button9.setEnabled(true);

        controle.mostarJogadorDaVez();
    }
}
