import java.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class diffie_s {
    public static void main(String[] args) throws Exception{
        Scanner inp= new Scanner(System.in);
        ServerSocket ss= new ServerSocket(9090);
        Socket s= ss.accept();
        System.out.println("Client connected");
        PrintWriter pr= new PrintWriter(s.getOutputStream(),true);
        BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
        int alpha= Integer.parseInt(br.readLine());
        int q= Integer.parseInt(br.readLine());
        int ya= Integer.parseInt(br.readLine());
        System.out.println("alpha and q are: " + alpha + " "+ q);
        System.out.println("Choose Xb< q: ");
        int xb= inp.nextInt();
        int yb= (int)(Math.pow(alpha, xb)) % q;
        pr.println(yb);
        int key= (int)(Math.pow(ya, xb)) % q;
        System.out.println("The key is: "+ key);
    }
}