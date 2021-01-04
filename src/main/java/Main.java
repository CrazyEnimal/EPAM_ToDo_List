import models.Member;
import models.Role;
import services.MemberService;
import services.RoleServices;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MemberService memberService = new MemberService();
//        Member member = new Member();
//        member.setUserName("admin");
//        member.setFirstName("Admin");
//        member.setLastName("Admin");
//        member.setEmail("druzini@gmail.com");
//        member.setPassword("admin");
//        member.setRole("SuperUser");
//        memberService.saveMember(member);

        RoleServices roleService = new RoleServices();

        List<Role> roles = roleService.findAllRoles();

        for (Role role: roles
             ) {
            System.out.println(role.toString());
        }
    }
}
