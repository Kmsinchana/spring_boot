package com.example.demo.qualifierandprimary;

public interface MessageService {
//    //if i use private method the i should write its implementation here only
//    //they are accessible inside the interface only(to write the code that has common method)
//    private void commonMethod(){
//        System.out.println("common method code");
//    }
//   default void methodA(){
//        commonMethod();
//    }
    void sendMsg();
}
