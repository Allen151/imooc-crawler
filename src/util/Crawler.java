package util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.Course;
import bean.Way;

public class Crawler {
	
	public static Way start(String pid) {
		Way way = new Way();
		way.setPid(pid);
		try {
			String url = "http://www.imooc.com/course/programdetail/pid/" + pid;
			Document document = Jsoup.connect(url).get();
			String name = document.getElementsByTag("h2").text();
			way.setName(name);
			List<Course> list = new ArrayList<>();
			Elements elements = document.getElementsByClass("step-item");
			for (Element element : elements) {
				Course course = new Course();
				String title = element.getElementsByTag("h4").text().trim();
				if (title.equals("")) {
					title = element.getElementsByClass("hd l").text().trim();
				}
				course.setTitle(title);
				List<String> liteTitle = new ArrayList<>();
				Elements e = element.getElementsByTag("h3");
				for (Element ee : e) {
					liteTitle.add(ee.text().trim());
				}
				course.setLiteTitle(liteTitle);
				list.add(course);
				
			}
			way.setList(list);
			return way;
		} catch (HttpStatusException e) {
			if (e.getStatusCode() == 404) {
				way.setName("404");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("≈¿≥Êpid"+pid+"ÕÍ≥…");
		return way;
	}
}
