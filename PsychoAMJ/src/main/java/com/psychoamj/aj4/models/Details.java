package com.psychoamj.aj4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.psychoamj.aj4.constants.BookConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQuery(name = "Details.findDetailsByBookId", query = "SELECT d FROM Details d")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "details")
public class Details {

	@Id
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@Column(name = "details_id")
	private Integer detailsId;
	
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@Max(value = 2000, message = BookConstants.PAGE_COUNT_MAX_MESSAGE)
	@Min(value = 22, message = BookConstants.PAGE_COUNT_MIN_MESSAGE)
	@Column(name = "pageCount")
	private Short pageCount;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 50, message = BookConstants.CATEGORY_LENGTH_MESSAGE)
	@Column(name = "category")
	private String category;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 500, message = BookConstants.ABOUT_BOOK_LENGTH_MESSAGE)
	@Column(name = "about_book")
	private String aboutBook;
	
}
