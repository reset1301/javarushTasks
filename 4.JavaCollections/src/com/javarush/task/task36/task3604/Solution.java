package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree( );
        final int NUMS = 400000;
        final int GAP  =  35461;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( new Integer( i ) );

//        if( ((Integer)(t.findMin( ))).intValue( ) != 1 ||
//                ((Integer)(t.findMax( ))).intValue( ) != NUMS - 1 )
//            System.out.println( "FindMin or FindMax error!" );

//        for( int i = 1; i < NUMS; i++ )
//            if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i )
//                System.out.println( "Find error1!" );
    }
}
