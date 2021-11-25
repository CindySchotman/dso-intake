package nl.donna.treinenplanner.repository;

import nl.donna.treinenplanner.Spoor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StationRepository {
     private Map<String, List<Spoor>> stations = Map.of("amf", List.of(new Spoor("4", 10)));

     public void setStations(final Map<String, List<Spoor>> stations) {
          this.stations = stations;
     }

     public Map<String, List<Spoor>> getAllStations() {
          return Collections.unmodifiableMap(stations);
     }

     public Optional<Spoor> find(final String stationsNaam, final String spoor) {
          return Optional.empty();
     }
}
