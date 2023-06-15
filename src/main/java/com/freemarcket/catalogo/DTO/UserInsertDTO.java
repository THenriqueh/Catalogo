package com.freemarcket.catalogo.DTO;


import com.freemarcket.catalogo.services.validation.UserInsertValid;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@UserInsertValid
@AllArgsConstructor
@NoArgsConstructor

public class UserInsertDTO extends UserDTO {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String password;


}


