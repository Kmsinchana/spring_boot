package com.example.Spring.MVC.Features.dto;


import jakarta.validation.constraints.*;

public class EmployeeDTO {

    @NotNull(message = "name cannot be blank")
    private String nameNull;

    @NotEmpty(message = "name cannot be empty")
    private String nameEmpty;

    @NotBlank(message = "name cannot be blank")
    private String nameBlank;

    @Min(value = 18, message = "age should be greater than 18")
    private int minAge;

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Max(value = 60, message = "the max value should be less than 60")
    private int maxAge;

    @Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Invalid mobile number"
    )
    private String mobile;

    public String getNameNull() {
        return nameNull;
    }

    public void setNameNull(String nameNull) {
        this.nameNull = nameNull;
    }

    public String getNameEmpty() {
        return nameEmpty;
    }

    public void setNameEmpty(String nameEmpty) {
        this.nameEmpty = nameEmpty;
    }

    public String getNameBlank() {
        return nameBlank;
    }

    public void setNameBlank(String nameBlank) {
        this.nameBlank = nameBlank;
    }
}
