package edu.northeastern.cs5200.models;

public class HtmlWidget extends Widget {
	
	private int widgetId;
	private String html;
	private String type ="HTML";
	
	public HtmlWidget(int id, String name, 
			int width, int height, String cssClass, String cssStyle,
			String text, int order,String html) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.html = html;
		this.widgetId = id;
	}
	
	public HtmlWidget() {
		super();
	}
	
	public int getWidgetId() {
		return widgetId;
	}
	
	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}
	
	public HtmlWidget(String html) {
		super();
		this.html = html;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	public String getType() {
		return type;
	}
}
