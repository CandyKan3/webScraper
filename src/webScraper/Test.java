package webScraper;


import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Test {

    public static void main(final String[] args) {
	    
		
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(true);
		try {
			String searchUrl = "https://parkingavailability.uncc.edu/";
			HtmlPage page = client.getPage(searchUrl);
			System.out.println(page.asText());
			System.out.println("Page request successful");

		
				//HtmlElement parkingPercent = ((HtmlElement)page.getByXPath("/html/body/form")) ;
			
					// It is possible that an item doesn't have any price, we set the price to 0.0 in this case
					//String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText() ;
		   //    HtmlElement form = (HtmlElement)page.getByXPath("=[]").get(0);
			List<DomNode> items = page.getByXPath("//div[contains(@class, 'green') or "
                    + "contains(@class, 'yellow') or "
                    + "contains(@class, 'red') and"
                    + "contains(@class, 'ng-star-inserted')" +
                    "]") ;
		
					for(DomNode i: items) {
						System.out.println(i);
					}
				//System.out.println(div.asText());
			
		} catch(Exception e){
			e.printStackTrace();
		}

	}
    }



