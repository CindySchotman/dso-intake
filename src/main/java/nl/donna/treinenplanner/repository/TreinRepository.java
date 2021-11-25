package nl.donna.treinenplanner.repository;

import nl.donna.treinenplanner.DubbeleTreinException;
import nl.donna.treinenplanner.Trein;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class TreinRepository {
     private List<Trein> treinen = List.of(
             new Trein("ICE", 4)
     );

     public List<Trein> getAllTrains() {
          return Collections.unmodifiableList(treinen);
     }

     public void setTreinen(List<Trein> treinen) {
          this.treinen = treinen;
     }

     public void store(final Trein trein) {
          if (nameExists(trein)) {
               throw new DubbeleTreinException("This train already exists.");
          }
          treinen = Stream.concat(Stream.of(trein), treinen.stream()).toList();
     }

     private boolean nameExists(final Trein trein) {
          return treinen.stream().anyMatch(t -> t.naam().equals(trein.naam()));
     }

     public List<Trein> queryByNameStartsWith(final String name) {
          return this.getAllTrains().stream()
                  .filter(train -> train.naam().toLowerCase(Locale.ROOT).startsWith(name.toLowerCase(Locale.ROOT)))
                  .toList();
     }
}
