package mermody.springframework.petclinic.bootstrap;

import mermody.springframework.petclinic.model.*;
import mermody.springframework.petclinic.services.OwnerService;
import mermody.springframework.petclinic.services.PetTypeService;
import mermody.springframework.petclinic.services.SpecialtyService;
import mermody.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

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
        vet1.getSpecialtys().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kolia");
        vet2.setLastName("Popov");
        vet2.getSpecialtys().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("loaded Vet ....");
    }
}
