package uz.ruzyume.porfolio_block.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AboutMeDto {
    @NotNull(message = "This column cannot be null!")
    private String aboutMe;
}
