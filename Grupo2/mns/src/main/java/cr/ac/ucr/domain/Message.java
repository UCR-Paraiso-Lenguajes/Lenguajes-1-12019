package cr.ac.ucr.domain;

import cr.ac.ucr.exceptions.ProjectExceptions;

public class Message {

	private int idMessage;
	private String content;
	
	public Message(String content) {
		validMessage(content);
	}

	private void validMessage(String content) {
		if(content == null ||content.trim().equals("") ) throw new ProjectExceptions();		
		
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
