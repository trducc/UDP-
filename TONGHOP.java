package UDP;

import java.util.*;
import java.io.*;
import java.net.*;
public class guicackituconthieu{
    public static void main (String[]args) throws Exception{
        DatagramSocket socket= new DatagramSocket();
        InetAddress sIp=InetAddress.getByName("36.50.135.242");
        int port=2207;
        byte[]sData=";B23DCCN191;mn8eLJSS".getBytes();
        DatagramPacket sPacket=new DatagramPacket(sData,sData.length,sIp,port);
        socket.send(sPacket);
        byte[]rData=new byte[1024];
        DatagramPacket rPacket=new DatagramPacket(rData,rData.length);
        socket.receive(rPacket);
        String res=new String (rPacket.getData(),0,rPacket.getLength()).trim();
        String []parts=res.split(";");
        String resId=parts[0];
        int n=Integer.parseInt(parts[1]);
        String[]so=parts[2].split(",");
        String kqua="";
        for(int i=1;i<=n;i++){
            boolean timthay=false;
            for(String s:so){
                if(Integer.parseInt(s)==i){
                    timthay=true;
                    break;
                }}
            if(!timthay){
                kqua+=i+",";
            }
        }

        if(kqua.endsWith(",")){
            kqua=kqua.substring(0,kqua.length()-1);
        }
        String sendBack=resId+";"+kqua;
        byte[]outData=sendBack.getBytes();
        DatagramPacket outPacket= new DatagramPacket (outData, outData.length,rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);
        socket.close();
    }
}

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

package UDP;

import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2208;

        byte[] sData = ";B23DCCN191;qsa1zUS5".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String reqId = parts[0];
        String data = parts[1];

        String[] words = data.split("\\s+");
        String ans = "";
        for (String w : words) {
            if (w.length() > 0) {
                w = w.toLowerCase();
                ans += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
            }
        }

        String sendBack = reqId + ";" + ans.trim();
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}

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

package UDP;

import java.net.*;

public class bai1object {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sIp = InetAddress.getByName("36.50.135.242");
        int port = 2208;

        byte[] sData = ";B23DCCN191;0lk6RZcK".getBytes();
        DatagramPacket sPacket = new DatagramPacket(sData, sData.length, sIp, port);
        socket.send(sPacket);

        byte[] rData = new byte[2048];
        DatagramPacket rPacket = new DatagramPacket(rData, rData.length);
        socket.receive(rPacket);

        String res = new String(rPacket.getData(), 0, rPacket.getLength()).trim();
        String[] parts = res.split(";");
        String reqId = parts[0];
        String data = parts[1];

        String processed = "";
        boolean[] visited = new boolean[256];

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (!visited[c]) {
                visited[c] = true;
                int count = 0;
                for (int j = 0; j < data.length(); j++) {
                    if (data.charAt(j) == c) {
                        count++;
                    }
                }
                processed += count + "" + c;
            }
        }

        String sendBack = reqId + ";" + processed;
        byte[] outData = sendBack.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData, outData.length, rPacket.getAddress(), rPacket.getPort());
        socket.send(outPacket);

        socket.close();
    }
}

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