package UDP;

import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2208;

        byte[] sData = ";B23DCCN191;73g2DgLf".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String resId = parts[0];
        String data = parts[1];

        char maxChar = ' ';
        int maxCount = 0;

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int dem = 0;
            for (int j = 0; j < data.length(); j++) {
                if (data.charAt(j) == c) {
                    dem++;
                }
            }
            if (dem > maxCount) {
                maxCount = dem;
                maxChar = c;
            }
        }

        String positions = "";
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == maxChar) {
                positions += i + ",";
            }
        }

        String sendBack = resId + ";" + maxChar + ":" + positions;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}