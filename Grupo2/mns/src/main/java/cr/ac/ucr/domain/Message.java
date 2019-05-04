package cr.ac.ucr.domain;

import cr.ac.ucr.exceptions.ProjectExceptions;

public class Message {

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
	
	
	
}
