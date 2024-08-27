package org.springframework.ai.openai.samples.helloworld.keyword.infrastructure;

import org.springframework.ai.openai.samples.helloworld.keyword.entity.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatSessionRepository extends JpaRepository<ChatSession, Long> {

}
