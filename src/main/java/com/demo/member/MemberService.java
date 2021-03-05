package com.demo.member;

import com.demo.entity.Member;
import com.demo.member.dto.MemberDto;
import com.demo.member.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.demo.core.member.CommonMemberService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CommonMemberService commonMemberService;

    public List<MemberDto.CreateRes> getMembers() {
        return memberRepository.findAll().stream()
                .map(member -> MemberDto.CreateRes.builder().id(member.getId()).name(member.getName()).build())
                .collect(Collectors.toList());
    }

    public String addMember(MemberDto.CreateReq req) {
        String validName = commonMemberService.toUpperCaseAndCheckDuplicateName(req.getName());
        Member newMember = memberRepository.save(Member.builder().name(validName).build());

        return newMember.getName();
    }

}
