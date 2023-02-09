package swaproject.schoolservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swaproject.schoolservice.Repository.SchoolRepository;
import swaproject.schoolservice.domains.School;
import swaproject.schoolservice.exception.SchoolNotFoundException;

import java.util.Optional;

@Service
public class SchoolService implements ISchoolService{
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public School addSchool(School school) {
       return schoolRepository.save(school);
    }

    @Override
    public void  removeSchool(int id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()){
            schoolRepository.delete(school.get());
        }
        else
            throw new SchoolNotFoundException("Selected School Not Found");
    }

    @Override
    public School updateSchool(School school) {
        Optional<School> schoolForUpdate = schoolRepository.findById(school.getId());
        if (schoolForUpdate.isPresent()) {
            schoolForUpdate.get().setSchoolName(school.getSchoolName());
            schoolForUpdate.get().setContact(school.getContact());
            schoolForUpdate.get().setAddress(school.getAddress());
            schoolRepository.save(schoolForUpdate.get());
            return schoolForUpdate.get();
        } else
            throw new SchoolNotFoundException("School to be Update not Found");
    }

    @Override
    public School viewSchool(int schoolName) {
        Optional<School> school1 = schoolRepository.findById(schoolName);
        if (school1.isPresent()){
            return school1.get();
        }
        else
            throw new SchoolNotFoundException("School Not Found");
    }
}
