package UDP;

import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2208;

        byte[] sData = ";B23DCCN191;qsa1zUS5".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String reqId = parts[0];
        String data = parts[1];

        String[] words = data.split("\\s+");
        String ans = "";
        for (String w : words) {
            if (w.length() > 0) {
                w = w.toLowerCase();
                ans += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
            }
        }

        String sendBack = reqId + ";" + ans.trim();
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}