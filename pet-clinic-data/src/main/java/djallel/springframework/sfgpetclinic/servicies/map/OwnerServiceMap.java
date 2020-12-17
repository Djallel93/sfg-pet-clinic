package djallel.springframework.sfgpetclinic.servicies.map;

import djallel.springframework.sfgpetclinic.model.Owner;
import djallel.springframework.sfgpetclinic.model.Pet;
import djallel.springframework.sfgpetclinic.servicies.OwnerService;
import djallel.springframework.sfgpetclinic.servicies.PetService;
import djallel.springframework.sfgpetclinic.servicies.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner = null;
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }


    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
