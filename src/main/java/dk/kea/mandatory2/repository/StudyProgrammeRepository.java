package dk.kea.mandatory2.repository;

import dk.kea.mandatory2.model.StudyProgramme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudyProgrammeRepository extends CrudRepository<StudyProgramme, Integer> {
    List<StudyProgramme> findAll();
}
