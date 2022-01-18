package uz.ruzyume.porfolio_block.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class _WorkExperience extends _AbstractDomain {

    private String companyName;

    private String position;

    private String years;


}
