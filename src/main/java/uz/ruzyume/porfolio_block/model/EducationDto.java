package uz.ruzyume.porfolio_block.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class EducationDto implements Serializable {
    @NotNull(message = "This column cannot be null!")
    private String specialization;

    @NotNull(message = "This column cannot be null!")
    private String educatorName;

    @NotNull(message = "This column cannot be null!")
    private String year;
}
