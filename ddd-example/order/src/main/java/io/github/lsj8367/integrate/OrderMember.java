package io.github.lsj8367.integrate;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderMember {

    private String name;
    private String email;

}
