package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class Main {

    ArrayList<Long> primes = new ArrayList<Long>();

    public static void main(String[] args) {
        String saveFile = "/Users/aaroh/Android_Studio_Projects/PrimeNums.txt";
        Main main = new Main();
        main.primeTest();
        File f = new File(saveFile);
        main.saveFile(f);
        ArrayList<Long> prints = main.retreiveFile(f);
        for(long i: prints){
            System.out.print(i + ", ");
        }
    }

    public void primeTest(){
        long startTime = System.currentTimeMillis();
        for(int x = 0; x<10; x++){
            long z = (long) (Math.random()*10);
            primes.add(z);
            System.out.println(x + " " + PrimeCalc.sieveRet(x));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public void userPrimes(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        JButton button = new JButton("Click Me");
        JTextField field = new JTextField();
        panel.add(button);
        panel.add(field);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void saveFile(File file){
        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputWrite = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(outputWrite);
            for(long i: primes){
                String j = Long.toString(i);
                writer.write(j + System.lineSeparator());
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Long> retreiveFile(File file){
        ArrayList<Long> nums = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                long primeNum = Long.valueOf(line);
                nums.add(primeNum);
            }
            reader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return nums;
    }
}
