package test;

import java.io.*; 
import java.net.*; 
class tcpclient {  
	public static void main(String argv[]) throws Exception  {   
		String sentence;   
		String modifiedSentence; 
		
		Socket clientSocket = new Socket();
		clientSocket.bind(new InetSocketAddress("localhost",25011));
		clientSocket.connect(new InetSocketAddress ("localhost",25012));
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		for(int i=0;i<10;i++)
		{
		//BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));   
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());   
		//sentence = inFromUser.readLine();
		sentence = String.valueOf(i);
		System.out.println("sent value"+i);
		outToServer.writeBytes(sentence + '\n');   
		//modifiedSentence = inFromServer.readLine();   
		//System.out.println("FROM SERVER: " + modifiedSentence);
		try {
	        //sending the actual Thread of execution to sleep X milliseconds
	        Thread.sleep(10000);
	    } catch(InterruptedException ie) {}
		
		}
		clientSocket.close();  
		} 
	} 
