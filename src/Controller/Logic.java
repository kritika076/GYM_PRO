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
 * @author pandey
 */
public class Logic {
   private List<Member> memberList;

    public Logic() {
        memberList = new ArrayList<>();
        initializeData();
    }
private void initializeData() {
        // FIX 3: Directly add to list or define registerMember here
        memberList.add(new Member("Mem001", "Prashna Regmi", 28, "Regular", "Dhapakhel", "Female"));
        memberList.add(new Member("Mem002", "Deshan Shakya", 35, "Regular", "Patan", "Male"));
        memberList.add(new Member("Mem003", "Kritika Pandey", 22, "Premium", "Samakhushi", "Others"));
        memberList.add(new Member("Mem004", "Ram Bahadur", 30, "Regular", "KamalPokhari", "Female"));
        memberList.add(new Member("Mem005", "laxman Pun", 40, "Premium", "Thamel", "Male"));
    }

    // Getter so the View (GUI) can see the data
    public List<Member> getMemberList() {
        return memberList;
    }
}