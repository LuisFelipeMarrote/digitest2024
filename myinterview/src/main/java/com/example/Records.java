package com.example;

public class Records{
    int emp_no;
    String first_name, last_name, gender;

    public void setFirst_name(){
        this.first_name = first_name; 
    }
    public void setLast_name(){
        this.last_name = last_name; 
    }
    public void setGender(){
        this.gender = gender; 
    } 
    public void setEmp_no(){
        this.emp_no = emp_no; 
    }

    public String getFirst_name(){
        return first_name;
    } 
    public String getLast_name(){
        return last_name;
    } 
    public String getGender(){
        return gender;
    } 
    public int emp_no(){
        return emp_no;
    } 

    @Override
    public String toString(){
        return "first name: " + first_name + ",last_name: " + last_name;
    }
}










//{"emp_no": 10001, "first_name": "Georgie", "last_name": "Facello", "gender": "M"} FORMATO DO JSON.