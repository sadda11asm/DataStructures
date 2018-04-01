package csci.impl.testing;

import csci.impl.LinkedListDeque;

public class TestLinkedListDeque {
    public static void main(String[] args){
        LinkedListDeque<Integer> dln = new LinkedListDeque();
        try {
            dln.popFromBack();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            dln.popFromFront();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(dln + "size:" + dln.getSize());

        for (int i=0; i<5; i++){
            dln.pushToFront(i);
            System.out.println(dln + "size:" + dln.getSize());
        }


        try {
            for (int i=0; i<5; i++){
                dln.popFromFront();
                System.out.println(dln + "size:" + dln.getSize());

            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        //---
        for (int i=0; i<6; i++){
            dln.pushToFront(i);
            System.out.println(dln + "size:" + dln.getSize());
        }


        try {
            for (int i=0; i<6; i++){
                dln.popFromBack();
                System.out.println(dln + "size:" + dln.getSize());

            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        //----
        for (int i=0; i<7; i++){
            dln.pushToBack(i);
            System.out.println(dln + "size:" + dln.getSize());
        }


        try {
            for (int i=0; i<7; i++){
                dln.popFromBack();
                System.out.println(dln + "size:" + dln.getSize());

            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        //-----
        for (int i=0; i<8; i++){
            dln.pushToBack(i);
            System.out.println(dln + "size:" + dln.getSize());
        }


        try {
            for (int i=0; i<8; i++){
                dln.popFromFront();
                System.out.println(dln + "size:" + dln.getSize());

            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        //-------------
        for(int i=0; i<10; i++){
            dln.pushToBack(i);
            dln.pushToFront(i);
        }
        System.out.println(dln + "size:" + dln.getSize());

        for(int i=0; i<8; i++){
            try {
                dln.popFromFront();
                dln.popFromBack();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(dln + "size:" + dln.getSize());
        dln.clear();
        System.out.println(dln + "size:" + dln.getSize());
        dln.pushToFront(1);
        dln.pushToBack(3);
        System.out.println(dln + "size:" + dln.getSize());

    }
}
