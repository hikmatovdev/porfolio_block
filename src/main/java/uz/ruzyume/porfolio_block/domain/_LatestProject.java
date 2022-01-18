package uz.ruzyume.porfolio_block.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class _LatestProject extends _AbstractDomain{

    @OneToOne
    private _Project project;
}
