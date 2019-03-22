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
	public static void main(String... args) throws Exception {
	    // Instantiates a client
	    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
	      // Set the text input to be synthesized
	      SynthesisInput input = SynthesisInput.newBuilder()
	            .setText("처음부터 끝까지 수십차례 꼼꼼히 컴토를 해보았지만 내 삶에서는 별다른 오류가 발견되지 않았다.")
	            .build();

	      // Build the voice request, select the language code ("en-US") and the ssml voice gender
	      // ("neutral")
	      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
	          .setLanguageCode("ko_KR")
	          .setSsmlGender(SsmlVoiceGender.NEUTRAL)
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
	  }
}
