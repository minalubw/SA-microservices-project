package swaproject.schoolservice.services;

import swaproject.schoolservice.domains.School;

public interface ISchoolService {
   School addSchool(School school);
   void removeSchool(int id);
   School updateSchool(School school);
    School viewSchool(int schoolName);

}
