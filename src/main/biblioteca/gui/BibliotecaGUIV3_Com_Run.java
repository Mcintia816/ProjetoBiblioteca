package main.biblioteca.gui;

import javax.swing.*;

public class BibliotecaGUIV3_Com_Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame janela = new BibliotecaGUIV3ComMenu();
            janela.setVisible(true);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
