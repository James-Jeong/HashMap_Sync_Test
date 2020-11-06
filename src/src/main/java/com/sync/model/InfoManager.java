package com.sync.model;

import java.util.HashMap;
import java.util.Map;

public class InfoManager {
    private final int mapSize = 100;
    private static InfoManager instance = null;
    Map<String, Info> infoMap;

    public InfoManager() {
        this.infoMap = new HashMap<>(mapSize);
    }

    static public InfoManager getInstance() {
        if(instance == null) {
            instance = new InfoManager();
        }
        return instance;
    }

    public void addInfo(String phoneNumber, String name, int age) {
        synchronized (infoMap) {
            Info info = new Info(phoneNumber, name, age);
            infoMap.put(phoneNumber, info);
        }
    }

    public void deleteInfo(String phoneNumber) {
        if (infoMap.containsKey(phoneNumber)) {
            synchronized (infoMap) {
                infoMap.remove(phoneNumber);
            }
        }
    }

    public Info getInfo(String phoneNumber) {
        Info info = null;
        if (infoMap.containsKey(phoneNumber)) {
            synchronized (infoMap) {
                info = infoMap.get(phoneNumber);
            }
        }
        return info;
    }

    public Info getFirstInfo() {
        Info info = null;
        if (!infoMap.isEmpty()) {
            synchronized (infoMap) {
                info = getInfo(infoMap.keySet().iterator().next());
            }
        }
        return info;
    }

    public boolean isEmpty() {
        return (infoMap.size() > 0);
    }

}
