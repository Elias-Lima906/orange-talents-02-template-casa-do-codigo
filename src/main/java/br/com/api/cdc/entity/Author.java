package br.com.api.cdc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;

	@Column(nullable = false,  unique = true)
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dateTimeSignUp = LocalDateTime.now();

	public Author() {
	}

	public Author(@NotBlank String name, @NotBlank @Size(max = 400) String description, @NotBlank String email) {
		this.name = name;
		this.description = description;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDateTimeSignUp() {
		return dateTimeSignUp;
	}

	public String getEmail() {
		return email;
	}

}
