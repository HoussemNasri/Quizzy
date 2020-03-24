package com.example.quizzy.exception;

public class InvalidCategory extends Exception{
    public InvalidCategory () {
        super("the category id you choose is out of range so we set it by default");
    }
}
