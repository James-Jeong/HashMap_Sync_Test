package com.sync.thread;

import com.sync.model.Info;
import com.sync.model.InfoManager;

public class InfoConsumer implements Runnable{
    private final int index;
    private final InfoManager infoManager;

    public InfoConsumer(InfoManager infoManager, int index) {
        this.infoManager = infoManager;
        this.index = index;
    }

    @Override
    public void run () {
        while (!Thread.currentThread().isInterrupted()) {
            //System.out.println("[ Waiting... " + index + " ]");
            //synchronized (infoManager) { // lock
                Info info = infoManager.getFirstInfo();
                if(info != null) {
                    synchronized (info) {
                        String phoneNumber = info.getPhoneNumber();
                        String name = info.getName();
                        int age = info.getAge();

                        //System.out.println("--------------------");
                        System.out.println("[ " + index + " ] : " + phoneNumber);
                        //System.out.println("[ " + index + " ]");
                        //System.out.println("PhoneNumber : " + phoneNumber);
                        //System.out.println("name : " + name);
                        //System.out.println("age : " + age);

                        if (index == 0) {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        //infoManager.deleteInfo(phoneNumber);
                        //System.out.println(phoneNumber + " is consumed.");
                        //System.out.println("--------------------");
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}
    }
}
