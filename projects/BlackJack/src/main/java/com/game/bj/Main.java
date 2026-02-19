package com.game.bj;

import com.game.bj.dto.Card;
import com.game.bj.dto.Currency;
import com.game.bj.dto.GameResult;
import com.game.bj.dto.Player;
import com.game.bj.exception.NotEnoughtMoneyException;
import com.game.bj.service.BillingService;
import com.game.bj.service.DeckService;
import com.game.bj.service.ExchangeServise;
import com.game.bj.service.GameService;
import com.game.bj.service.InitGameService;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Black Jack 2026");

        Scanner sc = new Scanner(System.in);

        Player player = new InitGameService().initGame();

        System.out.println(String.format("%s want play %s games", player.getName(), player.getTotalNumberOfGames()));

        DeckService ds = new DeckService();
        GameService gs = new GameService();
        BillingService bs = new BillingService();
        ds.createDeck(1);
        int counter = 1;
        sc.nextLine();

        do {
            System.out.println("-------------->>>>");
            System.out.println(String.format("%s game form %s games", counter, player.getTotalNumberOfGames()));
            System.out.println("Please put your bet ...");
            BigInteger bet = sc.nextBigInteger();
            sc.nextLine();
            try {
                bet = bs.validateAmount(player.getAmount(), bet);
            } catch (NotEnoughtMoneyException neme
            ) {
                break;
            }

            game(player, ds, gs, sc);
            List<Card> computerHand = gs.getComputerHand(ds.getDeck());

            int pScore = gs.calculateHandScore(player.getHand());
            int cScore = gs.calculateHandScore(computerHand);

            System.out.println("======");
            System.out.println("player hand : " + player.getHand() + " >>>> score : " + pScore);
            System.out.println("computer hand : " + computerHand + " >>>> score : " + cScore);

            GameResult gr = gs.getGameResult(pScore, cScore);
            System.out.println(gr);
            player.incrementNumberOfGames();
            if (GameResult.PLAYER.equals(gr)) {
                player.getNumberOfWins();
                bs.addAmount(player.getAmount(), bet);
            } else if (GameResult.COMPUTER.equals(gr) || GameResult.LOSE.equals(gr)) {
                bs.substractAmount(player.getAmount(), bet);
            }
        }
        while (nextGame(counter++, player.getTotalNumberOfGames(), sc));
        System.out.println("THE END");

    }

    private static boolean nextGame(int gameNumber, int games, Scanner sc) {
        if (gameNumber != games) {
            System.out.println("Next game ... [Y/N]");
            String input = sc.nextLine().toUpperCase();
            if (input.equals("N")) {
                return false;
            } else if (input.equals("Y")) {
                return true;
            }
        } else {
            return false;
        }
        return true;
    }


    private static void game(Player pl, DeckService ds, GameService gs, Scanner sc) {
        String nextCard;
        pl.clearHand();
        do {
            List<Card> hand = pl.getHand();
            // first time 2 card
            if (hand.isEmpty()) {
                hand.add(ds.dealCard());
            }
            hand.add(ds.dealCard());
            int score = gs.calculateHandScore(hand);
            System.out.println("player hand : " + hand + " >>>> score : " + score);
            System.out.println("Balance: " + pl.getAmount());
            if (score < 21) {
                System.out.println("Next card ... [Y/N]");
                nextCard = sc.nextLine().toUpperCase();
            } else {
                break;
            }

        } while (nextCard.equals("Y"));
    }
}
