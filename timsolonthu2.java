package UDP;

import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2207;

        byte[] sData = ";B23DCCN191;tX9QADJs".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String reqId = parts[0];
        String[] nums = parts[1].split(",");

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int val = Integer.parseInt(nums[i]);
            if (val > max1) {
                max2 = max1;
                max1 = val;
            } else if (val > max2 && val < max1) {
                max2 = val;
            }
        }

        String sendBack = reqId + ";" + max2;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}