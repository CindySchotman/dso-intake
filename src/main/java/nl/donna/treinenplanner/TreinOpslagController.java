package nl.donna.treinenplanner;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreinOpslagController {
     private final TreinService treinService;

     public TreinOpslagController(final TreinService treinService) {
          this.treinService = treinService;
     }

     @PostMapping(path = "/treinen", consumes = MediaType.APPLICATION_JSON_VALUE)
     public void slaTreinOp(@RequestBody final TreinVO train) {
          treinService.slaTreinOp(new Trein(train.naam(), 4));
     }
}
