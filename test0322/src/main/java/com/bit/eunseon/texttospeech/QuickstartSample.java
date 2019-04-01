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


//한문장을 받아서 mp3로 반환하는데엔 이 클래스만 있으면 됨.
public class QuickstartSample {
	
	public void makeMp3(int oneSentenceIdx,String oneSentence,String bookTitle) throws Exception {
	    // Instantiates a client
	    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
	      // Set the text input to be synthesized
	      SynthesisInput input = SynthesisInput.newBuilder()
	            /*.setText(oneSentence+bookTitle+"페이지"+page+"에서")[3 second pause]*/
	    		  .setSsml("<speak>" +oneSentence+"<break time=\"1500ms\"/>책 <break time=\"100ms\"/>"+"<prosody rate=\"slow\" pitch=\"medium\">"+bookTitle+"</prosody>"+ 
		            		"<prosody rate=\"medium\" pitch=\"0st\">에</prosody>"+
		            		 "<prosody rate=\"medium\" pitch=\"-1st\">서.</prosody></speak>")		
	            .build();
	      		
	      // Build the voice request, select the language code ("en-US") and the ssml voice gender
	      // ("neutral")
	      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
	          .setLanguageCode("ko_KR")
	          /*.setSsmlGender(SsmlVoiceGender.NEUTRAL)*/
	          .setName("ko-KR-Standard-C")
	          .build();

	      // Select the type of audio file you want returned
	      AudioConfig audioConfig = AudioConfig.newBuilder()
	          .setAudioEncoding(AudioEncoding.MP3)
	          .setPitch(0.80)
	          .setSpeakingRate(0.93)
	          .build();

	      // Perform the text-to-speech request on the text input with the selected voice parameters and
	      // audio file type
	      SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice,
	          audioConfig);

	      // Get the audio contents from the response
	      ByteString audioContents = response.getAudioContent();

	      // Write the response to the output file.
	      try (OutputStream out = new FileOutputStream(oneSentenceIdx+".mp3")) {
	        out.write(audioContents.toByteArray());
	        System.out.println("Audio content written to file \""+oneSentenceIdx+".mp3\"");
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	    }
	  }
	
	
	
	/*public static void main(String... args) throws Exception {
	    // Instantiates a client
	    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
	      // Set the text input to be synthesized
	      SynthesisInput input = SynthesisInput.newBuilder()
	            .setText("영이는 그 말을 믿어버렸고, 방에는 괴로운 영이와 울고 있는 영이의 몸과 거짓말쟁이 순이가 있게 되었다.")
	            .build();

	      // Build the voice request, select the language code ("en-US") and the ssml voice gender
	      // ("neutral")
	      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
	          .setLanguageCode("ko_KR")
	          .setSsmlGender(SsmlVoiceGender.NEUTRAL)
	          .setName("ko-KR-Standard-D")
	          .build();

	      // Select the type of audio file you want returned
	      AudioConfig audioConfig = AudioConfig.newBuilder()
	          .setAudioEncoding(AudioEncoding.MP3)
	          .build();

	      // Perform the text-to-speech request on the text input with the selected voice parameters and
	      // audio file type
	      SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice,
	          audioConfig);

	      // Get the audio contents from the response
	      ByteString audioContents = response.getAudioContent();

	      // Write the response to the output file.
	      try (OutputStream out = new FileOutputStream("output3.mp3")) {
	        out.write(audioContents.toByteArray());
	        System.out.println("Audio content written to file \"output3.mp3\"");
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	    }
	  }*/
}
