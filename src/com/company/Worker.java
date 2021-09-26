package com.company;

public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;


    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorListener){
        this.callback = callback;
        this.errorCallback = errorListener;
    }

    public void start(){
        for (int i = 1; i < 100; i++){
            if(i == 33) {
                errorCallback.onError("Задание " + i + " провалено");
            }else
                callback.onDone("Задание " + i + " выпонено" );
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone (String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError (String result);
    }

}
