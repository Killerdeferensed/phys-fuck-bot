package com.physfuck.bot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Application {
	private static final Logger log = LogManager.getLogger(/*Application.class*/);
	public static void main(String[] args) throws TelegramApiException {
		log.trace("Log trace!");
		log.debug("Log debug!");
		log.info("Log info!");
		log.warn("Log warn!");
		log.error("Log error!");
		log.fatal("Log fatal!");
		//BasicConfigurator.configure();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		try {
			log.info("Registering a bot");
			telegramBotsApi.registerBot(new Bot());
		} catch (TelegramApiRequestException e) {
			log.error("Failed to register bot(check internet connection / bot token or make sure only one instance of bot is running).", e);
		}
		log.info("Ready!");
	}
}
