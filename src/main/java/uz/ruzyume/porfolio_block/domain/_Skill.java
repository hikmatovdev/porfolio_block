package uz.ruzyume.porfolio_block.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class _Skill extends _AbstractDomain {

    private String technologyName;

    private String level;
}
