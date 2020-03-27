package view;

import java.util.List;

import controller.service.GoogleScrapingService;
import controller.service.YoutubeParsingService;

public class Main {
	/*
	 * Esse projeto faz uma consulta no google, muda para a aba de videos e 
	 * retorna as URL dos videos da primeira página que estão no Youtube
	 * Outros servidores são ignorados
	 */

	public static void main(String[] args) {
		String consulta = "Web Scraping";
		
		GoogleScrapingService gss = new GoogleScrapingService();
		YoutubeParsingService yps = new YoutubeParsingService();
		try {
			String htmlCode = gss.googleScraping(consulta);
			List<String> youtubeList = yps.youtubeParsing(htmlCode);
			youtubeList.forEach(System.out::println);
//			A linha acima equivale a:
//			for (String s : youtubeList) {
//				System.out.println(s);
//			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
