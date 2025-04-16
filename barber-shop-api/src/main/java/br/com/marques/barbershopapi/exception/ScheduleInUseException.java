package br.com.marques.barbershopapi.exception;

public class ScheduleInUseException extends RuntimeException {
    public ScheduleInUseException(String message) {
        super(message);
    }
}
