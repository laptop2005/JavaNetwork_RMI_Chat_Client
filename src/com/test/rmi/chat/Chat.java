package com.test.rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote {
	public void setClient(ChatMessage cc) throws RemoteException;

	public void setMessage(String msg) throws RemoteException;
}
