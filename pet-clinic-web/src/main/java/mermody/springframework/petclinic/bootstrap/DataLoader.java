package mermody.springframework.petclinic.bootstrap;

import mermody.springframework.petclinic.model.Owner;
import mermody.springframework.petclinic.model.Vet;
import mermody.springframework.petclinic.services.OwnerService;
import mermody.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Dima");
        owner1.setLastName("Shevchenko");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dima");
        owner2.setLastName("Balev");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ..... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vova");
        vet1.setLastName("Kozlow");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kolia");
        vet2.setLastName("Popov");

        vetService.save(vet2);

        System.out.println("loaded Vet ....");
    }
}
