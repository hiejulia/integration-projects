package br.com.jorgeacetozi.ebookChat.chatroom.domain.service;

import java.util.List;

import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.ChatRoom;
import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.ChatRoomUser;
import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.InstantMessage;

public interface ChatRoomService {

	

	// Create new chat room 
	ChatRoom save(ChatRoom chatRoom);

	// find chat room by id 
	ChatRoom findById(String chatRoomId);

	// User join chat room- chatRoom - user 
	ChatRoom join(ChatRoomUser joiningUser, ChatRoom chatRoom);


	// User leave chat room - chatroom - user 
	ChatRoom leave(ChatRoomUser leavingUser, ChatRoom chatRoom);


	// send public message 
	void sendPublicMessage(InstantMessage instantMessage);



	// send private message 
	void sendPrivateMessage(InstantMessage instantMessage);

	// List all chat room 
	List<ChatRoom> findAll();
}

