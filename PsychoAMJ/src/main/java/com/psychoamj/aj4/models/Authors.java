package com.psychoamj.aj4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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

@NamedQuery(name = "Authors.findAuthorsByBookId", query = "SELECT a FROM Authors a")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
public class Authors {

	@Id
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@Column(name = "authors_id")
	private Integer authorsId;
	
	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 50, message = BookConstants.IMAGE_MAKER_LENGTH_MESSAGE)
	@Column(name = "image_maker")
	private String imageMaker;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 50, message = BookConstants.COVER_DEVELOPER_LENGTH_MESSAGE)
	@Column(name = "cover_developer")
	private String coverDeveloper;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 50, message = BookConstants.ILLUSTRATOR_LENGTH_MESSAGE)
	@Column(name = "illustrator")
	private String illustrator;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 1000, message = BookConstants.WRITERS_LENGTH_MESSAGE)
	@Column(name="writers")
	private String writers;
	
}
