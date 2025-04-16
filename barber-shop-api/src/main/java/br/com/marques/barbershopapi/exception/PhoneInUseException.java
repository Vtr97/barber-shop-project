package br.com.marques.barbershopapi.exception;

public class PhoneInUseException extends RuntimeException {
    public PhoneInUseException(String message) {
        super(message);
    }
}
