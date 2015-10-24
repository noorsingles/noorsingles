package com.abdin.noorsingles.repository;

import au.com.bytecode.opencsv.CSVReader;
import com.abdin.noorsingles.model.Application;
import com.abdin.noorsingles.model.Field;
import com.abdin.noorsingles.utils.Calc;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabdin
 */
@Repository
public class ApplicationsRepository {
    private static List<Application> applications;
    public static final String DATA_FILE_PATH = "applications/applications.csv";

    public static Application findByid(String id) {
        
        for(Application a:ApplicationsRepository.loadApplications()){
            String hashcode=String.valueOf(Calc.getHashCodeFromTimestamp(a.getTimeStamp()));
            if(hashcode.equals(id)){
                return a;
            }
        }
        
        return null;
    }

    public ApplicationsRepository() {
    }
    
    public List<Application> getApplications(){
        return loadApplications();
    }

    public static List<Application> loadApplications() {
        
         if(applications!=null) return applications;   
         applications = new ArrayList<>();
         
       
        try {
            //csv file containing data
            ClassLoader classLoader = ApplicationsRepository.class.getClassLoader();
            File file = new File(classLoader.getResource(DATA_FILE_PATH).getFile());
 
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            int lineNumber = 0;
            List<String> fields = new ArrayList<>();
            while ((nextLine = reader.readNext()) != null) {
                Application application = new Application();
                lineNumber++;

                for (int i = 0; i < nextLine.length; i++) {

                        if (lineNumber == 1) {
                        fields.add(nextLine[i]);
                    }else {
                        application.add(fields.get(i), nextLine[i]);
                        
                    }
                }
                
                applications.add(application);

            }
        } catch (Exception e) {
        }

        return applications;
    }
    

    public List<Application> filter(String gender,boolean admin) {
        
        if(applications==null || admin) loadApplications();
        
        List<Application> filteredApplications=new ArrayList<>();
        
        if(gender!=null && !gender.equals("")){
            for(Application app:applications){
                for(Field f:app.getFields()){
                    if(f.getLabel().equals("Gender") && f.getValue().equals(gender) )
                    {
                        filteredApplications.add(app);
                        continue;
                    }
                }
            }
        }
        
        return filteredApplications;
        
    }

    public static Application findByEmail(String email) {

        loadApplications();
        
        for(Application a:applications){
            if(a.getFieldValue("Email") !=null &&
                    a.getFieldValue("Email").equals(email)){
                return a;
            }
        }
        return null;
    }

    public static void clear() {
        applications=null;
    }
}
