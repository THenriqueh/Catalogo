package com.freemarcket.catalogo.DTO;

import com.freemarcket.catalogo.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;

    public RoleDTO(Role role) {
        super();
        id = role.getId();
        authority = role.getAuthority();
    }
}
