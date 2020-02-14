package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalPostMan {

	public static void main(String[] args) {

		try {
			final String POST_PARAMS = "{\r\n" + 
					"\"name\": \"Rakesh Pati\",\r\n" + 
					"        \"age\": 25,\r\n" + 
					"        \"salary\": 99999\r\n" + 
					"}";
			//System.out.println(POST_PARAMS);
			URL obj = new URL("http://localhost:8080/SpringBootRestApi/api/user/2");
			HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
			postConnection.setRequestMethod("GET"); // change according to the request
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setDoOutput(true);

			// if request is POST or PUT
			/*OutputStream os = postConnection.getOutputStream();
			os.write(POST_PARAMS.getBytes()); os.flush(); os.close();
			 */
			int responseCode = postConnection.getResponseCode();
			System.out.println("POST Response Code :  " + responseCode);
			System.out.println("POST Response Message : " + postConnection.getResponseMessage());

			BufferedReader in = new BufferedReader(new InputStreamReader(
					postConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in .readLine()) != null) {
				response.append(inputLine);
			}
			in .close();

			System.out.println(response.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}