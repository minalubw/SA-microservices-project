package swaproject.schoolservice.services;

import swaproject.schoolservice.domains.School;

public interface ISchoolService {
   School addSchool(School school);
   void removeSchool(String schoolName);
   School updateSchool(School school);
    School viewSchool(String schoolName);

}
