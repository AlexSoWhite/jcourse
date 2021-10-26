package ru.mephi.jcourse.lab5;

import java.util.ArrayList;

public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int code;

    private Employee() {

    }

    public String getGivenName() {
        return givenName;
    }

    public String getPhone() {
        return phone;
    }

    public String getState() {
        return state;
    }

    public String getSurName() {
        return surName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getDept() {
        return dept;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getCode() {
        return code;
    }

    public Role getRole() {
        return role;
    }

    public static class Builder {

        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private Role role;
        private String dept;
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state;
        private int code;

        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder seteMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder setDept(String dept) {
            this.dept = dept;
            return this;
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Employee build() {
            Employee instance = new Employee();
            instance.address = this.address;
            instance.age = this.age;
            instance.city = this.city;
            instance.code = this.code;
            instance.dept = this.dept;
            instance.eMail = this.eMail;
            instance.gender = this.gender;
            instance.givenName = this.givenName;
            instance.surName = this.surName;
            instance.role = this.role;
            instance.state = this.state;
            instance.phone = this.phone;
            return  instance;
        }
    }

    public static ArrayList<Employee> createShortList() {
        ArrayList<Employee> list = new ArrayList<>(7);

        list.add(
                new Builder().
                        setAge(25).
                        setCode(67).
                        setPhone("1234").
                        setRole(Role.STAFF).
                        setState("poapd").
                        setGivenName("Олег").
                        setSurName("Мами").
                        setAddress("asdas").
                        setCity("asdaf").
                        setDept("разработка").
                        seteMail("asda@ad.dsa").
                        setGender(Gender.MALE).
                        build()
        );

        list.add(
                new Builder().
                        setAge(31).
                        setCode(12).
                        setPhone("128712412").
                        setRole(Role.MANAGER).
                        setState("oofasd").
                        setGivenName("Пётр").
                        setSurName("Олегов").
                        setAddress("adasfasd").
                        setCity("asda").
                        setDept("разработка").
                        seteMail("asdd@fds.fds").
                        setGender(Gender.MALE).
                        build()
        );

        list.add(
                new Builder().
                        setAge(29).
                        setCode(12).
                        setPhone("634653").
                        setRole(Role.MANAGER).
                        setState("asda").
                        setGivenName("Ольга").
                        setSurName("Потёмкина").
                        setAddress("asda").
                        setCity("asdad").
                        setDept("маркетинг").
                        seteMail("asda@fadf.ds").
                        setGender(Gender.FEMALE).
                        build()
        );

        list.add(
                new Builder().
                        setAge(33).
                        setCode(123).
                        setPhone("5839085").
                        setRole(Role.EXECUTIVE).
                        setState("adsa").
                        setGivenName("Иван").
                        setSurName("Иванов").
                        setAddress("asddadsF").
                        setCity("adssd").
                        setDept("разработка").
                        seteMail("asda@dfads.das").
                        setGender(Gender.MALE).
                        build()
        );

        list.add(
                new Builder().
                        setAge(28).
                        setCode(1).
                        setPhone("34").
                        setRole(Role.STAFF).
                        setState("dsad").
                        setGivenName("Елена").
                        setSurName("Потрачена").
                        setAddress("adsads").
                        setCity("asdas").
                        setDept("разработка").
                        seteMail("asdad").
                        setGender(Gender.FEMALE).
                        build()
        );

        list.add(
                new Builder().
                        setAge(31).
                        setCode(1).
                        setPhone("dahsdk").
                        setRole(Role.STAFF).
                        setState("asdad").
                        setGivenName("Алёна").
                        setSurName("Пескова").
                        setAddress("adsad").
                        setCity("asfgdsg").
                        setDept("маркетинг").
                        seteMail("asdads").
                        setGender(Gender.FEMALE).
                        build()
        );

        list.add(
                new Builder().
                        setAge(24).
                        setCode(77).
                        setPhone("1231").
                        setRole(Role.STAFF).
                        setState("asda").
                        setGivenName("Михаил").
                        setSurName("Зубенко").
                        setAddress("вор в законе").
                        setCity("San Andreas").
                        setDept("разработка").
                        seteMail("asdasd@ads.sda").
                        setGender(Gender.MALE).
                        build()
        );

        return list;

    }

    @Override
    public String toString() {
        return "Emploee{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", role=" + role +
                ", dept='" + dept + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code=" + code +
                '}';
    }
}
