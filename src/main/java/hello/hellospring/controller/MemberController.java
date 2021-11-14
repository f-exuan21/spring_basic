package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링이 뜰 때 컨트롤러에 등록되어서 스프링이 관리하게 된다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // Autowired로 선언되면 스프링이 해당 컨트롤러에 연결해준다.
    public MemberController(MemberService memberService) { // Controller는 어노테이션이 있어서 스프링이 인식하지만, service는 어노테이션으로 등록되어 있지 않아 인식하지못한다.
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass()); // 프록시가 주입되는지 확인
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
