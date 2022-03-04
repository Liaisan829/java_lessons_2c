package ru.kpfu.itis.akhmetova.helper;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHelper {
    public static String encrypt(String password){
        MessageDigest md;
        try{
            md = MessageDigest.getInstance("MD5");//строчное название алгоритма
            md.update(password.getBytes());//передаем алгоритму значение в байтах
            byte[] digest = md.digest();//получаем массив
            return DatatypeConverter.printHexBinary(digest).toUpperCase();//получаем строку
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}