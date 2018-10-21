package kw.springframework.sfgpetclinic.services.map;

import kw.springframework.sfgpetclinic.model.Specialty;
import kw.springframework.sfgpetclinic.model.Vet;
import kw.springframework.sfgpetclinic.services.CrudService;
import kw.springframework.sfgpetclinic.services.SpecialtyService;
import kw.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long>  implements VetService {
    private SpecialtyService specialtyService;
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialties().size()>0){
            vet.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
