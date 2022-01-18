package uz.ruzyume.porfolio_block.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class _AboutMe extends _AbstractDomain {

    @Column(nullable = false)
    private String aboutMe;
}
