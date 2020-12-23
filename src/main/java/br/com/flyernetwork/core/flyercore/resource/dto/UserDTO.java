package br.com.flyernetwork.core.flyercore.resource.dto;

import br.com.flyernetwork.core.flyercore.domain.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    public String name;
    public String email;
    public String password;
    public Address address;
}
