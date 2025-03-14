package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private Role role;
}