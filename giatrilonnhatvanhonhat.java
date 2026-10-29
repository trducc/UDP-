package UDP;

import java.net.*;

public class giatrilonnhatvanhonhat {
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

        int max = Integer.parseInt(nums[0]);
        int min = Integer.parseInt(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int val = Integer.parseInt(nums[i]);
            if (val > max) max = val;
            if (val < min) min = val;
        }

        String sendBack = reqId + ";" + max + "," + min;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}