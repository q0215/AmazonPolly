package me.q9029.app.polly;

import java.io.IOException;
import java.io.InputStream;

public class SampleMain {

	public static void main(String[] args) {

		String accessKey = "******************************";
		String secretKey = "******************************";

		AmazonPollyService service = new AmazonPollyService(accessKey, secretKey, "AP_NORTHEAST_1");

		try (InputStream inputStream = service.synthesizeAudioStream("Hello.", "Ivy", "Mp3")) {

			// write your program

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
