/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Member;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pande
 */
public class Logic {
   private List<Member> memberList;

    public Logic() {
        memberList = new ArrayList<>();
        initializeData();
    }
private void initializeData() {
        // FIX 3: Directly add to list or define registerMember here
        memberList.add(new Member("Mem001", "Alice Johnson", 28, "Regular", "New York", "Female"));
        memberList.add(new Member("Mem002", "Bob Smith", 35, "Regular", "Chicago", "Male"));
        memberList.add(new Member("Mem003", "Charlie Davis", 22, "Premium", "Los Angeles", "Others"));
        memberList.add(new Member("Mem004", "Diana Prince", 30, "Regular", "Miami", "Female"));
        memberList.add(new Member("Mem005", "Ethan Hunt", 40, "Premium", "London", "Male"));
    }

    // Getter so the View (GUI) can see the data
    public List<Member> getMemberList() {
        return memberList;
    }
}