package com.psychoamj.aj4.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

@NamedQuery(name="Book.findAllBookTitles", query = "SELECT b.title FROM Book b")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//Relationships between classes
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "authors_id", referencedColumnName = "authors_id", foreignKey = @ForeignKey(name = "fk_authors_id"))
	private Authors authors;
	
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "details_id", referencedColumnName = "details_id", foreignKey = @ForeignKey(name = "fk_details_id"))
	private Details details;
	
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "publication_id", referencedColumnName = "publication_id", foreignKey = @ForeignKey(name = "fk_publication_id"))
	private Publication publication;
	
	@OneToMany(targetEntity=IntroWords.class, mappedBy="introWordsId",cascade=CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<IntroWords> introWords = new ArrayList<>();

	//other informations
	
	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 100, message = BookConstants.TITLE_LENGTH_MESSAGE)
	@Column(name = "title")
	private String title;

	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@Min(value = 0, message = BookConstants.IS_STILL_AVAILABLE_MIN_MESSAGE)
	@Max(value = 1, message = BookConstants.IS_STILL_AVAILABLE_MAX_MESSAGE)
	@Column(name = "is_still_available")
	private Byte isStillAvailable;
	
	
}
