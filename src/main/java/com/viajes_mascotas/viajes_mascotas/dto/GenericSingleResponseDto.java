package com.viajes_mascotas.viajes_mascotas.dto;

public class GenericSingleResponseDto<T> {
    private boolean Status;
    private String ErrorMessage;
    private T Content;

    public GenericSingleResponseDto() {
        Status = true;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public void setContent(T content) {
        Content = content;
    }

    public boolean getStatus() {
        return this.Status;
    }

    public String getErrorMessage() {
        return this.ErrorMessage;
    }

    public T getContent() {
        return this.Content;
    }

    public void loadError(String errorMessage) {
        Status = false;
        ErrorMessage = errorMessage;
    }
}

