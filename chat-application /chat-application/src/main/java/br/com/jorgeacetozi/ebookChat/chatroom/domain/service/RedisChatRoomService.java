package br.com.jorgeacetozi.ebookChat.chatroom.domain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.ChatRoom;
import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.ChatRoomUser;
import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.InstantMessage;
import br.com.jorgeacetozi.ebookChat.chatroom.domain.repository.ChatRoomRepository;
import br.com.jorgeacetozi.ebookChat.utils.Destinations;
import br.com.jorgeacetozi.ebookChat.utils.SystemMessages;

@Service
public class RedisChatRoomService implements ChatRoomService {

	// Add caching with Redis 

	@Autowired
	private SimpMessagingTemplate webSocketMessagingTemplate;

	@Autowired
	private ChatRoomRepository chatRoomRepository;

	@Autowired
	private InstantMessageService instantMessageService;



// Create new chat room 
	@Override
	public ChatRoom save(ChatRoom chatRoom) {
		// repo.save 
		return chatRoomRepository.save(chatRoom);
	}


// find by id : chat room id

// Find chat room by id 
	@Override
	public ChatRoom findById(String chatRoomId) {
		// repo.findOne - id 
		return chatRoomRepository.findOne(chatRoomId);
	}

	// Join - user - chatroom 
	@Override
	public ChatRoom join(ChatRoomUser joiningUser, ChatRoom chatRoom) {

		// chatroom. add user 
		chatRoom.addUser(joiningUser);
		// chat room - save 
		chatRoomRepository.save(chatRoom);
	// publish message- 

		// send public message - chat room - id - user.getUsername 

		sendPublicMessage(SystemMessages.welcome(chatRoom.getId(), joiningUser.getUsername()));
		updateConnectedUsersViaWebSocket(chatRoom);
		return chatRoom;
	}


// User leave chat room : user - chat room 
	@Override
	public ChatRoom leave(ChatRoomUser leavingUser, ChatRoom chatRoom) {
		
	

	// publiah message 
		sendPublicMessage(SystemMessages.goodbye(chatRoom.getId(), leavingUser.getUsername()));
		// chatroom - remove user 
		chatRoom.removeUser(leavingUser);
		// save 
		chatRoomRepository.save(chatRoom);
		
		updateConnectedUsersViaWebSocket(chatRoom);
		return chatRoom;
	}


// send public message - 
	@Override
	public void sendPublicMessage(InstantMessage instantMessage) {
		webSocketMessagingTemplate.convertAndSend(
				Destinations.ChatRoom.publicMessages(instantMessage.getChatRoomId()),
				instantMessage);

		instantMessageService.appendInstantMessageToConversations(instantMessage);
	}

	@Override
	public void sendPrivateMessage(InstantMessage instantMessage) {

		// Send private message 
		webSocketMessagingTemplate.convertAndSendToUser(
				instantMessage.getToUser(),
				Destinations.ChatRoom.privateMessages(instantMessage.getChatRoomId()), 
				instantMessage);
		
		webSocketMessagingTemplate.convertAndSendToUser(
				instantMessage.getFromUser(),
				Destinations.ChatRoom.privateMessages(instantMessage.getChatRoomId()), 
				instantMessage);

		instantMessageService.appendInstantMessageToConversations(instantMessage);

		
	}

	@Override
	public List<ChatRoom> findAll() {
		// get all chat room 
		return (List<ChatRoom>) chatRoomRepository.findAll();
	}
	

	// Update connected users via web socket - chat room 
	private void updateConnectedUsersViaWebSocket(ChatRoom chatRoom) {

	// websocket messaging template - send - destination 
	// all users -  chat room id - get connected users 
		webSocketMessagingTemplate.convertAndSend(
				Destinations.ChatRoom.connectedUsers(chatRoom.getId()),
				chatRoom.getConnectedUsers());
	}
}
