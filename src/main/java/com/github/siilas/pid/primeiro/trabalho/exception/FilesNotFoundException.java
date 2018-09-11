package com.github.siilas.pid.primeiro.trabalho.exception;

public class FilesNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -193851786285710265L;

    public FilesNotFoundException() {
        super("Não foi possível recuperar as texturas!");
    }
    
}
