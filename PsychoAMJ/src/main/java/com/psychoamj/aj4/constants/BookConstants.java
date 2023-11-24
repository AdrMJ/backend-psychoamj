package com.psychoamj.aj4.constants;

public class BookConstants {

	// Messages by variable in Book class
	public static final String TITLE_LENGTH_MESSAGE = "The length of the title must be between 3 and 100 characters";
	public static final String IS_STILL_AVAILABLE_MIN_MESSAGE = "The value of \"is still available\" must be at least 0";
	public static final String IS_STILL_AVAILABLE_MAX_MESSAGE = "The value of \"is still available\" cannot be more than 1";

	// Messages by variable in Authors class
	public static final String IMAGE_MAKER_LENGTH_MESSAGE = "The length of the image maker must be between 3 and 50 characters";
	public static final String COVER_DEVELOPER_LENGTH_MESSAGE = "The length of the cover developer must be between 3 and 50 characters";
	public static final String ILLUSTRATOR_LENGTH_MESSAGE = "The length of the illustrator must be between 3 and 50 characters";
	public static final String WRITERS_LENGTH_MESSAGE = "The length of the writers must be between 3 and 1000 characters";

	// Messages by variable in Details class
	public static final String CATEGORY_LENGTH_MESSAGE = "The length of the category must be between 3 and 50 characters";
	public static final String PAGE_COUNT_MIN_MESSAGE = "The page count must be at least 22";
	public static final String PAGE_COUNT_MAX_MESSAGE = "The page count cannot be more than 2000";
	public static final String ABOUT_BOOK_LENGTH_MESSAGE = "The length of the \"aboutBook\" must be between 3 and 500";

	//Messages by variable in IntroWords class
	public static final String INTRO_WORDS_LENGTH_MESSAGE = "The length of the \"intro words\" must be between 3 and 50 characters";
	public static final String AUTHOR_OF_WORDS_LENGTH_MESSAGE = "The length of the \"author of the words\" must be between 3 and 50 characters";
	
	// Messages by variable in Publisher class
	public static final String PUBLISHER_LENGTH_MESSAGE = "The length of the publisher must be between 3 and 50 characters";
	public static final String LANGUAGE_LENGTH_MESSAGE = "The length of the length must be between 3 and 50 characters";

	// Messages by annotations
	public static final String NOT_BLANK_MESSAGE = "Can not be blank!";
	public static final String NOT_NULL_MESSAGE = "Can not be null!";

	public static final String CORRECT_DATE_MESSAGE = "The correct date is between 2020.05.12 and ";
	
	//Messages by exceptions
	public static final String ENTITY_EXISTS = "A book with the same ID already exists.";
	public static final String ENTITY_NOT_EXISTS = "A book with this ID not exists.";
	public static final String NO_SUCH_ELEMENT_EXCEPTION = "The value of \'intro words\', with that id, does not exist!";
}
