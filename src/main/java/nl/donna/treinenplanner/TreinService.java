package nl.donna.treinenplanner;

import nl.donna.treinenplanner.repository.StationRepository;
import nl.donna.treinenplanner.repository.TreinRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Validated
public class TreinService {
     private final TreinRepository treinRepository;
     private final StationRepository stationRepository;

     public TreinService(final TreinRepository repository, final StationRepository stationRepository) {
          this.treinRepository = repository;
          this.stationRepository = stationRepository;
     }

     public List<Trein> haalAlleTreinenOp() {
          return treinRepository.getAllTrains();
     }

     public List<Trein> getTreinenMetNaam(final String name) {
          return treinRepository.queryByNameStartsWith(name);
     }

     public void slaTreinOp(@Valid final Trein trein) {
          treinRepository.store(trein);
     }
}
