package com.freemarcket.catalogo.services.excptions;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException (String msg){
        super(msg);
    }

}
