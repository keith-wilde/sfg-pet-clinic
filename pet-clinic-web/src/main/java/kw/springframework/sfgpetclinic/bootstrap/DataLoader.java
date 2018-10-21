package kw.springframework.sfgpetclinic.bootstrap;

import kw.springframework.sfgpetclinic.model.Owner;
import kw.springframework.sfgpetclinic.model.Pet;
import kw.springframework.sfgpetclinic.model.PetType;
import kw.springframework.sfgpetclinic.model.Vet;
import kw.springframework.sfgpetclinic.services.OwnerService;
import kw.springframework.sfgpetclinic.services.PetTypeService;
import kw.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, VetService vetService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 fake street");
        owner1.setCity("Springfield");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now().minusYears(2));

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");
        owner2.setAddress("321 fake");
        owner2.setAddress("Narnia");
        owner2.setTelephone("3213213214");

        Pet fionasPet = new Pet();
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now().minusYears(54));
        fionasPet.setPetType(savedCat);

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Shovel");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
