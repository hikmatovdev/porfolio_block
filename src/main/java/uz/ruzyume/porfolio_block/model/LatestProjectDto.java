package uz.ruzyume.porfolio_block.model;

import lombok.Data;
import uz.ruzyume.porfolio_block.domain._Project;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LatestProjectDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private _Project project;
}
