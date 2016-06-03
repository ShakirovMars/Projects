function ChangeLanguage( language) {
	
	if (language == "ru") {

		document.cookie="lang=ru; path=/Auto/";
		
	} else {
		if (language == "en") {

			document.cookie="lang =en; path=/Auto/";

		}

	}
	 location.reload();

}