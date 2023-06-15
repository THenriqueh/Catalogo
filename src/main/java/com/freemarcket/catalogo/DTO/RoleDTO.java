package com.freemarcket.catalogo.DTO;

import com.freemarcket.catalogo.entities.Role;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor

public class RoleDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter private Long id;
    @Getter @Setter private String authority;

    public RoleDTO(Role role) {
        super();
        id = role.getId();
        authority = role.getAuthority();
    }
}
