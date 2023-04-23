package es.springboot.prueba.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Value("${course.message:${course.defaultMessage}}")
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
}
