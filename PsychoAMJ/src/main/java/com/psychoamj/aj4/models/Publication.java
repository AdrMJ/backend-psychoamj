package com.psychoamj.aj4.models;

import java.time.LocalDate;

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
import com.psychoamj.aj4.validation.CorrectDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publication")
public class Publication {

	@Id
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@Column(name = "publication_id")
	private Integer publicationId;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 50, message = BookConstants.PUBLISHER_LENGTH_MESSAGE)
	@Column(name = "publisher")
	private String publisher;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 50, message = BookConstants.LANGUAGE_LENGTH_MESSAGE)
	@Column(name = "language")
	private String language;

	@CorrectDate(message = BookConstants.CORRECT_DATE_MESSAGE)
	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
}
