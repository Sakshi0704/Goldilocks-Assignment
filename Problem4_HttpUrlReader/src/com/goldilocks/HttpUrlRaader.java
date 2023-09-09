package com.goldilocks;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;

public class HttpUrlRaader {

	public static void main(String args[]) {
		
		String urlAddress = "http://localhost:8088/employee?name=sakshi";
		
		URL url;
		HttpURLConnection conn = null;
		
		try {
			
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			
			int resCode = conn.getResponseCode();

			if(resCode != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Response Code: " + resCode +"\n Response: \n" + conn.getResponseMessage());
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			StringBuilder line = new StringBuilder();
			while(reader.ready()) {
				line.append(reader.readLine()+"\n");
			}
			
			reader.close();
		
			
			System.out.println("Response Code: " + resCode +"\n Response: \n" +line);
			
			
		}catch(Exception e) { // IOException , RunTimeException
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				conn.disconnect();
			}
			
		}
		
	}
	
	
}
