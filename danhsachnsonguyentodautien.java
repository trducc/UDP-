package UDP;

import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2207;

        byte[] sData = ";B23DCCN191;b1pp0ijj".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String reqId = parts[0];
        int n = Integer.parseInt(parts[1].trim());

        String primes = "";
        int count = 0;
        int num = 2;

        while (count < n) {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes += num + ",";
                count++;
            }
            num++;
        }

        if (primes.endsWith(",")) {
            primes = primes.substring(0, primes.length() - 1);
        }

        String sendBack = reqId + ";" + primes;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}