package mermody.springframework.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Specialty> specialtie = new HashSet<>();

    public Set<Specialty> getSpecialtie() {
        return specialtie;
    }

    public void setSpecialtie(Set<Specialty> specialtys) {
        this.specialtie = specialtys;
    }
}
