package uz.ruzyume.porfolio_block.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class _Language extends _AbstractDomain{

    private String language;

    private String level;

    private double rate;

}

