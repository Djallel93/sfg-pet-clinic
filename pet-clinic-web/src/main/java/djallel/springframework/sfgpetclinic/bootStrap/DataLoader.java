package djallel.springframework.sfgpetclinic.bootStrap;


import djallel.springframework.sfgpetclinic.model.Owner;
import djallel.springframework.sfgpetclinic.model.Pet;
import djallel.springframework.sfgpetclinic.model.PetType;
import djallel.springframework.sfgpetclinic.model.Vet;
import djallel.springframework.sfgpetclinic.servicies.OwnerService;
import djallel.springframework.sfgpetclinic.servicies.PetTypeService;
import djallel.springframework.sfgpetclinic.servicies.VetService;
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
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Gleane");
        owner1.setAddress("123 Berkirelten");
        owner1.setCity("Miami");
        owner1.setTelephone("1546135684616464");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Champion");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        System.out.println("Loaded owner...");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Weston");
        owner1.setAddress("123 Berkirelten");
        owner1.setCity("Miami");
        owner1.setTelephone("1546135684616464");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Sisan");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owner...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        System.out.println("Loaded vet...");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vet...");
    }

}
