package uz.ruzyume.porfolio_block.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class _Project extends _AbstractDomain {

    private String projectName;

    private String projectInformation;


}
