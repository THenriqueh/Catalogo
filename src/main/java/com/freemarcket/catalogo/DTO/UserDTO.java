package com.freemarcket.catalogo.DTO;

import com.freemarcket.catalogo.entities.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter private Long id;
    @NotBlank(message = "Campo obrigatório")
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Email(message = "Favor entrar um email válido")
    @Getter @Setter
    private String email;


    @Getter private Set<RoleDTO> roles = new HashSet<RoleDTO>();

    public UserDTO(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));


    }


}
