package UDP;

import java.io.*;
import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2209;

        byte[] sData = ";B23DCCN191;3otuJGg2".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String reqId = new String(rPacket.getData(), 0, 8);

        ByteArrayInputStream bais = new ByteArrayInputStream(rPacket.getData(), 8, rPacket.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student st = (Student) ois.readObject();

        String[] words = st.getName().trim().split("\\s+");

        String normName = "";
        for (String w : words) {
            if (w.length() > 0) {
                normName += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
            }
        }
        normName = normName.trim();

        String email = words[words.length - 1].toLowerCase();
        for (int i = 0; i < words.length - 1; i++) {
            email += Character.toLowerCase(words[i].charAt(0));
        }
        email += "@ptit.edu.vn";

        st.setName(normName);
        st.setEmail(email);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(reqId.getBytes());
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(st);

        byte[] outData = baos.toByteArray();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 20171107L;
    private String id;
    private String code;
    private String name;
    private String email;

    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public Student(String code) {
        this.code = code;
    }

    public String getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}