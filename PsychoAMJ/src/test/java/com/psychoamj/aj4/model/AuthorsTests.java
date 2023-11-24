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
import com.psychoamj.aj4.models.Authors;

public class AuthorsTests {
	private Validator validator;
	private Authors emptyAuthors;
	private static ValidatorFactory factory;
	
	@BeforeEach
	public void setUp() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		emptyAuthors = new Authors();
	}

	// authorsId test methods

	@Test
	public void shouldSetAndRetrieveAuthorsIdMatches() {
		Integer authorsId = 1;
		emptyAuthors.setAuthorsId(authorsId);

		assertEquals(authorsId, emptyAuthors.getAuthorsId());
	}

	@Test
	public void shouldFailWhenAuthorsIdIsNull() {
		emptyAuthors.setAuthorsId(null);
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_NULL_MESSAGE);
	}
	
	//imageMaker test methods
	
	@Test
	public void shouldSetAndRetrieveImageMakerMatches() {
		String imageMaker = "Leonardo da Vinci";
		emptyAuthors.setImageMaker(imageMaker);
		
		assertEquals(imageMaker, emptyAuthors.getImageMaker());
	}
	
	@Test
	public void shouldFailWhenImageMakerIsBlank() {
		emptyAuthors.setImageMaker("");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenImageMakerIsTooShort() {
		emptyAuthors.setImageMaker("A");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.IMAGE_MAKER_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenImageMakerIsTooLong() {
		emptyAuthors.setImageMaker("A".repeat(51));
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.IMAGE_MAKER_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenImageMakerIsNull() {
		emptyAuthors.setImageMaker(null);
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	//coverDeveloper test methods
	
	@Test
	public void shouldSetAndRetrieveCoverDeveloperMatches() {
		String coverDeveloper = "Leonardo da Vinci";
		emptyAuthors.setCoverDeveloper(coverDeveloper);
		
		assertEquals(coverDeveloper, emptyAuthors.getCoverDeveloper());
	}
	
	@Test
	public void shouldFailWhenCoverDeveloperIsBlank() {
		emptyAuthors.setCoverDeveloper("");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenCoverDeveloperIsTooShort() {
		emptyAuthors.setCoverDeveloper("A");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.COVER_DEVELOPER_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenCoverDeveloperIsTooLong() {
		emptyAuthors.setCoverDeveloper("A".repeat(51));
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.COVER_DEVELOPER_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenCoverDeveloperIsNull() {
		emptyAuthors.setCoverDeveloper(null);
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	//illustrator test methods
	
	@Test
	public void shouldSetAndRetrieveIllustratorMatches() {
		String illustrator = "Leonardo da Vinci";
		emptyAuthors.setIllustrator(illustrator);
		
		assertEquals(illustrator, emptyAuthors.getIllustrator());
	}
	
	@Test
	public void shouldFailWhenIllustratorIsBlank() {
		emptyAuthors.setIllustrator("");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenIllustratorIsTooShort() {
		emptyAuthors.setIllustrator("A");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.ILLUSTRATOR_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenIllustratorIsTooLong() {
		emptyAuthors.setIllustrator("A".repeat(51));
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.ILLUSTRATOR_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenIllustratorIsNull() {
		emptyAuthors.setIllustrator(null);
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	//writers test methods
	
	@Test
	public void shouldSetAndRetrieveWritersMatches() {
		String writers = "Leonardo da Vinci";
		emptyAuthors.setWriters(writers);
		
		assertEquals(writers, emptyAuthors.getWriters());
	}
	
	@Test
	public void shouldFailWhenWritersIsBlank() {
		emptyAuthors.setWriters("");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenWritersIsTooShort() {
		emptyAuthors.setWriters("A");
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.WRITERS_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenWritersIsTooLong() {
		emptyAuthors.setWriters("A".repeat(1001));
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.WRITERS_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenWritersIsNull() {
		emptyAuthors.setWriters(null);
		
		assertFieldValidationMessage(emptyAuthors, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	//Other methods:
	
	private void assertFieldValidationMessage(Authors authors, String expectedMessage) {
		try {
			validator.validate(authors);	
		} catch (ConstraintViolationException exception) {
			ConstraintViolation<?> violation = exception.getConstraintViolations().iterator().next();
			assertEquals(expectedMessage, violation.getMessage());
		}	
	}
}
