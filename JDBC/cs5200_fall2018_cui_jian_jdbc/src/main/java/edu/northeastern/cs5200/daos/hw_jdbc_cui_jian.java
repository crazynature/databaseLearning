package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.PageRole;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.Role;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;


public class hw_jdbc_cui_jian {

	
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Executing Commands...");
		// Creates 
		Developer developer1 = new Developer(12, "Alice", "Wonder", "alice", "wonder", "alice@wonder", null, "4321rewq");
		Developer developer2 = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley", null, "5432trew");
		Developer developer3 = new Developer(34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia", null, "6543ytre");
		User user1 = new User(45, "Dan", "Martin");
		User user2 = new User(56, "Ed", "Karaz");
		
		DeveloperImpl develooper =  DeveloperDao.getInstance();
		UserDao user = UserDao.getInstance();
//developer update		
		develooper.createDeveloper(developer1);
		develooper.createDeveloper(developer2);
		develooper.createDeveloper(developer3);

//	 user update	
		user.createUser(user1);
		user.createUser(user2);
		System.out.println("person finish");
		
		Website website1 = new Website(123,"Facebook", "an online social media and social networking service",null,null, 1234234);
		website1.setDeveloperId(developer1.getId());
		website1.setDeveloper(developer1);
		Website website2 = new Website(234, "Twitter", "an online news and social networking service", null, null,4321543);
		website2.setDeveloperId(developer2.getId());
		website2.setDeveloper(developer2);
		Website website3 = new Website(345, "Wikipedia", "a free online encyclopedia", null, null, 3456654);
		website3.setDeveloperId(developer3.getId());
		website3.setDeveloper(developer3);
		Website website4 = new Website(456, "CNN", "an American basic cable and satellite television news channel", null, null,6543345);
		website4.setDeveloperId(developer1.getId());
		website4.setDeveloper(developer1);
		Website website5 = new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",null, null, 5433455);
		website5.setDeveloperId(developer2.getId());
		website5.setDeveloper(developer2);
		Website website6 = new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics",null, null, 4322345);
		website6.setDeveloperId(developer3.getId());
		website6.setDeveloper(developer3);
		
		Websitelmpl website = WebsiteDao.getInstance();
		website.createWebsiteForDeveloper(website1.getDeveloperId(), website1);
		website.createWebsiteForDeveloper(website2.getDeveloperId(), website2);
		website.createWebsiteForDeveloper(website3.getDeveloperId(), website3);
		website.createWebsiteForDeveloper(website4.getDeveloperId(), website4);
		website.createWebsiteForDeveloper(website5.getDeveloperId(), website5);
		website.createWebsiteForDeveloper(website6.getDeveloperId(), website6);
		System.out.println("Website finish");
	
		RoleDao role = RoleDao.getInstance();
		
		role.assignWebsiteRole(developer1.getId(), website1.getId(), 0);
		role.assignWebsiteRole(developer2.getId(), website1.getId(), 1);
		role.assignWebsiteRole(developer3.getId(), website1.getId(), 2);
		
		role.assignWebsiteRole(developer2.getId(), website2.getId(), 0);
		role.assignWebsiteRole(developer3.getId(), website2.getId(), 1);
		role.assignWebsiteRole(developer1.getId(), website2.getId(), 2);
		
		role.assignWebsiteRole(developer3.getId(), website3.getId(), 0);
		role.assignWebsiteRole(developer1.getId(), website3.getId(), 1);
		role.assignWebsiteRole(developer2.getId(), website3.getId(), 2);
		
		role.assignWebsiteRole(developer1.getId(), website4.getId(), 0);
		role.assignWebsiteRole(developer2.getId(), website4.getId(), 1);
		role.assignWebsiteRole(developer3.getId(), website4.getId(), 2);
		
		role.assignWebsiteRole(developer2.getId(), website5.getId(), 0);
		role.assignWebsiteRole(developer3.getId(), website5.getId(), 1);
		role.assignWebsiteRole(developer1.getId(), website5.getId(), 2);
		
		role.assignWebsiteRole(developer3.getId(), website6.getId(), 0);
		role.assignWebsiteRole(developer1.getId(), website6.getId(), 1);
		role.assignWebsiteRole(developer2.getId(), website6.getId(), 2);
		System.out.println("Website role finish");
		
		Page page1 = new Page(123, "Home", "Landing page",new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()), 123434);
		page1.setWebsite(website5);
		page1.setWebsiteId(website5.getId());
		Page page2 = new Page(234, "About", "Website description", new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),234545);
		page2.setWebsite(website6);
		page2.setWebsiteId(website6.getId());
		Page page3 = new Page(345, "Contact", "Addresses, phones, and contact info", new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),345656);
		page3.setWebsite(website3);
		page3.setWebsiteId(website3.getId());
		Page page4 = new Page(456, "Preferences", "Where users can configure their preferences", new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),456776);
		page4.setWebsite(website4);
		page4.setWebsiteId(website4.getId());
		Page page5 = new Page(567,  "Profile", "Users can configure their personal information", new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),567878);
		page5.setWebsite(website5);
		page5.setWebsiteId(website5.getId());
		
		Pagelmpl page = PageDao.getInstance();
		page.createPageForWebsite(page1.getWebsiteId(), page1);
		page.createPageForWebsite(page2.getWebsiteId(), page2);
		page.createPageForWebsite(page3.getWebsiteId(), page3);
		page.createPageForWebsite(page4.getWebsiteId(), page4);
		page.createPageForWebsite(page5.getWebsiteId(), page5);
		System.out.println("page finish");
		
		role.assignPageRole(developer1.getId(), page1.getId(), 1);
		role.assignPageRole(developer2.getId(), page1.getId(), 4);
		role.assignPageRole(developer3.getId(), page1.getId(), 3);
//		set Page role for Home
		PageRole pageRole1 = new PageRole(page1.getId());
		pageRole1.setPageRole(developer1.getId(),  1);
		pageRole1.setPageRole(developer2.getId(), 4);
		pageRole1.setPageRole(developer3.getId(),  3);
		
		role.assignPageRole(developer2.getId(), page2.getId(), 1);
		role.assignPageRole(developer3.getId(), page2.getId(), 4);
		role.assignPageRole(developer1.getId(), page2.getId(), 3);
		
		role.assignPageRole(developer3.getId(), page3.getId(), 1);
		role.assignPageRole(developer1.getId(), page3.getId(), 4);
		role.assignPageRole(developer2.getId(), page3.getId(), 3);
		
		role.assignPageRole(developer1.getId(), page4.getId(), 1);
		role.assignPageRole(developer2.getId(), page4.getId(), 4);
		role.assignPageRole(developer3.getId(), page4.getId(), 3);
		
		role.assignPageRole(developer2.getId(), page5.getId(), 1);
		role.assignPageRole(developer3.getId(), page5.getId(), 4);
		role.assignPageRole(developer1.getId(), page5.getId(), 3);
		System.out.println("page role finish");

		HeadingWidget widget1 = new HeadingWidget(123,"head123", 0, 0, null, null, "Welcome", 0, 0);
		widget1.setPageId(page1.getId());
		widget1.setPage(page1);
		page1.addWidget(widget1);
		HtmlWidget widget2 = new HtmlWidget(234, "post234", 0, 0, null, null, "<p>Lorem</p>", 0, "<p>Lorem</p>");
		widget2.setPageId(page2.getId());
		widget2.setPage(page2);
		page2.addWidget(widget2);
		HeadingWidget widget3 = new HeadingWidget(345,  "head345", 0, 0, null, null, "Hi", 1, 0);
		widget3.setPageId(page3.getId());
		widget3.setPage(page3);
		page3.addWidget(widget3);
		HtmlWidget widget4 = new HtmlWidget(456, "intro456", 0, 0, null, null, "<h1>Hi</h1>", 2,  "<h1>Hi</h1>");
		widget4.setPageId(page3.getId());
		widget4.setPage(page3);
		page3.addWidget(widget4);
		ImageWidget widget5 = new ImageWidget(567,  "image345", 50, 100, null, null, null, 3,  "/img/567.png");
		widget5.setPageId(page3.getId());
		widget5.setPage(page3);
		page3.addWidget(widget5);
		YouTubeWidget widget6 = new YouTubeWidget(678, "video456", 400, 300, null, null, null, 0,  "https://youtu.be/h67VX51QXiQ", true, true);		
		widget6.setPageId(page4.getId());
		widget6.setPage(page4);
		page4.addWidget(widget6);
		Widgetlmpl widget = WidgetDao.getInstance();
		widget.createWidgetForPage(widget1.getPageId(), widget1);
		widget.createWidgetForPage(widget2.getPageId(), widget2);
		widget.createWidgetForPage(widget3.getPageId(), widget3);
		widget.createWidgetForPage(widget4.getPageId(), widget4);
		widget.createWidgetForPage(widget5.getPageId(), widget5);
		widget.createWidgetForPage(widget6.getPageId(), widget6);
		System.out.println("widget finish");
		
//		Update developer - Update Charlie's primary phone number to 333-444-5555
//		Update widget - Update the relative order of widget head345 on the page so that it's new order is 3. Note that the other widget's order needs to update as well
//		Update page - Append 'CNET - ' to the beginning of all CNET's page titles
//		Update roles - Swap Charlie's and Bob's role in CNET's Home page

		Phone phone1 = new Phone("333-444-5555",true);
		PhoneDao phone = PhoneDao.getInstance();
		phone.updatePrimaryPhone(developer3.getId(), phone1);
		appendCNET(website5);
		reOrderWidget(widget3, 3);
		swapRoleForPage(developer3.getId(),developer2.getId(),pageRole1,page1.getId());
		System.out.println("update finish");
		

//		Delete developer - Delete Alice's primary address
//		Delete widget - Remove the last widget in the Contact page. The last widget is the one with the highest value in the order field
//		Delete page - Remove the last updated page in Wikipedia
//		Delete website - Remove the CNET web site, as well as all related roles and privileges relating developers to the Website and Pages

		AddressDao address = AddressDao.getInstance();
		address.deletePrimaryAdderss(developer1.getId());
		removeLastWidget(page3.getId());
		removeLastPage(website3.getId());
		website.deleteWebsite(website5.getId());
		System.out.println("delete finish");
	}
	private static void swapRoleForPage(int developerId1, int developerId2,PageRole role,int pageId) throws ClassNotFoundException, SQLException {
		int role1 = role.getPageRole().get(developerId1);
		int role2 = role.getPageRole().get(developerId2);
		role.setPageRole(developerId1, role2);
		role.setPageRole(developerId2, role1);
		RoleDao roleDao = RoleDao.getInstance();
		roleDao.deletePageRole(developerId1, pageId, role1);
		roleDao.deletePageRole(developerId2, pageId, role2);
		roleDao.assignPageRole(developerId1, pageId, role2);
		roleDao.assignPageRole(developerId2, pageId, role1);
		
	}
	public static void removeLastPage(int websiteId) throws ClassNotFoundException, SQLException {
		List<Widget> widgets = new ArrayList<Widget>();
		List<Page> pages = new ArrayList<Page>();
		Pagelmpl page = PageDao.getInstance();
		pages = (List<Page>) page.findPagesForWebsite(websiteId);
		int index = 0;
		Date maxOrder=new Date(0);
		for(int i=0; i < pages.size() ; i ++ ) {
			if (maxOrder.before(pages.get(i).getUpdated())){
				index = i;
				maxOrder = pages.get(i).getUpdated();
			}
		}
		page.deletePage(pages.get(index).getId());
	}
	
	public static void removeLastWidget(int pageId) throws ClassNotFoundException, SQLException {
		List<Widget> widgets = new ArrayList<Widget>();
		Widgetlmpl widget = WidgetDao.getInstance();
		widgets = (List<Widget>) widget.findWidgetsForPage(pageId);
		int index = 0;
		int maxOrder=-1;
		for(int i=0; i < widgets.size() ; i ++ ) {
			if (maxOrder < widgets.get(i).getOrder()){
				index = i;
				maxOrder = widgets.get(i).getOrder();
			}
		}
		widget.deleteWidget(widgets.get(index).getId());
	}
	public static void reOrderWidget(Widget target,int order) throws ClassNotFoundException, SQLException {
		int pageId = target.getPageId();
		List<Widget> widgets = new ArrayList<Widget>();
		Widgetlmpl widget = WidgetDao.getInstance();
		widgets = (List<Widget>) widget.findWidgetsForPage(pageId);
		int difference = order - target.getOrder();
		for(int i=0; i < widgets.size() ; i ++ ) {
			widgets.get(i).setOrder(widgets.get(i).getOrder()+difference);
			widget.updateWidget(widgets.get(i).getId(), widgets.get(i));
		}
		
	}
	public static void appendCNET(Website target) throws ClassNotFoundException, SQLException {
		int websiteId= target.getId();
		List<Page> pages = new ArrayList<Page>();
		Pagelmpl page = PageDao.getInstance();
		pages = (List<Page>) page.findPagesForWebsite(websiteId);
		for(int i = 0; i < pages.size(); i ++) {
			pages.get(i).setTitle("CNET - "+ pages.get(i).getTitle());
			page.updatePage(pages.get(i).getId(), pages.get(i));
		}
		
	}
	
	

	


}
