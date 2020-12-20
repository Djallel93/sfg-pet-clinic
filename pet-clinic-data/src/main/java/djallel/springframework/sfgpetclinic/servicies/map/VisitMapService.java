package djallel.springframework.sfgpetclinic.servicies.map;

import djallel.springframework.sfgpetclinic.model.Visit;
import djallel.springframework.sfgpetclinic.servicies.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findByID(Long aLong) {
        return (Visit) super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }
        return (Visit) super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
