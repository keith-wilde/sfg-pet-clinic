package kw.springframework.sfgpetclinic.services.map;

import kw.springframework.sfgpetclinic.model.Specialty;
import kw.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by keith on 10/21/18.
 */
@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
