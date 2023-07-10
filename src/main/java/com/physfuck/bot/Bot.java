package com.physfuck.bot;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 *
 */
public class Bot extends TelegramLongPollingBot
{
	private static final Logger log = LogManager.getLogger(Bot.class);
	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			String textFromUser = update.getMessage().getText();
			
			Long userId = update.getMessage().getChatId();
			String userFirstName = update.getMessage().getFrom().getFirstName();
			
			log.info(String.format("[{%d} {%s}] : {%s}", userId, userFirstName, textFromUser));
			
			SendMessage sendMessage = SendMessage.builder()
					.chatId(userId.toString())
					.text(String.format("Received message!%nFrom: {%s}%nText:{%s}", userFirstName, textFromUser))
					.build();
			try {
				this.sendApiMethod(sendMessage);
			} catch (TelegramApiException e) {
				log.error("I can`t fuck you, son", e);
			}
		} else {
			log.warn("Damn, what the fuck are you talking about?");
		}
	}
	
	@Override
	public String getBotUsername() {
		return "PhysFuckBot";
	}
	@Override
	public String getBotToken() {
		return "6317212734:AAFk_C8E7zbHyUBH3s9pyvLgK-YCVYXehk8";
	}
}
