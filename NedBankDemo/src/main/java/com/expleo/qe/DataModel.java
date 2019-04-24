package com.expleo.qe;

public class DataModel
{

    String gender, firstName, lastName, dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear,emailAddress,companyName,passWord, confirmPassword;
    String newsLetter;


    //Male,Peter,Griffin,18,August,1989,peterG@gmail1,The Griffons,true,password,password

    public DataModel(String gender, String firstname, String lastname,String day,String month,String year, String email,
                     String companyName, String newsLetter, String password, String confirmPassword)
    {
        setGender(gender);
        setFirstName(firstname);
        setLastName(lastname);
        setDateOfBirthDay(day);
        setDateOfBirthMonth(month);
        setDateOfBirthYear(year);
        setEmailAddress(email);
        setCompanyName(companyName);
        setNewsLetter(newsLetter);
        setPassWord(password);
        setConfirmPassword(confirmPassword);
    }



    public String getDateOfBirthMonth() {
        return dateOfBirthMonth;
    }

    public void setDateOfBirthMonth(String dateOfBirthMonth) {
        this.dateOfBirthMonth = dateOfBirthMonth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public void setDateOfBirthDay(String dateOfBirthDay) {
        this.dateOfBirthDay = dateOfBirthDay;
    }

    public String getDateOfBirthYear() {
        return dateOfBirthYear;
    }

    public void setDateOfBirthYear(String dateOfBirthYear) {
        this.dateOfBirthYear = dateOfBirthYear;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(String newsLetter) {
        this.newsLetter = newsLetter;
    }
}
