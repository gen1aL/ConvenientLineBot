package com.herokuapp.convenient.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.herokuapp.convenient.service.LineBotService;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.AudioMessageContent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.message.VideoMessageContent;
import com.linecorp.bot.model.event.source.GroupSource;
import com.linecorp.bot.model.event.source.Source;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LineMessageHandler
public class LineBotController {

	private final LineBotService lineBotService;

	public LineBotController(LineBotService lineBotService) {
		this.lineBotService = lineBotService;
	}

	@EventMapping
	public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		String message = lineBotService.makeReply(event);
		//System.out.println("event: " + event);
		return new TextMessage(message);
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		System.out.println("event: " + event);
	}

	@EventMapping
	public Message handleStickerMessage(MessageEvent<StickerMessageContent> event) {
		return new TextMessage("Thank you for sending stamp ：）");
	}

	@EventMapping
	public Message handleImageMessage(MessageEvent<ImageMessageContent> event) {
		return new TextMessage("Thank you for sending image ：D");
	}

	@EventMapping
	public Message handleVideoMessage(MessageEvent<VideoMessageContent> event) {
		return new TextMessage("Thank you for sending video XD");
	}

	@EventMapping
	public Message handleAudioMessage(MessageEvent<AudioMessageContent> event) {
		return new TextMessage("Thank you for sending audio ；）");
	}

}
