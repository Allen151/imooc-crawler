package bean;

import java.util.List;

public class Way {
	private String pid;
	private String name;
	private List<Course> list;
	
	public final String getPid() {
		return pid;
	}
	public final void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getList() {
		return list;
	}
	public void setList(List<Course> list) {
		this.list = list;
	}
	
	
}
