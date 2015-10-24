package com.abdin.noorsingles.service;

import com.abdin.noorsingles.repository.ApplicationsRepository;
import com.abdin.noorsingles.model.Application;
import com.abdin.noorsingles.model.Profile;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabdin
 */
@Service
public class ProfilesService {

    private List<Profile> profiles;

    public List<Profile> getProfiles() {
       
        List<Application> applications = ApplicationsRepository.loadApplications();
        profiles = new ArrayList<>();
        for (Application a : applications) {
            profiles.add(new Profile(a));
        }

        return profiles;
    }

    public Profile findById(String id) {
       
        if(profiles==null) loadProfiles();
        
        for (Profile f : profiles) {
            int hashCode=f.getHashCode();
            if (String.valueOf(hashCode).equals(id)) {
                return f;
            }
        }
        return null;

    }

    public void loadProfiles() {
       profiles=getProfiles();
    }

    public List<Profile> getProfilesByGender(String gender) {
        
        List<Profile> genderProfiles=new ArrayList<>();
        for(Profile p:getProfiles()){
            
            if(null!=p.getGender() && p.getGender().equals(gender)){
                genderProfiles.add(p);
            }
        }
        return genderProfiles;
     }

}
