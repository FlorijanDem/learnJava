package com.books.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books.dto.TakedRequestDto;
import com.books.books.repository.MemberRepository;
import com.books.books.repository.TakedRepository;
import com.books.books.model.Member;
import com.books.books.model.Taked;

@RestController
@RequestMapping("/taked")
public class TakedController {
    
    @Autowired
    private TakedRepository takedRepository;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping
    public ResponseEntity<?> addTaked(@RequestBody TakedRequestDto dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElse(null);
        if (member == null) {
            return ResponseEntity.badRequest().body("Member not found");
        }

        Taked taked = new Taked();
        taked.setBookTitle(dto.getBookTitle());
        taked.setMember(member);

        return ResponseEntity.ok(takedRepository.save(taked));
    }
}
