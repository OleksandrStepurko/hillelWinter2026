package com.hillel.cw_20.ex;

public class Ex1 {
    public static void main(String[] args) {
        boolean flag1 = "Java" == "Java"
                .replace( 'J' , 'J' ); // -> new object
        boolean flag2 = "Java" == "Java"
//                .replace( 'J' , 'J' );
                .replace( 'J' , 'j' ).replace('j', 'J'); // new object 2x
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag1 && flag2);
    }
}


