/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        memberList.add(new Member("Mem001", "Prashna Regmi", 28, "Regular", "Dhapakhel", "Female", 11, "01/11/2026"));
        memberList.add(new Member("Mem002", "Deshan Shakya", 35, "Regular", "Patan", "Male", 13, "01/13/2026"));
        memberList.add(new Member("Mem005", "Kritika Pandey", 22, "Premium", "Samakhushi", "Others", 23, "12/25/2025"));
        memberList.add(new Member("Mem003", "Ram Bahadur", 30, "Regular", "KamalPokhari", "Female", 10, "01/4/2026"));
        memberList.add(new Member("Mem004", "laxman Pun", 40, "Premium", "Thamel", "Male", 13, "01/13/2026"));
    }

    // Getter so the View (GUI) can see the data
    public List<Member> getMemberList() {
        return memberList;
    }
    //for history search
    private Stack<String> history = new Stack<>();
//  Adds the search term to the top of the stack

    public void recordSearch(String query) {
        if (query != null && !query.trim().isEmpty()) {
            // Optional: Don't push if it's the same as the last search
            if (history.isEmpty() || !history.peek().equalsIgnoreCase(query)) {
                history.push(query);
            }
        }
    }

    public String getHistoryString() {
        if (history.isEmpty()) {
            return "None";
        }

        // Create a temporary stack so we don't modify the original history
        Stack<String> temp = new Stack<>();
        temp.addAll(history); // copy all elements

        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Pop the last 3 entries from the temporary stack
        while (!temp.isEmpty() && count < 5) {
            sb.append(temp.pop());
            count++;
            if (!temp.isEmpty() && count < 5) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    // LINEAR SEARCH (
    // This scans the list one by one.
    public List<Member> linearSearchByName(String query) {
        List<Member> foundMembers = new ArrayList<>();
        for (Member m : memberList) {
            // .contains() makes it a partial match search
            if (m.getName().toLowerCase().contains(query.toLowerCase())) {
                foundMembers.add(m);
            }
        }
        return foundMembers;
    }

    //  BINARY SEARCH 
    // This is much faster but requires the list to be SORTED first.
    public Member binarySearchByMemberId(String targetId) {
        // Ensure ascending order for binary search
        manualSortByMemberId(true);

        int low = 0;
        int high = memberList.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midId = memberList.get(mid).getMemberId();
            int comparison = midId.compareToIgnoreCase(targetId);

            if (comparison == 0) {
                return memberList.get(mid);
            }
            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null; // not found
    }

    public void manualSortByMemberId(boolean ascending) {
        int n = memberList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                String id1 = memberList.get(j).getMemberId();
                String id2 = memberList.get(minIndex).getMemberId();

                // Compare strings
                int comparison = id1.compareToIgnoreCase(id2);
                if (ascending ? comparison < 0 : comparison > 0) {
                    minIndex = j;
                }
            }
            // Swap
            Member temp = memberList.get(minIndex);
            memberList.set(minIndex, memberList.get(i));
            memberList.set(i, temp);
        }
    }
    // method to sort by member name

    public void manualSortByName(boolean ascending) {
        int n = memberList.size();
        for (int i = 0; i < n - 1; i++) {
            int selectedIndex = i;
            for (int j = i + 1; j < n; j++) {
                String name1 = memberList.get(j).getName();
                String name2 = memberList.get(selectedIndex).getName();

                // Compare names ignoring case
                int comparison = name1.compareToIgnoreCase(name2);

                // Choose ascending or descending
                if (ascending ? comparison < 0 : comparison > 0) {
                    selectedIndex = j;
                }
            }
            // Swap
            Member temp = memberList.get(selectedIndex);
            memberList.set(selectedIndex, memberList.get(i));
            memberList.set(i, temp);
        }
    }

}
