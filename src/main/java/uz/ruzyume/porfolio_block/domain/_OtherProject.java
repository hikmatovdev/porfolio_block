package uz.ruzyume.porfolio_block.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class _OtherProject extends _AbstractDomain{

    private String projectName;

    private String projectInformation;
}
