package com.sujoy.chat.chat;







public class ChatMessage {

    private String content;
    private String sender;
    private MessageType type;

    public ChatMessage( String senderName, MessageType messageType)
    {

        sender = senderName;
        type = messageType;
    }



    public String getSender() { return sender;}


    public void setSender(String senderName) { sender = senderName;}

    public String getContent() { return content;}


    public void setContent(String contentStuff) { content = contentStuff;}


    public MessageType getType() { return type;}


    public void setType(MessageType messageType) { type = messageType; }





}
