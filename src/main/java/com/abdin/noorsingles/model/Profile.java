package com.abdin.noorsingles.model;

import com.abdin.noorsingles.utils.Calc;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fabdin
 */
public class Profile implements Serializable{
    
    private List<Field> publicFields;
    private List<Field> preferenceFields;
    
    private String timestamp;
    private String gender;
    private String yearOfBirth;
    private String height;
    private String weight;
    private String bornCountry;
    private String grewUpInCountry;
    private String citizenshipOf;
    private String residencyStatusInUsa;
    private String currentLocation;
    private String ifWithChildrenHowMany;
    private String martialStatus;
    private String responsibilityOfChildren;
    private String doTheyStayWithYou;
    private String doYouWantMoreChildren;
    private String byWhenDoYouWantToGetMarried;
    private String afterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately;
    private String denomination;
    private String numberOfSisters;
    private String myMarriageDecision;
    private String parentsLocation;
    private String numberOfBrothers;
    private String muslim;
    private String prayDay;
    private String fastingRamadan;
    private String hajj;
    private String eatHalal;
    private String smoker;
    private String doYouHaveAnyHealthIssues;
    private String languagesSpoken;
    private String education;
    private String placeOfWork;
    private String annualIncome;
    private String whichMasjidYouGoTo;
    private String howOftenDoYouGoToTheMasjed;
    
    public Profile(Application a) {

        this.publicFields=a.getPublic();
        this.preferenceFields=a.getPartnerPreferences();
        for (Field f : publicFields) {
            setValue(f.label, f.value);
        }
    }

    public Profile() {

    }

    public void setValue(String label, String value) {

        //System.out.println("case (\"" + label + "\"):{ this." + getVariable(label) + " = value;break;}");

        switch (label.trim()) {
            case ("Timestamp"): {
                this.timestamp = value;
                break;
            }
            case ("Gender"): {
                this.gender = value;
                break;
            }
            case ("Year of Birth"): {
                this.yearOfBirth = value;
                break;
            }
            case ("Height"): {
                this.height = value;
                break;
            }
            case ("Weight"): {
                this.weight = value;
                break;
            }
            case ("Born country"): {
                this.bornCountry = value;
                break;
            }
            case ("Grew up in country"): {
                this.grewUpInCountry = value;
                break;
            }
            case ("Citizenship of"): {
                this.citizenshipOf = value;
                break;
            }
            case ("Residency Status in USA"): {
                this.residencyStatusInUsa = value;
                break;
            }
            case ("Current Location"): {
                this.currentLocation = value;
                break;
            }
            case ("Martial Status"): {
                this.martialStatus = value;
                break;
            }
            case ("If with children , how many"): {
                this.ifWithChildrenHowMany = value;
                break;
            }
            case ("Responsibility of children"): {
                this.responsibilityOfChildren = value;
                break;
            }
            case ("Do they stay with you"): {
                this.doTheyStayWithYou = value;
                break;
            }
            case ("Do you want more children ?"): {
                this.doYouWantMoreChildren = value;
                break;
            }
            case ("By when do you want to get married ?"): {
                this.byWhenDoYouWantToGetMarried  = value;
                break;
            }
            case ("My marriage decision"): {
                this.myMarriageDecision = value;
                break;
            }
            case ("Parents Location"): {
                this.parentsLocation = value;
                break;
            }
            case ("Number of Brothers"): {
                this.numberOfBrothers = value;
                break;
            }
            case ("Number of Sisters"): {
                this.numberOfSisters = value;
                break;
            }
            case ("After marriage would your parents be staying with you or you will be living separately ?"): {
                this.afterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately = value;
                break;
            }
            case ("Denomination"): {
                this.denomination = value;
                break;
            }
            case ("Muslim"): {
                this.muslim = value;
                break;
            }
            case ("Pray / day"): {
                this.prayDay = value;
                break;
            }
            case ("Fasting ramadan"): {
                this.fastingRamadan = value;
                break;
            }
            case ("Hajj"): {
                this.hajj = value;
                break;
            }
            case ("Eat Halal"): {
                this.eatHalal = value;
                break;
            }
            case ("Smoker"): {
                this.smoker = value;
                break;
            }
            case ("Do you have any health issues ?"): {
                this.doYouHaveAnyHealthIssues  = value;
                break;
            }
            case ("Languages Spoken"): {
                this.languagesSpoken = value;
                break;
            }
            case ("Education"): {
                this.education = value;
                break;
            }
            case ("Place of work"): {
                this.placeOfWork = value;
                break;
            }
            case ("Annual Income"): {
                this.annualIncome = value;
                break;
            }
            case ("Which masjid you go to ?"): {
                this.whichMasjidYouGoTo  = value;
                break;
            }
            case ("How often do you go to the masjed"): {
                this.howOftenDoYouGoToTheMasjed = value;
                break;
            }

        }

    }

    public List<Field> getPublicFields() {
        return publicFields;
    }

    public void setPublicFields(List<Field> fields) {
        this.publicFields = fields;
    }

    public List<Field> getPreferenceFields() {
        return preferenceFields;
    }

    public void setPreferenceFields(List<Field> preferenceFields) {
        this.preferenceFields = preferenceFields;
    }

    
    public String getProfileUrl(){
        return "datatable#/profile/"+getHashCode();
    }
    
    String getVariable(String label) {

        String[] split = label.split(" ");
        label = "";
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                split[i] = split[i].toLowerCase();
            } else {
                split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length()).toLowerCase();
            }
            label = label + split[i];
        }

        return label;
    }
    
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBornCountry() {
        return bornCountry;
    }

    public void setBornCountry(String bornCountry) {
        this.bornCountry = bornCountry;
    }

    public String getGrewUpInCountry() {
        return grewUpInCountry;
    }

    public void setGrewUpInCountry(String grewUpInCountry) {
        this.grewUpInCountry = grewUpInCountry;
    }

    public String getCitizenshipOf() {
        return citizenshipOf;
    }

    public void setCitizenshipOf(String citizenshipOf) {
        this.citizenshipOf = citizenshipOf;
    }

    public String getResidencyStatusInUsa() {
        return residencyStatusInUsa;
    }

    public void setResidencyStatusInUsa(String residencyStatusInUsa) {
        this.residencyStatusInUsa = residencyStatusInUsa;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getIfWithChildrenHowMany() {
        return ifWithChildrenHowMany;
    }

    public void setIfWithChildrenHowMany(String ifWithChildrenHowMany) {
        this.ifWithChildrenHowMany = ifWithChildrenHowMany;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getResponsibilityOfChildren() {
        return responsibilityOfChildren;
    }

    public void setResponsibilityOfChildren(String responsibilityOfChildren) {
        this.responsibilityOfChildren = responsibilityOfChildren;
    }

    public String getDoTheyStayWithYou() {
        return doTheyStayWithYou;
    }

    public void setDoTheyStayWithYou(String doTheyStayWithYou) {
        this.doTheyStayWithYou = doTheyStayWithYou;
    }

    public String getDoYouWantMoreChildren() {
        return doYouWantMoreChildren;
    }

    public void setDoYouWantMoreChildren(String doYouWantMoreChildren) {
        this.doYouWantMoreChildren = doYouWantMoreChildren;
    }

    public String getByWhenDoYouWantToGetMarried() {
        return byWhenDoYouWantToGetMarried;
    }

    public void setByWhenDoYouWantToGetMarried(String byWhenDoYouWantToGetMarried) {
        this.byWhenDoYouWantToGetMarried = byWhenDoYouWantToGetMarried;
    }

    public String getAfterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately() {
        return afterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately;
    }

    public void setAfterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately(String afterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately) {
        this.afterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately = afterMarriageWouldYourParentsBeStayingWithYouOrYouWillBeLivingSeparately;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getNumberOfSisters() {
        return numberOfSisters;
    }

    public void setNumberOfSisters(String numberOfSisters) {
        this.numberOfSisters = numberOfSisters;
    }

    public String getMyMarriageDecision() {
        return myMarriageDecision;
    }

    public void setMyMarriageDecision(String myMarriageDecision) {
        this.myMarriageDecision = myMarriageDecision;
    }

    public String getParentsLocation() {
        return parentsLocation;
    }

    public void setParentsLocation(String parentsLocation) {
        this.parentsLocation = parentsLocation;
    }

    public String getNumberOfBrothers() {
        return numberOfBrothers;
    }

    public void setNumberOfBrothers(String numberOfBrothers) {
        this.numberOfBrothers = numberOfBrothers;
    }

    public String getMuslim() {
        return muslim;
    }

    public void setMuslim(String muslim) {
        this.muslim = muslim;
    }

    public String getPrayDay() {
        return prayDay;
    }

    public void setPrayDay(String prayDay) {
        this.prayDay = prayDay;
    }

    public String getFastingRamadan() {
        return fastingRamadan;
    }

    public void setFastingRamadan(String fastingRamadan) {
        this.fastingRamadan = fastingRamadan;
    }

    public String getHajj() {
        return hajj;
    }

    public void setHajj(String hajj) {
        this.hajj = hajj;
    }

    public String getEatHalal() {
        return eatHalal;
    }

    public void setEatHalal(String eatHalal) {
        this.eatHalal = eatHalal;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public String getDoYouHaveAnyHealthIssues() {
        return doYouHaveAnyHealthIssues;
    }

    public void setDoYouHaveAnyHealthIssues(String doYouHaveAnyHealthIssues) {
        this.doYouHaveAnyHealthIssues = doYouHaveAnyHealthIssues;
    }

    public String getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(String languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getWhichMasjidYouGoTo() {
        return whichMasjidYouGoTo;
    }

    public void setWhichMasjidYouGoTo(String whichMasjidYouGoTo) {
        this.whichMasjidYouGoTo = whichMasjidYouGoTo;
    }

    public String getHowOftenDoYouGoToTheMasjed() {
        return howOftenDoYouGoToTheMasjed;
    }

    public void setHowOftenDoYouGoToTheMasjed(String howOftenDoYouGoToTheMasjed) {
        this.howOftenDoYouGoToTheMasjed = howOftenDoYouGoToTheMasjed;
    }

    public int getHashCode() {        
        return Calc.getHashCodeFromTimestamp(this.timestamp);
    }

}
