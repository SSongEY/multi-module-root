package com.demo.member;

import com.demo.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public List<MemberDto.CreateRes> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping("/members")
    public String addMember(@RequestBody @Valid MemberDto.CreateReq req) {
        return memberService.addMember(req);
    }

}
