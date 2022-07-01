package com.myhome.other;

public class Constants {

	public static class API {
		/* Top level */
		public static final String URL_ACCOUNT = "/account";
		public static final String URL_CLEANING = "/cleaning";
		public static final String URL_HOUSE = "/house";
		public static final String URL_ITEM = "/item";
		public static final String URL_MEAL = "/meal";
		public static final String URL_MEMBER = "/member";
		public static final String URL_RATING = "/rating";
		public static final String URL_RECIPE = "/recipe";
		public static final String URL_ROOM = "/room";
		public static final String URL_SHOPPINGLIST = "/shopping-list";

		public static class CRUD {
			/* Account specific */
			public static final String URL_LOGIN = "/login";
			public static final String URL_REGISTER = "/register";

			public static final String URL_GET = "/get";
			public static final String URL_ADD = "/add";
			public static final String URL_DELETE = "/delete";
			public static final String URL_UPDATE = "/update";
		}

		public static class RESPONSE {
			public static final String SUCCESS = "Success!";
			public static final String SOMETHING_WRONG = "Oops! Something went wrong!";
			public static final String INVALID_PASSWORD = "Entered E-Mail and/or Password invalid";
			public static final String INVALID_SENTENCE = "Entered E-Mail and/or Validation Sentence invalid";
			public static final String ALREADY_EXISTS = "The entered E-Mail address already exists!";

			public static final String EMAIL_NOT_NULL = "E-Mail can not be null!";
			public static final String PASSWORD_NOT_NULL = "Password can not be null!";
			public static final String VALIDATION_SENTENCE_NOT_NULL = "Validation sentence can not be null!";
			public static final String TITLE_NOT_NULL = "Title and/or description can not be null!";
			public static final String NOT_EXISTS = "The requested entity/entities is null.";
			public static String INVALID_TOKEN = "The entered token is invalid";
		}


		public static final String URL_ALL = "-all";

		public static final String URL_PW_FORGOTTEN = "/forgotten-password";
	}



	/* Database information */
	public static final String DB_ACCOUNT = "account";
	public static final String DB_QUESTION = "question";
	public static final String DB_COMMENT = "comment";
	public static final String DB_THREAD = "thread";

	public static final String TYPE_JSON = "application/json";

}
