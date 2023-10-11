package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

    public static void main( String[] args ){

        // Server

        try {

            System.out.println("Server in avvio!");

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            System.out.println("un client si è collegato");
                
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
                
            String stringaRicevuta = in.readLine();
            System.out.println("La stringa ricevuta: " + stringaRicevuta);

            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaMaiuscola + '\n');

            s.close();
            server.close();

        } 

        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }

    }

}