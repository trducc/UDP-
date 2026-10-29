package UDP;

import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2207;

        byte[] sData = ";B23DCCN191;qCodeToGia".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String reqId = new String(rPacket.getData(), 0, 8);

        String resInts = "";
        for (int i = 8; i < rPacket.getLength(); i++) {
            int val = rPacket.getData()[i] & 0xFF;
            resInts += val + ",";
        }

        if (resInts.endsWith(",")) {
            resInts = resInts.substring(0, resInts.length() - 1);
        }

        String sendBack = reqId + ";" + resInts;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}