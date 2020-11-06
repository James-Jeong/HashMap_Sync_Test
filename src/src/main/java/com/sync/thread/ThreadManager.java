package com.sync.thread;

import com.sync.model.InfoManager;

public class ThreadManager{
    private Thread[] threadList;
    private final int threadCount;
    private InfoManager infoManager = null;

    public ThreadManager(int threadCount, InfoManager infoManager) {
        this.threadCount = threadCount;
        this.infoManager = infoManager;
    }

    public void start () {
        threadList = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threadList[i] = new Thread(new InfoConsumer(infoManager, i));
            threadList[i].start();
        }
    }

    public void stop () {
        for (int i = 0; i < threadCount; i++) {
           threadList[i].interrupt();
           threadList[i] = null;
        }
    }
}
