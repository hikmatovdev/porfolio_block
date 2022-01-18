package uz.ruzyume.porfolio_block.model.create;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class WorkExperienceCreateDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private String companyName;

    @NotNull(message = "This column cannot be null!")
    private String position;

    @NotNull(message = "This column cannot be null!")
    private String years;
}
