/*package com.bit.eunseon.texttospeech;
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

public class SynthesizeText {
	 public static ByteString synthesizeText(String text) throws Exception {
		    // Instantiates a client
		    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
		      // Set the text input to be synthesized
		      SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

		      // Build the voice request
		      VoiceSelectionParams voice =
		          VoiceSelectionParams.newBuilder()
		              .setLanguageCode("ko_KR") // languageCode = "en_us"
		              .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
		              .build();

		      // Select the type of audio file you want returned
		      AudioConfig audioConfig =
		          AudioConfig.newBuilder()
		              .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
		              .build();

		      // Perform the text-to-speech request
		      SynthesizeSpeechResponse response =
		          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

		      // Get the audio contents from the response
		      ByteString audioContents = response.getAudioContent();

		      // Write the response to the output file.
		      try (OutputStream out = new FileOutputStream("output2.mp3")) {
		        out.write(audioContents.toByteArray());
		        System.out.println("Audio content written to file \"output2.mp3\"");
		        return audioContents;
		      }
		    }
		  }

	 	//tts_synthesize_text
		  public static ByteString synthesizeTextWithAudioProfile(String text, String effectsProfile)
		      throws Exception {
		    // Instantiates a client
		    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
		      // Set the text input to be synthesized
		      SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

		      // Build the voice request
		      VoiceSelectionParams voice =
		          VoiceSelectionParams.newBuilder()
		              .setLanguageCode("ko_KR") // languageCode = "en_us"
		              .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
		              .build();

		      // Select the type of audio file you want returned and the audio profile
		      AudioConfig audioConfig =
		          AudioConfig.newBuilder()
		              .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
		              .addEffectsProfileId(effectsProfile) // audio profile
		              .build();

		      // Perform the text-to-speech request
		      SynthesizeSpeechResponse response =
		          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

		      // Get the audio contents from the response
		      ByteString audioContents = response.getAudioContent();

		      // Write the response to the output file.
		      try (OutputStream out = new FileOutputStream("output2.mp3")) {
		        out.write(audioContents.toByteArray());
		        System.out.println("Audio content written to file \"output2.mp3\"");
		        return audioContents;
		      }
		    }
		  }
		  //tts_synthesize_ssml
		  public static ByteString synthesizeSsml(String ssml) throws Exception {
			    // Instantiates a client
			    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
			      // Set the ssml input to be synthesized
			      SynthesisInput input = SynthesisInput.newBuilder().setSsml(ssml).build();

			      // Build the voice request
			      VoiceSelectionParams voice =
			          VoiceSelectionParams.newBuilder()
			              .setLanguageCode("ko_KR") // languageCode = "en_us"
			              .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
			              .build();

			      // Select the type of audio file you want returned
			      AudioConfig audioConfig =
			          AudioConfig.newBuilder()
			              .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
			              .build();

			      // Perform the text-to-speech request
			      SynthesizeSpeechResponse response =
			          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

			      // Get the audio contents from the response
			      ByteString audioContents = response.getAudioContent();

			      // Write the response to the output file.
			      try (OutputStream out = new FileOutputStream("output2.mp3")) {
			        out.write(audioContents.toByteArray());
			        System.out.println("Audio content written to file \"output2.mp3\"");
			        return audioContents;
			      }
			    }
			  }

}*/
