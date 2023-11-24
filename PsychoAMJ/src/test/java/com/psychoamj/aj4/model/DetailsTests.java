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
import com.psychoamj.aj4.models.Details;

public class DetailsTests {
	private Validator validator;
	private Details emptyDetails;
	private static ValidatorFactory factory;

	@BeforeEach
	public void setUp() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		emptyDetails = new Details();
	}

	// detailsId test methods

	@Test
	public void shouldSetAndRetrieveDetailsIdMatches() {
		Integer detailsId = 1;
		emptyDetails.setDetailsId(detailsId);

		assertEquals(detailsId, emptyDetails.getDetailsId());
	}

	@Test
	public void shouldFailWhenDetailsIdIsNull() {
		emptyDetails.setDetailsId(null);

		assertFieldValidationMessage(emptyDetails, BookConstants.NOT_NULL_MESSAGE);
	}

	// pageCount test methods

	@Test
	public void shouldSetAndRetrievePageCountMatches() {
		Short pageCount = 1;
		emptyDetails.setPageCount(pageCount);

		assertEquals(pageCount, emptyDetails.getPageCount());
	}

	@Test
	public void shouldFailWhenPageCountIsNull() {
		emptyDetails.setPageCount(null);

		assertFieldValidationMessage(emptyDetails, BookConstants.NOT_NULL_MESSAGE);
	}

	@Test
	public void shouldFailWhenPageCountIsGreaterThanMax() {
		emptyDetails.setPageCount((short) 2001);

		assertFieldValidationMessage(emptyDetails, BookConstants.PAGE_COUNT_MAX_MESSAGE);
	}

	@Test
	public void shouldFailWhenStillAvailableIsLessThanMin() {
		emptyDetails.setPageCount((short) 1);

		assertFieldValidationMessage(emptyDetails, BookConstants.PAGE_COUNT_MIN_MESSAGE);
	}

	// category test methods
	
	@Test
	public void shouldSetAndRetrieveCategoryMatches() {
		String category = "category";
		emptyDetails.setCategory(category);		
		
		assertEquals(category, emptyDetails.getCategory());
	}
	
	@Test
	public void shouldFailWhenCategoryIsNull() {
		emptyDetails.setCategory(null);

		assertFieldValidationMessage(emptyDetails, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenCategoryIsBlank() {
		emptyDetails.setCategory("");
		
		assertFieldValidationMessage(emptyDetails, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenCategoryIsTooShort() {
		emptyDetails.setCategory("A");
		
		assertFieldValidationMessage(emptyDetails, BookConstants.CATEGORY_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenCategoryIsTooLong() {
		emptyDetails.setCategory("A".repeat(51));
		
		assertFieldValidationMessage(emptyDetails, BookConstants.CATEGORY_LENGTH_MESSAGE);
	}
	
	//aboutBook test methods
	
	@Test
	public void shouldSetAndRetrieveAboutBookMatches() {
		String aboutBook = "aboutBook";
		emptyDetails.setAboutBook(aboutBook);		
		
		assertEquals(aboutBook, emptyDetails.getAboutBook());
	}
	
	@Test
	public void shouldFailWhenAboutBookIsNull() {
		String aboutBook = null;
		emptyDetails.setAboutBook(aboutBook);

		assertFieldValidationMessage(emptyDetails, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenAboutBookIsBlank() {
		String aboutBook = "";
		emptyDetails.setAboutBook(aboutBook);
		
		assertFieldValidationMessage(emptyDetails, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenAboutBookIsTooShort() {
		emptyDetails.setAboutBook("A");
		
		assertFieldValidationMessage(emptyDetails, BookConstants.ABOUT_BOOK_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenAboutBookIsTooLong() {
		emptyDetails.setAboutBook("A".repeat(501));
		
		assertFieldValidationMessage(emptyDetails, BookConstants.ABOUT_BOOK_LENGTH_MESSAGE);
	}
	
	// Other methods
	private void assertFieldValidationMessage(Details details, String expectedMessage) {
		try {
			validator.validate(details);
		} catch (ConstraintViolationException exception) {
			ConstraintViolation<?> violation = exception.getConstraintViolations().iterator().next();
			assertEquals(expectedMessage, violation.getMessage());
		}

	}
}
