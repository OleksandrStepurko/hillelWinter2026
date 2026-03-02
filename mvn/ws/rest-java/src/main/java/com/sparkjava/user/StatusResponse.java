package com.sparkjava.user;

public enum StatusResponse {
    SUCCESS("Success"), ERROR("Error"), DELETED("Deleted");

    final private String status;

    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
