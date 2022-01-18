package uz.ruzyume.porfolio_block.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class _Education extends _AbstractDomain{

    private String specialization;

    private String educatorName;

    private String year;
}
