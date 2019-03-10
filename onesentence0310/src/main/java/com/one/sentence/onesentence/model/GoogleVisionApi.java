package com.one.sentence.onesentence.model;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class GoogleVisionApi {
	
public static String getSentence(String FileRoot) {
		//String[] arr= {};
		String result = "";
		try {
			//String FileRoot = "C:\\Users\\jaeho\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\onesentence\\upload\\책.jpg";
			
			List<AnnotateImageRequest> requests = new ArrayList<AnnotateImageRequest>();
		
			ByteString imgBytes = ByteString.readFrom(new FileInputStream(FileRoot));
		
			Image img = Image.newBuilder().setContent(imgBytes).build();
			Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
			requests.add(request);
			
			try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
				BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			    List<AnnotateImageResponse> responses = response.getResponsesList();
		
			    for (AnnotateImageResponse res : responses) {
			    	if (res.hasError()) {
			    		System.out.printf("Error: %s\n", res.getError().getMessage());
			    	}
		
			    	System.out.println("Text : ");
			    	System.out.println("--------------");
			    	result = res.getTextAnnotationsList().get(0).getDescription();
			    	/*System.out.println(result);			    	
			    	System.out.println("--------------");

			    	StringTokenizer st = new StringTokenizer(result, ".");
			    	System.out.println(st.countTokens());
			    	arr= new String[st.countTokens()];
			    	
			    	for(int i=0;i<arr.length;i++) {
			    		arr[i] = st.nextToken();
			    		System.out.println(i+":"+arr[i]);
			    	}
			    	
			    	*/
			    }
			    
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
