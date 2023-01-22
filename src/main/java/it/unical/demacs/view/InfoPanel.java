package it.unical.demacs.view;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JLabel moneyLabel;
    private JLabel betLabel;
    private int money = 0;
    private int bet = 0;

    public InfoPanel() {

        //this.setBorder(BorderFactory.createTitledBorder(new LineBorder(GameTableFrame.getInstance().getBackground()), "INFO"));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.moneyLabel = new JLabel("   Money: " + this.money + "$");
        this.betLabel = new JLabel("   Bet: " + this.bet + "$");
        this.moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        this.betLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        this.moneyLabel.setForeground(Color.WHITE);
        this.betLabel.setForeground(Color.WHITE);
        this.add(moneyLabel);
        this.add(betLabel);
    }

    public int getBet() {
        return this.bet;
    }
    public void setBet(int bet) {
        this.bet = bet;
        this.betLabel.setText("   Bet: " + bet + "$");
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
        this.moneyLabel.setText("   Money: " + money + "$");
    }
}