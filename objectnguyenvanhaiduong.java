package UDP;

import java.io.*;
import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2209;

        byte[] sData = ";B23DCCN191;7cunJ4bO".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String reqId = new String(rPacket.getData(), 0, 8);

        ByteArrayInputStream bais = new ByteArrayInputStream(rPacket.getData(), 8, rPacket.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer c = (Customer) ois.readObject();

        String[] words = c.getName().trim().split("\\s+");

        String lastName = words[words.length - 1].toUpperCase();
        String firstName = "";
        for (int i = 0; i < words.length - 1; i++) {
            firstName += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1).toLowerCase() + " ";
        }
        String normName = lastName + ", " + firstName.trim();

        String[] dobParts = c.getDayOfBirth().split("-");
        String normDob = dobParts[1] + "/" + dobParts[0] + "/" + dobParts[2];

        String username = "";
        for (int i = 0; i < words.length - 1; i++) {
            username += Character.toLowerCase(words[i].charAt(0));
        }
        username += words[words.length - 1].toLowerCase();

        c.setName(normName);
        c.setDayOfBirth(normDob);
        c.setUserName(username);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(reqId.getBytes());
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(c);

        byte[] outData = baos.toByteArray();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}

class Customer implements Serializable {
    private static final long serialVersionUID = 20151107L;
    private String id;
    private String code;
    private String name;
    private String dayOfBirth;
    private String userName;

    public Customer(String id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }

    public String getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDayOfBirth() { return dayOfBirth; }
    public String getUserName() { return userName; }

    public void setName(String name) { this.name = name; }
    public void setDayOfBirth(String dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setUserName(String userName) { this.userName = userName; }
}