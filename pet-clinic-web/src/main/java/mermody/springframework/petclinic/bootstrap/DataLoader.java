package mermody.springframework.petclinic.bootstrap;

import mermody.springframework.petclinic.model.Owner;
import mermody.springframework.petclinic.model.Pet;
import mermody.springframework.petclinic.model.PetType;
import mermody.springframework.petclinic.model.Vet;
import mermody.springframework.petclinic.services.OwnerService;
import mermody.springframework.petclinic.services.PetTypeService;
import mermody.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Dima");
        owner1.setLastName("Shevchenko");
        owner1.setAddress("123 Brikerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123-123-456");

        Pet dimaslPet1 = new Pet();
        dimaslPet1.setPetType(saveCatPetType);
        dimaslPet1.setOwner(owner1);
        dimaslPet1.setBirthDate(LocalDate.now());
        dimaslPet1.setName("Barsik");
        owner1.getPets().add(dimaslPet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dima");
        owner2.setLastName("Balev");
        owner2.setAddress("Dzerrzynski 33");
        owner2.setCity("Pervomajsk");
        owner2.setTelephone("777-777-777");

        Pet dimaslPet = new Pet();
        dimaslPet.setPetType(saveDogPetType);
        dimaslPet.setOwner(owner2);
        dimaslPet.setBirthDate(LocalDate.now());
        dimaslPet.setName("Rosco");
        owner2.getPets().add(dimaslPet);

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
