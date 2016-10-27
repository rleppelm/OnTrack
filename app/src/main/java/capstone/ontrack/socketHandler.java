package capstone.ontrack;

import android.os.AsyncTask;
import java.net.Socket;
import java.io.*;
import java.net.*;



/**
 * Created by rleppelmeier on 10/25/16.
 */
public class socketHandler extends AsyncTask<Void, Void, Void> {

    String hostName ;
    Integer portNumber;
    String input;


    socketHandler(String in){
        input = in;
        hostName = "35.160.244.249";
        portNumber = 5657;
    }

    void addString(String in){
        input = in;
    }


    @Override protected Void doInBackground(Void... arg0) {
        try (

                Socket onTrkSock = new Socket(hostName, portNumber);

                PrintWriter out =
                        new PrintWriter(onTrkSock.getOutputStream(), true);

                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(onTrkSock.getInputStream()));

                //BufferedReader stdIn =
                // new BufferedReader(
                // new InputStreamReader(System.in))

        ) {

            String testInput = "helloWorld";

            //while ((testInput = stdIn.readLine()) != null) {

            out.println(input);

//                System.out.println("Response: " + in.readLine());

            // }
        } catch (UnknownHostException e) {

            System.err.println("Don't know about host " + hostName);

            System.exit(1);

        } catch (IOException e) {

            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);

            System.exit(1);


        }
        return null;
    }


}