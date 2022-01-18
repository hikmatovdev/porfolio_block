package uz.ruzyume.porfolio_block.model.update;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class EducationUpdateDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private String specialization;

    @NotNull(message = "This column cannot be null!")
    private String educatorName;

    @NotNull(message = "This column cannot be null!")
    private String year;
}
