package me.q9029.app.polly;

import java.io.InputStream;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;

public class AmazonPollyService {

	private AmazonPolly polly;

	public AmazonPollyService(String accessKey, String secretKey, String regionName) {

		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(credentials);

		Regions region = Regions.valueOf(regionName);

		AmazonPollyClientBuilder clientBuilder = AmazonPollyClientBuilder.standard();
		this.polly = clientBuilder.withCredentials(provider).withRegion(region).build();
	}

	public InputStream synthesizeAudioStream(String text, String voiceId, String outputFormatName) {

		OutputFormat format = OutputFormat.valueOf(outputFormatName);

		SynthesizeSpeechRequest request = new SynthesizeSpeechRequest();
		request.withText(text).withVoiceId(voiceId).withOutputFormat(format);

		SynthesizeSpeechResult result = polly.synthesizeSpeech(request);
		return result.getAudioStream();
	}
}
