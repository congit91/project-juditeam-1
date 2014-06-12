/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class DataFile {

    public static String db_name = "db_websitentm";
    public static String user = "root";
    public static String pass = "123456";
    public static String emailSend = "king.vandalism@gmail.com";
    public static String passEmailSend = "congtrinh";
    public static String emailReceive = "king.vandalism1@gmail.com";

    public static void loadFile(){
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(Constants.STORAGE_PATH
                    + Constants.DATA_FILE);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //Read File Line By Line
            String st;
            int i = 0;
            while ((st = br.readLine()) != null) {
                String[] str = st.split(Constants.SEPERATOR);
                ++i;
                if (i == 1) {
                    db_name = str[1];
                }
                if (i == 2) {
                    user = str[1];
                }
                if (i == 3) {
                    pass = str[1];
                }
                if (i == 4) {
                    emailSend = str[1];
                }
                if (i == 5) {
                    passEmailSend = str[1];
                }
                if (i == 6) {
                    emailReceive = str[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fstream.close();
            } catch (Exception ex) {
            }
        }
        System.out.println(fstream);
    }
}
