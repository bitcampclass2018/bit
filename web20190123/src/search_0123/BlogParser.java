package search_0123;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BlogParser {
	String keyword;
	 public List<parse> pList(String keyword){
	    	String clientId = "cPTP4WjJyJpuaIOiZ61K";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "xsuvHB8KLi";//애플리케이션 클라이언트 시크릿값";
	        List<parse> list = new ArrayList<>();
	        String result="";
	       
	        try {
	            String text = URLEncoder.encode(keyword, "UTF-8");
	            //String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
	            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            int responseCode = con.getResponseCode();
	            
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = null;
	            Document document = null; //파서호출
	            
	            builder = factory.newDocumentBuilder();
	            document = builder.parse(con.getInputStream()); //현 문서가 트리구조로
	            
	            NodeList nolist = document.getElementsByTagName("item");
	            
	            for(int i= 0;i<nolist.getLength();i++) {
	            	parse p = new parse();
	            	Node pNode = nolist.item(i);
	            	
	            	NodeList childNodeList = pNode.getChildNodes();
	            	for(int j=0;j<childNodeList.getLength();j++) {
	            		Node childNode = childNodeList.item(j);
	            		//System.out.println(childNode);
	            		if(childNode.getNodeName().equals("title")) {
	            			String title = childNode.getFirstChild().getNodeValue();
	            			p.setTitle(title);
	            		}
	            		else if(childNode.getNodeName().equals("description")) {
	            			String description = childNode.getFirstChild().getNodeValue();
	            			p.setDescription(description);
	            		}
	            		else if(childNode.getNodeName().equals("link")) {
	            			String link = childNode.getFirstChild().getNodeValue();
	            			p.setLink(link);
	            		}
	            		
	            	}
	            	list.add(p);
	            }
	            
	          
	           
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	      return list;  
	    }
}
