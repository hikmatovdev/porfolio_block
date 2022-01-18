package uz.ruzyume.porfolio_block.model.update;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class OtherProjectUpdateDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private String projectName;

    @NotNull(message = "This column cannot be null!")
    private String projectInformation;
}
