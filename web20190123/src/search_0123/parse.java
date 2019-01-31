package search_0123;

public class parse {
	private String title;
	private String description;
	private String link;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[Title=");
		builder.append(title);
		builder.append(", Description=");
		builder.append(description);
		builder.append(", Link=");
		builder.append(link);
		builder.append("]");
		
		return builder.toString();
	}
	
}
