package Djallel.springframework.sfgpetclinic.servicies;

import Djallel.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
