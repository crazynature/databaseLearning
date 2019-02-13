package edu.northeastern.cs5200.models;

public class YouTubeWidget extends Widget {

	private int widgetId;
	private String url;
	private boolean shareable;
	private boolean expandable;
	private String type = "YOUTUBE";
	
	
	public YouTubeWidget(int id, String name, int width, int height,
			String cssClass, String cssStyle,
			String text, int order,String url, 
			boolean shareable, boolean expandable) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
		this.widgetId = id;
	}
	

	public int getWidgetId() {
		return widgetId;
	}
	
	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean getShareable() {
		return shareable;
	}
	
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	
	public boolean getExpandable() {
		return expandable;
	}
	
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	
	public String getType() {
		return type;
	}
}
