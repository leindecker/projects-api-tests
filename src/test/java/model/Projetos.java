package model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class Projetos {

    String name;
    String leader;
    String description;
    String endDate;

}
