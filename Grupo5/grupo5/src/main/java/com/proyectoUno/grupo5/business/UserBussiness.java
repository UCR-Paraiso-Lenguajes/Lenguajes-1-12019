package com.proyectoUno.grupo5.business;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class UserBussiness {


    public String fakeNameGenerator(){
        String result = "Guess";
        int number = (int) (Math.random() * 100000) + 1;
        result+=number;
        return result;
    }

    public ImageIcon avatarGenerator(){
        return null;
    }
    public int randomGenerator(int size){
        int number = (int) (Math.random() * size-1) + 0;
        return number;
    }
}
