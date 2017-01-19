package com.test.rmi.chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.test.rmi.chat.Chat;
import com.test.rmi.chat.ChatMessage;

public class ChatClient extends UnicastRemoteObject implements ChatMessage{

	public ChatClient() throws RemoteException{}
	
	@Override
	public void setMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
	
	public static void main(String[] args) throws Exception {
		ChatClient obj = new ChatClient();
		Chat cs = (Chat)Naming.lookup("rmi://localhost/chat");
		cs.setClient(obj);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String msg = in.readLine();
			cs.setMessage(msg);
		}
	}

}
