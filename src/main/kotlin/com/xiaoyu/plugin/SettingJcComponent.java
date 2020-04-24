package com.xiaoyu.plugin;

import javax.swing.*;

public class SettingJcComponent {
    private JPanel root;
    private JLabel title;
    private JTextField assetDir;
    private JTextField ibDir;

    public JPanel getRoot() {
        return root;
    }

    public JTextField getAssetDir() {
        return assetDir;
    }

    public JTextField getIbDir() {
        return ibDir;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SettingJcComponent");
        frame.setContentPane(new SettingJcComponent().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
