package nz.co.maveros.auto.ghost.model.page;

public class PostEditPage extends AbstractPage {
	private String title;
	private String body;

	public PostEditPage(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

}
