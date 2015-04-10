package com.asf.asfobjectstore;

import java.util.HashMap;

/**
 * Created by asifmujteba on 16/11/2014.
 */
public class ASFObjectStore {

    /**
     * Get Singleton instance
     *
     * @return a singleton ASFObjectStore instance
     */
    public static ASFObjectStore shared() {
        if(instance == null) {
            instance = new ASFObjectStore();
        }

        return instance;
    }

    /**
     * Push/Store an Object to the Store and return its unique key back for reference
     *
     * @param obj An Object to Push
     * @return Unique key to access the Object
     */
    public synchronized String push(Object obj) {
        while (map.containsKey(key)) {
            long ln = Long.parseLong(key);
            if (ln == Long.MAX_VALUE-1) key = "0";
            key = ((int)(ln+1)) + "";
        }

        map.put(key, obj);

        return key;
    }

    /**
     * Pop/Remove an Object from the Store and return it back
     *
     * @param aKey Unique key of the Object
     * @return Popped Object
     */
    public synchronized Object pop(String aKey) {
        if (aKey == null) {
            return null;
        }

        Object obj = get(aKey);
        if (obj != null) {
            map.remove(aKey);
        }

        return obj;
    }

    /**
     * Get an Object from the Store without removing it
     * @see {@link #pop(String)} Use this method instead if you
     * want remove the object from the Store after retreiving
     *
     * @param aKey Unique key of the Object
     * @return Object
     */
    public synchronized Object get(String aKey) {
        if (map.containsKey(aKey)) {
            Object obj = map.get(aKey);
            return obj;
        }

        return null;
    }


    // ---------- private Stuff -------------//
    private static ASFObjectStore instance;

    private String key = "0";
    private HashMap<String, Object> map = new HashMap<String, Object>();

    private ASFObjectStore() { }
}
