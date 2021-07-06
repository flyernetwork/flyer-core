package br.com.flyernetwork.core.flyercore.resource.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    public String name;
    public String email;
    public String password;
}
