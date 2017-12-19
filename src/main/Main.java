package main;

import java.util.ArrayList;
import java.util.List;

import bean.Course;
import bean.Way;
import util.Crawler;

public class Main {

	//url:http://www.imooc.com/course/programdetail/pid/1
	//目前只到60
	public static void main(String[] args) {
		
		List<Way> ways = new ArrayList<>();
		for (int i = 1; i < 61; i++) {
			Way w = Crawler.start(i+"");
			ways.add(w);
		}
		for (Way way : ways) {
			System.out.println("pid：" + way.getPid() + "    " + "路径名：" + way.getName());
			if (way.getName().equals("404")) {
				
			} else {
				for (Course course : way.getList()) {
					System.out.println("   " + course.getTitle());
					for (String string : course.getLiteTitle()) {
						System.out.println("      "+string);
					}
				}
			}
			System.out.println();
		}
		
	}

}
