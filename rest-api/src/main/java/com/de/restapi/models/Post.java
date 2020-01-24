package com.de.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
@ApiModel(description="All Posts make by a User.")
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JsonIgnore
	private User user;
}
