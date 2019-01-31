package br.com.jorgeacetozi.ebookChat.chatroom.domain.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import br.com.jorgeacetozi.ebookChat.chatroom.domain.model.InstantMessage;

public interface InstantMessageRepository extends CassandraRepository<InstantMessage> {
	

	// Find Message by Username and Chat Room ID: username, chatRoomId 
	List<InstantMessage> findInstantMessagesByUsernameAndChatRoomId(String username, String chatRoomId);
}




// Message : many - save to Cassandra

// Vai chuong - no la cai gu luon a 