package com.psychoamj.aj4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.psychoamj.aj4.constants.BookConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "intro_words")
public class IntroWords {

	@Id
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@Column(name = "intro_words_id")
	private Integer introWordsId;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 2000, message = BookConstants.INTRO_WORDS_LENGTH_MESSAGE)
	@Column(name = "intro_words")
	private String introWords;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 100, message = BookConstants.AUTHOR_OF_WORDS_LENGTH_MESSAGE)
	@Column(name = "author_of_words")
	private String authorOfWords;
}
