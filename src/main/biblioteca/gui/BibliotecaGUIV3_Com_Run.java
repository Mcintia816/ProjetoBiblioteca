package main.biblioteca.gui;

import javax.swing.*;

public class BibliotecaGUIV3_Com_Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame janela = new BibliotecaGUIV3ComMenu(); // ou BibliotecaGUIV3
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}