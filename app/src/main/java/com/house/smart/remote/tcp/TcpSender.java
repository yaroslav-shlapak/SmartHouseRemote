package com.house.smart.remote.tcp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.house.smart.remote.Constants;
import com.house.smart.remote.R;
import com.house.smart.remote.udp.HexHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TcpSender {

    final Handler toastHandler = new Handler();
    public void SendTo(final Context context, final Uri uri) {

        if (uri == null) return;
        String msg = Uri.decode(uri.getLastPathSegment());
/*        if(msg == null) return;
        byte[] msgBytes = msg.getBytes();
        if (msg.startsWith("\\0x")) {
            msg = msg.replace("\\0x", "0x");
            msgBytes = msg.getBytes();
        } else if (msg.startsWith("0x")) {
            msg = msg.replace("0x", "");
            if(!msg.matches("[a-fA-F0-9]+")) {
                Toast.makeText(context, "ERROR: Invalid hex values", Toast.LENGTH_LONG).show();
                return;
            }
            msgBytes = HexHelper.hexStringToBytes(msg);
        }*/

        final String buf = msg;

/*        String appName = context.getString(R.string.app_name);*/
/*        if(Constants.IS_LOGGABLE) {
            Log.d(appName, new String(msgBytes));
            Log.d(appName, "0x" + HexHelper.bytesToHex(msgBytes));
        }*/

        new Thread(new Runnable() {
            public void run() {
                try (
                        Socket kkSocket = new Socket(uri.getHost(), uri.getPort());
                        PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(kkSocket.getInputStream()))
                ) {
                    out.println(buf);
                    String fromServer = in.readLine();
                    Log.d("TcpSender", fromServer + " " + buf);
                    if(!fromServer.equals(buf)) {
                        toastHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "String transfer is corrupted",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        toastHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "String transfer is ok",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                    }


                } catch (final UnknownHostException e) {
                    toastHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, e.toString(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                } catch (final SocketException e) {
                    toastHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, e.toString(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                } catch (final IOException e) {
                    toastHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, e.toString(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
