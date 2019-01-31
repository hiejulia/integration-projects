package br.com.jorgeacetozi.ebookChat.chatroom.domain.service;

import java.util.List;

import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.InstantMessage;

public interface InstantMessageService {
	

	// append message to conversations - nghe dream theater - nghe rock hoc thuat a 
	void appendInstantMessageToConversations(InstantMessage instantMessage);

	
	List<InstantMessage> findAllInstantMessagesFor(String username, String chatRoomId);
}
