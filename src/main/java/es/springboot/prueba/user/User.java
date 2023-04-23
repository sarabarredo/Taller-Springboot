package es.springboot.prueba.user;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "USERS")
public class User {
		@Id
		@Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		@Column(name = "NAME")
	    private String name;
		
		@Column(name = "BIRTHDATE")
	    private LocalDate birthDate;
		
		public User() {
			super();
		}
		
		public User(Long id, String name, LocalDate birthDate) {
			super();
			this.id = id;
			this.name = name;
			this.birthDate = birthDate;
		}
		
	    public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public LocalDate getBirthDate() {
			return birthDate;
		}
		
		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}
}
