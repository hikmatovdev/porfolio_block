package uz.ruzyume.porfolio_block.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TestimonialsDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private String recommended;

    @NotNull(message = "This column cannot be null!")
    private String fullName;

    @NotNull(message = "This column cannot be null!")
    private String companyName;
}
