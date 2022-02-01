package uz.ruzyume.porfolio_block.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionResponse {

    private LocalDateTime occurredAt;

    private String massage;

    private int status;
}
