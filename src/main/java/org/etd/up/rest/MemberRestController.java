package org.etd.up.rest;

import org.etd.up.models.Member;
import org.etd.up.models.Role;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoleRepository roleRepository;

    /**
     * @Description Get member by ID
     * @param id
     * @Description memder_id
     *
     * @return
     */
    @GetMapping("/{id}")
    Member members(@PathVariable int id) {
        return this.memberRepository.findById(id);
    }

    /**
     * Get all members in system
     * @return
     */
    @GetMapping
    Collection<Member> members() {
        return this.memberRepository.findAll();
    }

    /**
     * Create new Member
     * @param user_name
     * @param first_name
     * @param last_name
     * @param email
     * @param password
     * @return
     */
    @PostMapping
    String addNewMember(@RequestParam String user_name,
                        @RequestParam String first_name,
                        @RequestParam String last_name,
                        @RequestParam String email,
                        @RequestParam String password
    ){
        Member m = new Member();
        m.setUserName(user_name);
        m.setFirstName(first_name);
        m.setLastName(last_name);
        m.setEmail(email);
        m.setPassword(password);
        m.setRole(this.roleRepository.findById(2));
        this.memberRepository.save(m);
        return "{\"success\":true}";
    }

    /**
     * Edit member by ID
     * @param id
     * @param allParams
     * @return
     */
    @PutMapping("/{id}")
    String changeRoleMember(@PathVariable("id") int id, @RequestParam Map<String, String> allParams){
        Member m = this.memberRepository.findById(id);
        if(allParams.containsKey("user_name")){
            m.setUserName(allParams.get("user_name"));
        }
        if(allParams.containsKey("first_name")){
            m.setFirstName(allParams.get("first_name"));
        }
        if(allParams.containsKey("last_name")){
            m.setLastName(allParams.get("last_name"));
        }
        if(allParams.containsKey("email")){
            m.setEmail(allParams.get("email"));
        }
        if(allParams.containsKey("password")){
            m.setPassword(allParams.get("password"));
        }
        if(allParams.containsKey("role_id")){
            Role r = this.roleRepository.findById(Integer.parseInt(allParams.get("role_id")));
            m.setRole(r);
        }
        this.memberRepository.save(m);
        return "{\"success\":true}";
    }

    /**
     * Delete member by ID
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    String editMember(@PathVariable("id") int id){
        this.memberRepository.deleteById(id);
        return "{\"success\":true}";
    }
}
