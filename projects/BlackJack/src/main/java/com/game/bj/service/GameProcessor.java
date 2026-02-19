package com.game.bj.service;

import com.game.bj.dto.Player;
import com.game.bj.exception.DeckException;
import java.util.Scanner;

public class GameProcessor {

    private Scanner scanner;
    private BillingService billingService;
    private ExchangeServise exchangeServise;
    private GameService gameService;
    private DeckService deckService;
    private InitGameService initGameService;

    public GameProcessor(
        Scanner scanner,
        BillingService billingService,
        ExchangeServise exchangeServise,
        GameService gameService,
        DeckService deckService,
        InitGameService initGameService
        ) {
        this.scanner = scanner;
        this.billingService = billingService;
        this.exchangeServise = exchangeServise;
        this.gameService = gameService;
        this.deckService = deckService;
        this.initGameService= initGameService;
    }

    public void game(){
        Player player = initGameService.initGame();

    }
}
