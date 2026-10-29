package UDP;

import java.net.*;
import java.util.Arrays;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2207;

        byte[] sData = ";B23DCCN191;HP94i1pA".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String reqId = parts[0];
        String[] numStrs = parts[1].split(",");

        int n = numStrs.length;
        int[] a = new int[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(numStrs[i].trim());
            sum += a[i];
        }

        double avg = sum / n;
        int aboveAvg = 0;
        for (int val : a) {
            if (val > avg) {
                aboveAvg++;
            }
        }

        Arrays.sort(a);
        int p90Idx = (int) Math.ceil(n * 0.9) - 1;
        int p90 = a[p90Idx];

        String sendBack = reqId + ";p90=" + p90 + ";aboveAvg=" + aboveAvg;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}