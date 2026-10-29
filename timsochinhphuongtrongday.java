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

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String reqId = parts[0];
        String[] numStrs = parts[1].split(",");

        String sqNums = "";
        for (String s : numStrs) {
            int val = Integer.parseInt(s.trim());
            if (val >= 0) {
                int sq = (int) Math.sqrt(val);
                if (sq * sq == val) {
                    sqNums += val + ",";
                }
            }
        }

        if (sqNums.endsWith(",")) {
            sqNums = sqNums.substring(0, sqNums.length() - 1);
        }

        String sendBack = reqId + ";" + sqNums;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}