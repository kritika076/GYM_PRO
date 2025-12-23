/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pande
 */
public class Member {

  
    // Declaration of attributes of a instance of Member with private modifier
    private String memberId;
    private String name;
    private int age;
    private String membershipType;
    
    /**
     * This is a constructor for the class Member
     * Initializes a new instance of Member with specified details of the person
     * * @param memberId the unique identifier of a member
     * @param name the full name of the member
     * @param age the age of the member
     * @param membershipType the type of membership (Monthly, Yearly, etc.)
     */
    public Member(String memberId, String name, int age, String membershipType) {
        // Initializing the attributes
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
    }

    /**
     * Retrieves the unique Id of the member
     * * @return the Id of the member
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * Assigns a new Id for a member
     * * @param memberId the new Id for the member
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * Retrieves the name of the member
     * * @return the name of the member
     */
    public String getName() {
        return name;
    }

    /**
     * Assigns a new name for a member
     * * @param name the new name for the member
     */
    public void setName(String name) {
            this.name = name;
    }

    /**
     * Retrieves the age of the member
     * * @return the age of the member
     */
    public int getAge() {
        return age;
    }

    /**
     * Assigns a new age for a member
     * * @param age the new age for the member
     */
    public void setAge(int age) {
            this.age = age;
        }
    

    /**
     * Retrieves the membership type
     * * @return the membership type
     */
    public String getMembershipType() {
        return membershipType;
    }

    /**
     * Assigns a new membership type
     * * @param membershipType the new type for the member
     */
    public void setMembershipType(String membershipType) {
            this.membershipType = membershipType;
        }
}
