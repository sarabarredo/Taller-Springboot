package es.springboot.prueba.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping(value="/api/v1/")
	public class MessageController {
		
		@Autowired
		MessageServiceImpl messageServiceImpl;
		
		@Value("${course.message:${course.defaultMessage}}")
		private String message;
		
		@GetMapping(value="message")
		public String getMessage() {
			return message;
		}
		
		@GetMapping(value="message1")
		public ResponseEntity<String> getMessage1() {
			return ResponseEntity.status(HttpStatus.OK).body(messageServiceImpl.getMessage());
		}
		
	}

