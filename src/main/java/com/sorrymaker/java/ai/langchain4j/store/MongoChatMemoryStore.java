package com.sorrymaker.java.ai.langchain4j.store;

import com.sorrymaker.java.ai.langchain4j.bean.ChatMessages;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MongoChatMemoryStore implements ChatMemoryStore {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ChatMessage> getMessages(Object messageId) {
        Criteria criteria = Criteria.where("messageId").is(messageId);
        Query query = new Query(criteria);

        ChatMessages chatMessages = mongoTemplate.findOne(query, ChatMessages.class);
        if(chatMessages == null){
            return new LinkedList<>();
        }
        String contentJson = chatMessages.getContent();

        return ChatMessageDeserializer.messagesFromJson(contentJson);
    }

    @Override
    public void updateMessages(Object messageId, List<ChatMessage> list) {
        Criteria criteria = Criteria.where("messageId").is(messageId);
        Query query = new Query(criteria);
        Update update = new Update();


        update.set("content", ChatMessageSerializer.messagesToJson(list));

        //修改或新增
        mongoTemplate.upsert(query,update,ChatMessages.class);
    }

    @Override
    public void deleteMessages(Object messageId) {
        Criteria criteria = Criteria.where("messageId").is(messageId);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
