package com.example.client.utills;

import java.util.List;

public class ResponseData<T> {
    private String message;
    private int status;
    private T data; // Thay List<T> bằng T

    public ResponseData(String message, int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public T getData() { // Trả về T thay vì List<T>
        return data;
    }
}
