package bean;

import java.util.List;

public class Course {
	private String title;
	private List<String> liteTitle;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public final List<String> getLiteTitle() {
		return liteTitle;
	}
	public final void setLiteTitle(List<String> liteTitle) {
		this.liteTitle = liteTitle;
	}
	
}
