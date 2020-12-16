package djallel.springframework.sfgpetclinic.servicies;

import djallel.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
