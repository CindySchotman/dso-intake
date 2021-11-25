package nl.donna.treinenplanner;

import javax.validation.constraints.NotBlank;

public record Trein(@NotBlank(message = "Trein naam mag niet leeg zijn.") String naam, Integer aantalWagons) {
}
