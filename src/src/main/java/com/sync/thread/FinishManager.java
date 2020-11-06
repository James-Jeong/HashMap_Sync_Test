package com.sync.thread;

import com.sync.model.InfoManager;

public class FinishManager implements Runnable{

    private ThreadManager threadManager = null;
    private InfoManager infoManager = null;

    public FinishManager(ThreadManager threadManager, InfoManager infoManager) {
        this.threadManager = threadManager;
        this.infoManager = infoManager;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!infoManager.isEmpty()) {
                threadManager.stop();
                Thread.currentThread().interrupt();
            }
        }
    }

}
