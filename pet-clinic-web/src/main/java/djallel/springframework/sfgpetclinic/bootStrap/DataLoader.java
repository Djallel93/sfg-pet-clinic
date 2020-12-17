package djallel.springframework.sfgpetclinic.bootStrap;


import djallel.springframework.sfgpetclinic.model.Owner;
import djallel.springframework.sfgpetclinic.model.PetType;
import djallel.springframework.sfgpetclinic.model.Vet;
import djallel.springframework.sfgpetclinic.servicies.OwnerService;
import djallel.springframework.sfgpetclinic.servicies.PetTypeService;
import djallel.springframework.sfgpetclinic.servicies.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Gleane");

        ownerService.save(owner1);

        System.out.println("Loaded owner...");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Weston");

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
