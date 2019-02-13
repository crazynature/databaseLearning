package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;

public class WidgetDao implements Widgetlmpl{

	public static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if (instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	private final String INSERT_WIDGET = "INSERT INTO widget (id, page_id, name, width, height, css_class, css_style, text, `order`, size, html, src, url, sharable, expandable,DTYPE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String FIND_ALL_WIDGET = "SELECT * FROM widget";
	private final String FIND_WIDGET_BY_ID = "SELECT * FROM widget WHERE widget.id = ";
	private final String FIND_WIDGET_BY_PAGEID = "SELECT * FROM widget WHERE page_id = ";
	private final String UPDATE_WIDGET = "UPDATE widget SET id=?, page_id=?, name=?, width=?, height=?, css_class=?, css_style=?, text=?, `order`=?, size=?, html=?, src=?, url=?, sharable=?, expandable=? , DTYPE =? WHERE widget.id=?";
	private final String DELETE_WIDGET = "DELETE FROM widget WHERE widget.id = ";
	
	public void createWidgetForPage(int pageId, Widget widget) throws SQLException, ClassNotFoundException {		
		java.sql.Connection conn = Connection.getConnection();		
		PreparedStatement response = conn.prepareStatement(INSERT_WIDGET);
		response.setInt(1, widget.getId());
		response.setInt(2, widget.getPageId());
		response.setString(3, widget.getName());
		response.setInt(4, widget.getWidth());
		response.setInt(5, widget.getHeight());
		response.setString(6, widget.getCssClass());
		response.setString(7, widget.getCssStyle());
		response.setString(8, widget.getText());
		response.setInt(9, widget.getOrder());
		response.setNull(10, java.sql.Types.INTEGER);
		response.setNull(11, java.sql.Types.VARCHAR);
		response.setNull(12, java.sql.Types.VARCHAR);
		response.setNull(13, java.sql.Types.VARCHAR);
		response.setNull(14, java.sql.Types.BOOLEAN);
		response.setNull(15, java.sql.Types.BOOLEAN);
		switch(widget.getType()) {
			case "HEADING":
				HeadingWidget header = (HeadingWidget) widget;
				response.setInt(10, header.getSize());
				response.setString(16, header.getType());
				break;
			case "HTML":
				HtmlWidget html = (HtmlWidget) widget;
				response.setString(11, html.getHtml());
				response.setString(16, html.getType());
				break;
			case "IMAGE":
				ImageWidget image = (ImageWidget) widget;
				response.setString(12, image.getSrc());
				response.setString(16, image.getType());
				break;
			case "YOUTUBE":
				YouTubeWidget youtube = (YouTubeWidget) widget;
				response.setString(13, youtube.getUrl());
				response.setBoolean(14, youtube.getShareable());
				response.setBoolean(15, youtube.getExpandable());
				response.setString(16, youtube.getType());
		}
		response.executeUpdate();
		response.close();
		conn.close();
	}
	
	
	public Collection<Widget> findWidgetsForPage(int pageId) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		ResultSet result = response.executeQuery(FIND_WIDGET_BY_PAGEID+String.valueOf(pageId));
		Collection<Widget> widgets = new ArrayList<Widget>();
		while (result.next()) {
			Widget widget = null;
			switch (result.getString("DTYPE")) {
				case "HEADING":
					widget = new HeadingWidget(result.getInt("id"),
							result.getString("name"), 
							 result.getInt("width"), 
							 result.getInt("height"), 
							 result.getString("css_class"), 
							 result.getString("css_style"), 
							result.getString("text"), 
							result.getInt("order"),
							result.getInt("size"));
					widget.setPageId(result.getInt("page_id"));
					break;
				case "IMAGE":
					widget = new ImageWidget(result.getInt("id"),
							result.getString("name"), 
							 result.getInt("width"), 
							 result.getInt("height"), 
							 result.getString("css_class"), 
							 result.getString("css_style"), 
							result.getString("text"), 
							result.getInt("order"),
							result.getString("src"));
					widget.setPageId(result.getInt("page_id"));
					break;
				case "HTML":
					widget = new HtmlWidget(result.getInt("id"),
							result.getString("name"), 
							 result.getInt("width"), 
							 result.getInt("height"), 
							 result.getString("css_class"), 
							 result.getString("css_style"), 
							result.getString("text"), 
							result.getInt("order"),
							result.getString("html"));
					widget.setPageId(result.getInt("page_id"));
					break;
				case "YOUTUBE":
					widget = new YouTubeWidget(result.getInt("id"),
							result.getString("name"), 
							 result.getInt("width"), 
							 result.getInt("height"), 
							 result.getString("css_class"), 
							 result.getString("css_style"), 
							result.getString("text"), 
							result.getInt("order"),
							result.getString("url"),
							result.getBoolean("sharable"),
							result.getBoolean("expandable"));
					widget.setPageId(result.getInt("page_id"));
					break;
			}
			widgets.add(widget);
		}
		
		response.close();
		conn.close();
		return widgets;
	}
	

	public Collection<Widget> findAllWidgets() throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		Collection<Widget> widgets = new ArrayList<Widget>();
		ResultSet result = response.executeQuery(FIND_ALL_WIDGET);
		while (result.next()) {
			Widget widget = null;
			switch (result.getString("DTYPE")) {
			case "HEADING":
				widget = new HeadingWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getInt("size"));
				widget.setPageId(result.getInt("page_id"));
				break;
			case "IMAGE":
				widget = new ImageWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getString("src"));
				widget.setPageId(result.getInt("page_id"));
				break;
			case "HTML":
				widget = new HtmlWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getString("html"));
				widget.setPageId(result.getInt("page_id"));
				break;
			case "YOUTUBE":
				widget = new YouTubeWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getString("url"),
						result.getBoolean("sharable"),
						result.getBoolean("expandable"));
				widget.setPageId(result.getInt("page_id"));
				break;
		}
			widgets.add(widget);
		}
		
		response.close();
		conn.close();
		return widgets;
	}
	
	public Widget findWidgetById(int widgetId) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		ResultSet result = response.executeQuery(FIND_WIDGET_BY_ID+String.valueOf(widgetId));
		Widget widget = null;
		if (result.next()) {
			switch (result.getString("DTYPE")) {
			case "HEADING":
				widget = new HeadingWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getInt("size"));
				widget.setPageId(result.getInt("page_id"));
				break;
			case "IMAGE":
				widget = new ImageWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getString("src"));
				widget.setPageId(result.getInt("page_id"));
				break;
			case "HTML":
				widget = new HtmlWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getString("html"));
				widget.setPageId(result.getInt("page_id"));
				break;
			case "YOUTUBE":
				widget = new YouTubeWidget(result.getInt("id"),
						result.getString("name"), 
						 result.getInt("width"), 
						 result.getInt("height"), 
						 result.getString("css_class"), 
						 result.getString("css_style"), 
						result.getString("text"), 
						result.getInt("order"),
						result.getString("url"),
						result.getBoolean("sharable"),
						result.getBoolean("expandable"));
				widget.setPageId(result.getInt("page_id"));
				break;
		}
		}
		response.close();
		conn.close();
		return widget;
	}

	public int updateWidget(int widgetId, Widget widget) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();		
		PreparedStatement response = conn.prepareStatement(UPDATE_WIDGET);
		response.setInt(1, widget.getId());
		response.setInt(2, widget.getPageId());
		response.setString(3, widget.getName());
		response.setInt(4, widget.getWidth());
		response.setInt(5, widget.getHeight());
		response.setString(6, widget.getCssClass());
		response.setString(7, widget.getCssStyle());
		response.setString(8, widget.getText());
		response.setInt(9, widget.getOrder());
		response.setNull(10, java.sql.Types.INTEGER);
		response.setNull(11, java.sql.Types.VARCHAR);
		response.setNull(12, java.sql.Types.VARCHAR);
		response.setNull(13, java.sql.Types.VARCHAR);
		response.setNull(14, java.sql.Types.BOOLEAN);
		response.setNull(15, java.sql.Types.BOOLEAN);
		response.setInt(17, widgetId);
		switch(widget.getType()) {
			case "HEADING":
				HeadingWidget header = (HeadingWidget) widget;
				response.setInt(10, header.getSize());
				response.setString(16, header.getType());
				break;
			case "HTML":
				HtmlWidget html = (HtmlWidget) widget;
				response.setString(11, html.getHtml());
				response.setString(16, html.getType());
				break;
			case "IMAGE":
				ImageWidget image = (ImageWidget) widget;
				response.setString(12, image.getSrc());
				response.setString(16, image.getType());
				break;
			case "YOUTUBE":
				YouTubeWidget youtube = (YouTubeWidget) widget;
				response.setString(13, youtube.getUrl());
				response.setBoolean(14, youtube.getShareable());
				response.setBoolean(15, youtube.getExpandable());
				response.setString(16, youtube.getType());
		}
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}
	
	public int deleteWidget(int widgetId) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		int result = response.executeUpdate(DELETE_WIDGET+String.valueOf(widgetId));
		response.close();
		conn.close();
		return result;
		
	}

	
}
