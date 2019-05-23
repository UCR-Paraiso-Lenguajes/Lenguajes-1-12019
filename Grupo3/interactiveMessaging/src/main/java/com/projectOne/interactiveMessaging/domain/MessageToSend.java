package com.projectOne.interactiveMessaging.domain;

public class MessageToSend {
private String message;

public MessageToSend() {
}

public MessageToSend(String message) {
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
