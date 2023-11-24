package com.psychoamj.aj4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.psychoamj.aj4.constants.BookConstants;
import com.psychoamj.aj4.models.Authors;
import com.psychoamj.aj4.models.Book;
import com.psychoamj.aj4.models.Details;
import com.psychoamj.aj4.models.IntroWords;
import com.psychoamj.aj4.models.Publication;

@ExtendWith(MockitoExtension.class)
public class BookTests {

	@Mock
	private Authors authors;
	@Mock
	private Details details;
	@Mock
	private Publication publication;
	@Mock
	private IntroWords introWords1;
	@Mock
	private IntroWords introWords2;

	private Validator validator;
	private Book emptyBook;
	private static ValidatorFactory factory;
	private List<IntroWords> listOfIntroWords;
	
	@BeforeEach
	public void setUp() {
		factory = Validation.buildDefaultValidatorFactory();
		listOfIntroWords = new ArrayList<>();
		validator = factory.getValidator();
		emptyBook = new Book();
	}

	// id test methods

	@Test
	public void shouldSetAndRetrieveIdMatches() {
		Integer id = 1;
		emptyBook.setId(id);

		assertEquals(id, emptyBook.getId());
	}

	@Test
	public void shouldFailWhenIdIsNull() {
		emptyBook.setId(null);

		assertFieldValidationMessage(emptyBook, BookConstants.NOT_NULL_MESSAGE);
	}

	// authors test methods

	@Test
	public void shouldSetAndRetrieveAuthorsMatches() {
		emptyBook.setAuthors(authors);

		assertEquals(authors, emptyBook.getAuthors());
	}

	@Test
	public void shouldSetAndRetrieveAuthorsMatchesWhenAuthorsAreNull() {
		authors = null;
		emptyBook.setAuthors(authors);

		assertEquals(authors, emptyBook.getAuthors());
	}

	// details test methods

	@Test
	public void shouldSetAndRetrieveDetailsMatches() {
		emptyBook.setDetails(details);

		assertEquals(details, emptyBook.getDetails());
	}

	@Test
	public void shouldFailWhenDetailsIsNull() {
		emptyBook.setDetails(null);

		assertFieldValidationMessage(emptyBook, BookConstants.NOT_NULL_MESSAGE);
	}

	// publication test methods

	@Test
	public void shouldSetAndRetrievePublicationMatches() {
		emptyBook.setPublication(publication);

		assertEquals(publication, emptyBook.getPublication());
	}

	@Test
	public void shouldFailWhenPublicationIsNull() {
		emptyBook.setPublication(null);

		assertFieldValidationMessage(emptyBook, BookConstants.NOT_NULL_MESSAGE);
	}

	// introWords test methods

	@Test
	public void shouldSetAndRetrieveIntroWordsMatches() {
		listOfIntroWords.add(introWords1);
		listOfIntroWords.add(introWords2);
		
		emptyBook.setIntroWords(listOfIntroWords);
		
		assertEquals(listOfIntroWords, emptyBook.getIntroWords());
	}
	
	@Test
	public void shouldSetAndRetrieveIntroWordsMatchesWhenIntroWordsAreNull() {
		emptyBook.setIntroWords(null);
		
		assertEquals(null, emptyBook.getIntroWords());
	}
	
	// title test methods
	
	@Test
	public void shouldSetAndRetrieveTitleMatches() {
		String title = "Okiem młodego poety";
		emptyBook.setTitle(title);
		
		assertEquals(title, emptyBook.getTitle());
	}
	
	@Test
	public void shouldFailWhenTitleIsBlank() {
		emptyBook.setTitle("");
		
		assertFieldValidationMessage(emptyBook, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenTitleIsTooShort() {
		emptyBook.setTitle("A");
		
		assertFieldValidationMessage(emptyBook, BookConstants.TITLE_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenTitleIsTooLong() {
		emptyBook.setTitle("A".repeat(60));
		
		assertFieldValidationMessage(emptyBook, BookConstants.TITLE_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenTitleIsNull() {
		emptyBook.setTitle(null);
		
		assertFieldValidationMessage(emptyBook, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	// isStillAvailable test methods

	@Test
	public void shouldSetAndRetrieveIsStillAvailableMatches(){
		Byte IsStillAvailable = 1;
		emptyBook.setIsStillAvailable(IsStillAvailable);
		
		assertEquals(IsStillAvailable, emptyBook.getIsStillAvailable());
	}
	
	@Test
	public void shouldFailWhenStillAvailableIsLessThanMin() {
		emptyBook.setIsStillAvailable((byte) -1);
		
		assertFieldValidationMessage(emptyBook, BookConstants.IS_STILL_AVAILABLE_MIN_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenStillAvailableIsGreaterThanMax() {
		emptyBook.setIsStillAvailable((byte) 2);
		
		assertFieldValidationMessage(emptyBook, BookConstants.IS_STILL_AVAILABLE_MAX_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenStillAvailableIsNull() {
		emptyBook.setIsStillAvailable(null);
		
		assertFieldValidationMessage(emptyBook, BookConstants.NOT_NULL_MESSAGE);
	}
	
	// Other methods
	private void assertFieldValidationMessage(Book book, String expectedMessage) {
		try {
			validator.validate(book);
		} catch (ConstraintViolationException exception) {
			ConstraintViolation<?> violation = exception.getConstraintViolations().iterator().next();
			assertEquals(expectedMessage, violation.getMessage());
		}

	}
}
