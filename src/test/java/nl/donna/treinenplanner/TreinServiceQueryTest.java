package nl.donna.treinenplanner;

import nl.donna.treinenplanner.repository.TreinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.List.of;
import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
class TreinServiceQueryTest {
     @Autowired
     private TreinOphaalController controller;
     @Autowired
     private TreinRepository repository;


     @Test
     void shouldReturnAllTrains() {
          // GIVEN an IC and ICE are present
          repository.setTreinen(of(new Trein("IC", 4), new Trein("ICE", 4)));

          // WHEN the service is queried
          final List<String> result = queryTrains(Optional.empty());

          // THEN both trains should be in the response
          assertThat(result)
                  .containsExactlyInAnyOrder("IC", "ICE");
     }

     private List<String> queryTrains(final Optional<String> nameOptional) {
          return controller.getTreinen(nameOptional).stream().map(TreinVO::naam).collect(Collectors.toList());
     }
}

