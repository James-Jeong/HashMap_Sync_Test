package com.sync;

import com.sync.model.InfoManager;
import com.sync.thread.FinishManager;
import com.sync.thread.ThreadManager;

public class SyncMain {
    public static void main(String[] args) {
        InfoManager infoManager = InfoManager.getInstance();
        infoManager.addInfo("1", "a", 21);
        infoManager.addInfo("2", "b", 22);
        infoManager.addInfo("3", "c", 23);
        //infoManager.addInfo("4", "d", 24);
        //infoManager.addInfo("5", "e", 25);
        //infoManager.addInfo("6", "f", 26);

        ThreadManager threadManager = new ThreadManager(3, infoManager);
        threadManager.start();

        //FinishManager finishManager = new FinishManager(threadManager, infoManager);
        //finishManager.run();
    }
}
