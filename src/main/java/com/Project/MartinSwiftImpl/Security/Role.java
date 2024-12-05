// Role.java
package com.Project.MartinSwiftImpl.Security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private String roleName;

    public String getRoleName() {
        return roleName;
    }
}
