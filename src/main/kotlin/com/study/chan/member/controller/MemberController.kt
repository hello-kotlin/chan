package com.study.chan.member.controller

import com.study.chan.member.controller.request.MemberSignUpRequest
import com.study.chan.member.controller.response.MemberResponse
import com.study.chan.member.service.MemberSignUpService
import com.study.chan.member.service.MemberViewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberViewService: MemberViewService,
    private val memberSignUpService: MemberSignUpService
) {

    @GetMapping("/{memberId}")
    fun viewMember(@PathVariable("memberId") memberId: Long): MemberResponse =
        MemberResponse.from(memberViewService.viewMember(memberId))

    @PostMapping
    fun signUpMember(@RequestBody req: MemberSignUpRequest): MemberResponse =
        MemberResponse.from(
            memberSignUpService.signUp(
                email = req.email,
                username = req.username,
                password = req.password
            )
        )

}