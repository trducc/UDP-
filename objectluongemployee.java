package UDP;

import java.io.*;
import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2209;

        byte[] sData = ";B23DCCN191;EUb tqpul".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String reqId = new String(rPacket.getData(), 0, 8);

        ByteArrayInputStream bais = new ByteArrayInputStream(rPacket.getData(), 8, rPacket.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee emp = (Employee) ois.readObject();

        String[] words = emp.getName().trim().split("\\s+");
        String normName = "";
        for (String w : words) {
            if (w.length() > 0) {
                normName += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
            }
        }
        emp.setName(normName.trim());

        String[] dateParts = emp.getHireDate().split("-");
        String year = dateParts[0];
        int x = 0;
        for (int i = 0; i < year.length(); i++) {
            x += year.charAt(i) - '0';
        }
        double newSalary = emp.getSalary() * (1 + x / 100.0);
        newSalary = Math.round(newSalary * 100.0) / 100.0;
        emp.setSalary(newSalary);

        String normHireDate = dateParts[2] + "/" + dateParts[1] + "/" + dateParts[0];
        emp.setHireDate(normHireDate);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(reqId.getBytes());
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(emp);

        byte[] outData = baos.toByteArray();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID = 20261107L;
    private String id;
    private String name;
    private double salary;
    private String hireDate;

    public Employee(String id, String name, double salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getHireDate() { return hireDate; }

    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }
}