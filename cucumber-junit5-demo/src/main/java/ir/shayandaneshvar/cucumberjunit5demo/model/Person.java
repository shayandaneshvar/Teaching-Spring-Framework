package ir.shayandaneshvar.cucumberjunit5demo.model;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
}
