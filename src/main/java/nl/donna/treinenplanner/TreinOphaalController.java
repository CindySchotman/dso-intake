package nl.donna.treinenplanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TreinOphaalController {
     private final TreinService treinService;

     public TreinOphaalController(final TreinService treinService) {
          this.treinService = treinService;
     }

     @GetMapping("/treinen")
     public List<TreinVO> getTreinen(@RequestParam Optional<String> name) {
          return name.map(treinService::getTreinenMetNaam)
                  .orElseGet(treinService::haalAlleTreinenOp)
                  .stream().map(this::toAPIObject).toList();
     }

     private TreinVO toAPIObject(final Trein trein) {
          return new TreinVO(trein.naam());
     }
}
