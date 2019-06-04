package com.proyectoUno.grupo5.businessTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyectoUno.grupo5.business.MessageBussiness;
import com.proyectoUno.grupo5.domain.Message;

public class MessageBusiness {

	@Autowired
	MessageBussiness messageBusiness;
	@Test
	public void mensajeQuinientos() throws SQLException {
		
		Message message = new Message("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim, felis ut tincidunt volutpat, diam nisl aliquet nisi, non feugiat dolor metus nec justo. Maecenas interdum accumsan lobortis. Maecenas sollicitudin feugiat ex nec tristique. Integer interdum urna ut venenatis molestie. Fusce tellus justo, auctor ut erat ac, ullamcorper congue nisi. Curabitur placerat ex purus, eu sagittis dui varius vitae. Vestibulum pharetra imperdiet ipsum rhoncus porttitor. Morbi luctus facilisis neque sed bibendum. Quisque et tellus aliquam, eleifend tellus at, elementum tellus. Sed nec arcu lacus.\r\n" + 
				"\r\n" + 
				"Nullam eget quam faucibus, facilisis est vel, luctus metus. Sed quis dapibus lectus. Vestibulum et nibh id ex commodo tincidunt eget efficitur ligula. Vivamus tempor venenatis elit. Sed ac dignissim sapien. Sed bibendum convallis nisi, non blandit lectus sodales vitae. Nullam nec suscipit nibh, sit amet finibus sem.\r\n" + 
				"\r\n" + 
				"Pellentesque at finibus mi. Ut nisi nunc, ullamcorper eget efficitur ac, pulvinar id justo. Nulla eu velit sed lacus condimentum varius nec nec diam. Pellentesque ornare laoreet risus, in blandit tellus mattis nec. Mauris suscipit imperdiet eros sed iaculis. Nulla eu tellus sit amet justo lobortis elementum cursus at odio. Donec auctor, risus eu condimentum hendrerit, urna ex fermentum magna, ut congue felis magna quis ex. Praesent ante tortor, tincidunt at dictum in, mattis quis ipsum. Donec a lacus sit amet sem sagittis vulputate. Etiam sed porttitor ex, vitae venenatis massa. Proin aliquam ex et lorem aliquet mollis. Aenean magna tellus, molestie at diam in, fringilla sagittis neque.",1,1);
		messageBusiness.insertMessage(message);
		assertFalse(messageBusiness.insertMessage(message);)
		
	}

}
