/*package com.bit.eunseon.texttospeech;
import com.google.cloud.texttospeech.v1.ListVoicesRequest;
import com.google.cloud.texttospeech.v1.ListVoicesResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.Voice;
import com.google.protobuf.ByteString;

import java.util.List;
public class ListAllSupportedVoices {
	public static List<Voice> listAllSupportedVoices() throws Exception {
	    // Instantiates a client
	    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
	      // Builds the text to speech list voices request
	      ListVoicesRequest request = ListVoicesRequest.getDefaultInstance();

	      // Performs the list voices request
	      ListVoicesResponse response = textToSpeechClient.listVoices(request);
	      List<Voice> voices = response.getVoicesList();

	      for (Voice voice : voices) {
	        // Display the voice's name. Example: tpc-vocoded
	        System.out.format("Name: %s\n", voice.getName());

	        // Display the supported language codes for this voice. Example: "en-us"
	        List<ByteString> languageCodes = voice.getLanguageCodesList().asByteStringList();
	        for (ByteString languageCode : languageCodes) {
	          System.out.format("Supported Language: %s\n", languageCode.toStringUtf8());
	        }

	        // Display the SSML Voice Gender
	        System.out.format("SSML Voice Gender: %s\n", voice.getSsmlGender());

	        // Display the natural sample rate hertz for this voice. Example: 24000
	        System.out.format("Natural Sample Rate Hertz: %s\n\n",
	            voice.getNaturalSampleRateHertz());
	      }
	      return voices;
	    }
	  }
}
*/