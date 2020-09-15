package mermody.springframework.petclinic.services.map;

import mermody.springframework.petclinic.model.Specialty;
import mermody.springframework.petclinic.model.Vet;
import mermody.springframework.petclinic.services.SpecialtyService;
import mermody.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null){
            if (object.getSpecialtys().size() > 0) {
                object.getSpecialtys().forEach(specialty -> {
                    if (specialty.getId() == null){
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(object);
        }else
            return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
