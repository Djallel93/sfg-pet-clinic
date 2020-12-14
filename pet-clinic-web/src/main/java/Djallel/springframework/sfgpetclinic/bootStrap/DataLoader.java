package Djallel.springframework.sfgpetclinic.bootStrap;


import Djallel.springframework.sfgpetclinic.model.Owner;
import Djallel.springframework.sfgpetclinic.model.Vet;
import Djallel.springframework.sfgpetclinic.servicies.OwnerService;
import Djallel.springframework.sfgpetclinic.servicies.VetService;
import Djallel.springframework.sfgpetclinic.servicies.map.OwnerServiceMap;
import Djallel.springframework.sfgpetclinic.servicies.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michel");
        owner1.setLastName("Gleanne");

        ownerService.save(owner1);

        System.out.println("Loaded owner...");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Weston");

        ownerService.save(owner2);

        System.out.println("Loaded owner...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        System.out.println("Loaded vet...");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");

        vetService.save(vet2);

        System.out.println("Loaded vet...");
    }

}
