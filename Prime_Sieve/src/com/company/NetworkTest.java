package com.company;
import java.net.*;
import java.io.*;

public class NetworkTest {

    public static void main(String[] args){
    }

    public void KnockKnockServer(int port){
        try{
            ServerSocket server = new ServerSocket(port);
            Socket clientSocket = server.accept();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
