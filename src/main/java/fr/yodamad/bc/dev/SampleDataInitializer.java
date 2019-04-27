package fr.yodamad.bc.dev;

import fr.yodamad.bc.data.Beer;
import fr.yodamad.bc.data.BeerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

import static java.lang.String.format;

@Log4j2
@Component
public class SampleDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final BeerRepository beerRepository;

    public SampleDataInitializer(BeerRepository repository) {
        this.beerRepository = repository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("Initializing data");
        // Check current data
        beerRepository.findAll()
                .subscribe(beer -> log.info(format("Found %s", beer)));
        // Create sample beers
        beerRepository.deleteAll()
                .thenMany(
                        Flux.just("A", "B", "C", "D")
                        .map(name -> new Beer(UUID.randomUUID().toString(), format("Beer %s", name)))
                        .flatMap(beerRepository::save)
                )
                .thenMany(beerRepository.findAll())
                .subscribe(beer -> log.info(format("Saving %s", beer)));
        log.info("Data initialized");
    }
}
