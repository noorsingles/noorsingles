package com.abdin.noorsingles.web;

import com.abdin.noorsingles.model.Application;
import com.abdin.noorsingles.model.PrivateProfile;
import com.abdin.noorsingles.model.Profile;
import com.abdin.noorsingles.repository.ApplicationsRepository;
import com.abdin.noorsingles.service.AdminService;
import com.abdin.noorsingles.service.ConstantContactService;
import com.abdin.noorsingles.service.ProfilesService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fabdin
 */
@Controller
public class MainController {

    @Autowired
    ProfilesService profilesService;

    @Autowired
    AdminService adminService;
    
    @Autowired 
    ConstantContactService ccService;

    @RequestMapping(value = "/")
    public String goToIndex(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value = "/api/profiles/{gender}", method = RequestMethod.GET)
    public @ResponseBody
    List<Profile> getProfiles(HttpSession session, HttpServletRequest request, @PathVariable("gender") String gender) {

        List<Profile> profiles = profilesService.getProfilesByGender(gender);

        return profiles;
    }

    @RequestMapping(value = "/api/profile/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Profile getProfile(@PathVariable("id") String id) {

        return profilesService.findById(id);

    }

    @RequestMapping(value = "/api/profileByEmail", method = RequestMethod.GET)
    public @ResponseBody
    Profile getProfileByEmail(@RequestParam("email") String email, HttpSession session) {

        if (adminService.isAuthenticated(session)) {

            Application a = ApplicationsRepository.findByEmail(email);
            if (a != null) {
                return new Profile(a);
            }
        }
        return null;

    }

    @RequestMapping(value = "/api/getPrivateProfile", method = RequestMethod.GET)
    public @ResponseBody
    PrivateProfile getPrivateProfile(@RequestParam("id") String id, HttpSession session) {

        if (adminService.isAuthenticated(session)) {
            Application a = ApplicationsRepository.findByid(id);
            return new PrivateProfile(a);
        }

        return null;
    }

    @RequestMapping(value = "/api/joinMailingList", method = RequestMethod.POST)
    @ResponseBody 
    public ResponseEntity joinMailingList(@RequestParam("email") String email) throws JSONException {
        
        JSONObject jo=ccService.addContact(email);
       String code= jo.getString("code").substring(1, 4);
       String msg= jo.getString("message");      
       if(code.equals("400")){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }else if(code.equals("304")){
           return new ResponseEntity(HttpStatus.NOT_MODIFIED);
       }
 
        
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/datatable")
    public String dataTable(HttpServletRequest request, HttpServletResponse response) {

        return "profiles";
    }
}
