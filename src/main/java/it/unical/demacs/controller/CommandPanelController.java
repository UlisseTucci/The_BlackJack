package it.unical.demacs.controller;

import it.unical.demacs.model.CardStack;
import it.unical.demacs.model.Game;
import it.unical.demacs.view.GameButton;
import it.unical.demacs.view.GameTableFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandPanelController implements ActionListener {
    private int totalBet = 0;

    public CommandPanelController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selectedButton = e.getSource();

        if (selectedButton instanceof GameButton) {
            GameButton gameButton = (GameButton) selectedButton;

            switch (gameButton.getType()) {

                case GameButton.BET_1 -> {
                    System.out.println("Hai premuto il tasto BET_1!");
                    int currentBet = GameTableFrame.getInstance().getBet();
                    GameTableFrame.getInstance().setBet(currentBet + 1);
                    totalBet += 1;
                }
                case GameButton.BET_5 -> {
                    System.out.println("Hai premuto il tasto BET_5!");
                    int currentBet = GameTableFrame.getInstance().getBet();
                    GameTableFrame.getInstance().setBet(currentBet + 5);
                    totalBet += 5;
                }
                case GameButton.BET_25 -> {
                    System.out.println("Hai premuto il tasto BET_25!");
                    int currentBet = GameTableFrame.getInstance().getBet();
                    GameTableFrame.getInstance().setBet(currentBet + 25);
                    totalBet += 25;
                }
                case GameButton.BET_100 -> {
                    System.out.println("Hai premuto il tasto BET_100!");
                    int currentBet = GameTableFrame.getInstance().getBet();
                    GameTableFrame.getInstance().setBet(currentBet + 100);
                    totalBet += 100;
                }
                case GameButton.CLEAR_BET -> {
                    System.out.println("Hai premuto il tasto CLEAR_BET!");
                    GameTableFrame.getInstance().setBet(0);
                    totalBet = 0;
                }
                case GameButton.BET -> {
                    System.out.println("Hai premuto il tasto BET!");
                    if (totalBet != 0) {
                        int currentMoney = GameTableFrame.getInstance().getMoney();
                        GameTableFrame.getInstance().setMoney(currentMoney - totalBet);
                        GameTableFrame.getInstance().setPossibleWin(totalBet);
                        totalBet = 0;
                        GameTableFrame.getInstance().gameStatus();
                        GameTableFrame.getInstance().setBet(0);
                    }
                    else if (totalBet == 0) {
                        GameTableFrame.getInstance().showBetMessage();
                    }

                }
                case GameButton.HIT -> {
                    System.out.println("Hai premuto il tasto HIT!");
                    Game.getInstance().askCard();

                }
                case GameButton.STAND -> {
                    System.out.println("Hai premuto il tasto STAND!");
                    Game.getInstance().dealerPlaying();
                    Game.getInstance().decideWinners();
                    GameTableFrame.getInstance().resetGame();
                }
                case GameButton.SURREND -> {
                    System.out.println("Hai premuto il tasto SURREND!");
                    Game.getInstance().surrenderedPlayer();
                    GameTableFrame.getInstance().resetGame();

                }
            }
        }
    }
}
