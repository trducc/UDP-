package UDP;

import java.util.*;
import java.io.*;
import java.net.*;
public class guicackituconthieu{
    public static void main (String[]args) throws Exception{
        DatagramSocket socket= new DatagramSocket();
        InetAddress sIp=InetAddress.getByName("36.50.135.242");
        int port=2207;
        byte[]sData=";B23DCCN191;mn8eLJSS".getBytes();
        DatagramPacket sPacket=new DatagramPacket(sData,sData.length,sIp,port);
        socket.send(sPacket);
        byte[]rData=new byte[1024];
        DatagramPacket rPacket=new DatagramPacket(rData,rData.length);
        socket.receive(rPacket);
        String res=new String (rPacket.getData(),0,rPacket.getLength()).trim();
        String []parts=res.split(";");
        String resId=parts[0];
        int n=Integer.parseInt(parts[1]);
        String[]so=parts[2].split(",");
        String kqua="";
        for(int i=1;i<=n;i++){
            boolean timthay=false;
            for(String s:so){
                if(Integer.parseInt(s)==i){
                    timthay=true;
                    break;
                }}
            if(!timthay){
                kqua+=i+",";
            }
        }

        if(kqua.endsWith(",")){
            kqua=kqua.substring(0,kqua.length()-1);
        }
        String sendBack=resId+";"+kqua;
        byte[]outData=sendBack.getBytes();
        DatagramPacket outPacket= new DatagramPacket (outData, outData.length,rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);
        socket.close();
    }
}