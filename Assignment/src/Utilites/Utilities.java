/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilites;

import java.text.Normalizer;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ngọc Hùng
 */
public class Utilities {
    
  public boolean checkSo(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
    
    boolean checkEmail(String text) {
        Pattern pattern = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    String convertFullName(String fullname) {
        String[] arrName = fullname.split("\\s+");
        String fullN = "";
        for (String x : arrName) {
            fullN += vietHoaChuCaiDau(x) + " ";
        }
        return fullN.trim();
    }

    String vietHoaChuCaiDau(String text) {//DUNG
        var temp = text.trim().toLowerCase();//dung
        return String.valueOf(temp.charAt(0)).toUpperCase() + text.substring(1);//= Dung
    }
    
    String msvFpoly(String fullName, int maxMSV, int a) {
        String[] arrName = fullName.split("\\s+");//Nguyễn Văn Chương
        String name = vietHoaChuCaiDau(arrName[arrName.length - 1]);//Chương
        for (int i = 0; i < arrName.length - 1; i++) {
            name += String.valueOf(arrName[i].charAt(0)).toUpperCase();
        }
        //0 là sinh viên, 1 là GV
        name += ((a == 0) ? "PH" : "") + String.valueOf(maxMSV);//Đoạn cộng PH và số đằng sau 
        return unAccent(name);//DungnNMPH01
    }

    public String[] getAllYears() {
        String[] arrNamSinh = new String[2023 - 1800];
        int temp = 1800;
        for (int i = 0; i < arrNamSinh.length; i++) {
            arrNamSinh[i] = String.valueOf(temp);
            temp++;
        }
        return arrNamSinh;
    }

    public String unAccent(String s) {//Convert từ tiếng việt có dấu về tiếng việt 0 dấu
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
    }
    
    public String ma(String txt,int id){
        return txt + id;
    }
    
}
