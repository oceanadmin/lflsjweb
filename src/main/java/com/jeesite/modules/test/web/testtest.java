package com.jeesite.modules.test.web;

/**
 * Created by Administrator on 2019/8/7 0007.
 */
public class testtest {

    public static void main(String arg[]){
        String str = ".png|.jpg|.doc|.docx";
        String name = ".doc";
        System.out.println("....."+str.indexOf(name));

        if(str.indexOf(name) == -1){
            System.out.println("bucunzai");
        }else{
            System.out.println("cunzai.");
        }
    }
}
