package com.bit.eunseon.texttospeech;
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletRequest;


//한문장을 받아서 mp3로 반환하는데엔 이 클래스만 있으면 됨.
public class QuickstartSample {
	

	public void makeMp3(int oneSentenceIdx,String oneSentence,String bookTitle,int page,String gender ) throws Exception {

	    // Instantiates a client
	    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
	      // Set the text input to be synthesized
	      SynthesisInput input = SynthesisInput.newBuilder()

	    	    /*.setSsml("<speak>"+oneSentence+"<break time=\"1500ms\"/>"+bookTitle+"<break time=\"500ms\"/>"+page+"페이지에서"+"</speak>")*/		
	    	    /*.setSsml("<speak>"+oneSentence+"<break time=\"1500ms\"/>"+"책"+"<break time=\"500ms\"/>"+bookTitle+"에서.."+"</speak>")	*/
	            .setSsml("<speak>" +oneSentence+"<break time=\"1500ms\"/>책 <break time=\"100ms\"/>"+"<prosody rate=\"slow\" pitch=\"medium\">"+bookTitle+"</prosody>"+ 
	            		"<prosody rate=\"medium\" pitch=\"0st\">에</prosody>"+
	            		 "<prosody rate=\"medium\" pitch=\"-1st\">서.</prosody></speak>")
	    	    .build();
	      
	      SynthesizeSpeechResponse response;	

	      if(gender.equals("female")) {
	     VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
	          .setLanguageCode("ko_KR")
	          .setName("ko-KR-Standard-B")
	          .build();

	      AudioConfig audioConfig = AudioConfig.newBuilder()
	          .setAudioEncoding(AudioEncoding.MP3)

	          .setPitch(-1.60)
	          .setSpeakingRate(1.07)
	          .build();
	      response = textToSpeechClient.synthesizeSpeech(input, voice,
		          audioConfig);
	      }else {
	      //남자
	      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
		          .setLanguageCode("ko_KR")
		          .setName("ko-KR-Standard-C")
		          .build();

		      AudioConfig audioConfig = AudioConfig.newBuilder()
		          .setAudioEncoding(AudioEncoding.MP3)
		          .setPitch(0.80)
		          .setSpeakingRate(0.93)
		          .build();
		      response = textToSpeechClient.synthesizeSpeech(input, voice,
			          audioConfig);
	      }
		      


	      // Get the audio contents from the response
	      ByteString audioContents = response.getAudioContent();

	      // Write the response to the output file.
	      try (OutputStream out = new FileOutputStream("C:\\Users\\jaeho\\git\\bit\\test0322\\src\\main\\webapp\\mp3Folder\\"+oneSentenceIdx+".mp3")) {
	        out.write(audioContents.toByteArray());
	        System.out.println("Audio content written to file \""+oneSentenceIdx+".mp3\"");
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	    }
	  }
}
