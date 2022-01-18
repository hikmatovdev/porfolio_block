package uz.ruzyume.porfolio_block.model.create;

import lombok.Data;
import uz.ruzyume.porfolio_block.domain._Project;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LatestProjectCreateDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private _Project project;
}
