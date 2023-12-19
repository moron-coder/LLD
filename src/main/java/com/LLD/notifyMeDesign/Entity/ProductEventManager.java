package com.LLD.notifyMeDesign.Entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ProductEventManager {
    HashMap<String,Set<Listener>> eventListenersMap = new HashMap<>();

    ProductEventManager(String ...operationsList){
        for(String operation : operationsList){
            eventListenersMap.put(operation, new HashSet<>());
        }
    }

    public void subscribe(String eventType,Listener listener){
        if(!eventListenersMap.containsKey(eventType)){
            System.out.println("Invalid eventType");
            return;
        }
        Set<Listener> listeners = eventListenersMap.get(eventType);
        listeners.add(listener);
        eventListenersMap.put(eventType,listeners);
    }

    public void unsubscribe(String eventType,Listener listener){
        if(!eventListenersMap.containsKey(eventType)){
            System.out.println("Invalid eventType");
            return;
        }
        Set<Listener> listeners = eventListenersMap.get(eventType);
        listeners.remove(listener);
        eventListenersMap.put(eventType,listeners);
    }

    public void notifyListeners(String eventType){
        if(!eventListenersMap.containsKey(eventType)){
            System.out.println("Invalid eventType");
            return;
        }
        for(Listener listener : eventListenersMap.get(eventType)){
            listener.notify();
        }
    }

}
