package djallel.springframework.sfgpetclinic.servicies.map;

import djallel.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findByID() {
        Owner owner = ownerMapService.findByID(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {

        Long id = 2l;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner= ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());

    }

    @Test
    void delete() {

    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
    }
}