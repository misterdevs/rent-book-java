package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.members.Member;

public class RepositoryMember {

    public List<Member> getMember() {

        List<Member> memberList = new ArrayList<Member>() {
            {
                add(new Member("M-001", "Risman", "Bandung"));
                add(new Member("M-002", "Budi", "Bandung"));
                add(new Member("M-003", "Resti", "Kab. Bandung"));
            }

        };

        return memberList;
    }

}
