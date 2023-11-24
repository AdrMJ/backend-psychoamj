package com.psychoamj.aj4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.psychoamj.aj4.constants.BookConstants;
import com.psychoamj.aj4.models.IntroWords;

public class IntroWordsTests {
	private Validator validator;
	private IntroWords emptyIntroWords;
	private static ValidatorFactory factory;

	@BeforeEach
	public void setUp() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		emptyIntroWords = new IntroWords();
	}
	
	//introWordsId test methods
	
	@Test
	public void shouldSetAndRetrieveIntroWordsIdMatches() {
		Integer introWordsId = 1;
		emptyIntroWords.setIntroWordsId(introWordsId);

		assertEquals(introWordsId, emptyIntroWords.getIntroWordsId());
	}

	@Test
	public void shouldFailWhenIntroWordsIdIsNull() {
		emptyIntroWords.setIntroWordsId(null);

		assertFieldValidationMessage(emptyIntroWords, BookConstants.NOT_NULL_MESSAGE);
	}
	
	//introWords test methods

	@Test
	public void shouldSetAndRetrieveIntroWordsMatches() {
		String introWords = "introWords";
		emptyIntroWords.setIntroWords(introWords);;		
		
		assertEquals(introWords, emptyIntroWords.getIntroWords());
	}
	
	@Test
	public void shouldFailWhenIntroWordsIsNull() {
		emptyIntroWords.setIntroWords(null);

		assertFieldValidationMessage(emptyIntroWords, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenIntroWordsIsBlank() {
		emptyIntroWords.setIntroWords("");
		
		assertFieldValidationMessage(emptyIntroWords, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenIntroWordsIsTooShort() {
		emptyIntroWords.setIntroWords("A");
		
		assertFieldValidationMessage(emptyIntroWords, BookConstants.INTRO_WORDS_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenIntroWordsIsTooLong() {
		emptyIntroWords.setIntroWords("A".repeat(2001));
		
		assertFieldValidationMessage(emptyIntroWords, BookConstants.INTRO_WORDS_LENGTH_MESSAGE);
	}
	
	//authorOfWords test methods
	
	@Test
	public void shouldSetAndRetrieveAuthorOfWordsMatches() {
		String authorOfWords = "FirstName And LastName";
		emptyIntroWords.setAuthorOfWords(authorOfWords);;		
		
		assertEquals(authorOfWords, emptyIntroWords.getAuthorOfWords());
	}
	
	@Test
	public void shouldFailWhenAuthorOfWordsIsNull() {
		emptyIntroWords.setAuthorOfWords(null);

		assertFieldValidationMessage(emptyIntroWords, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenAuthorOfWordsIsBlank() {
		emptyIntroWords.setAuthorOfWords("");
		
		assertFieldValidationMessage(emptyIntroWords, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenAuthorOfWordsIsTooShort() {
		emptyIntroWords.setAuthorOfWords("A");
		
		assertFieldValidationMessage(emptyIntroWords, BookConstants.AUTHOR_OF_WORDS_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenAuthorOfWordsIsTooLong() {
		emptyIntroWords.setAuthorOfWords("A".repeat(101));
		
		assertFieldValidationMessage(emptyIntroWords, BookConstants.AUTHOR_OF_WORDS_LENGTH_MESSAGE);
	}
	
	// Other methods
		private void assertFieldValidationMessage(IntroWords introWords, String expectedMessage) {
			try {
				validator.validate(emptyIntroWords);
			} catch (ConstraintViolationException exception) {
				ConstraintViolation<?> violation = exception.getConstraintViolations().iterator().next();
				assertEquals(expectedMessage, violation.getMessage());
			}

		}
}
