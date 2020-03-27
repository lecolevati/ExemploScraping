package controller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YoutubeParsingService {

	public List<String> youtubeParsing(String htmlCode) {
		String regex = "href=\\\"(https:\\/\\/www.y\\w+.\\w+\\/\\w+\\?\\w+=\\w+)\"";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(htmlCode);
		
		List<String> listaYoutube = new ArrayList<String>();
		int i = 0;
		
		while (matcher.find()) {
			if (i % 2 == 0) {
				listaYoutube.add(matcher.group(1));
			}
			i++;
		}
		
		return listaYoutube;
	}
	
}
