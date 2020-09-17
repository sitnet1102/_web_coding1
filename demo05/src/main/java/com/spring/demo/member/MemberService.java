package com.spring.demo.member;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {
	@Autowired
	MemberDao dao;
	
	public void memberJoin(Member member) {
		int result = dao.memberInsert(member);	
		if (result == 0) {
			System.out.println("Join Fail!!");
		} else {
			System.out.println("Join Success!!");
		}	
	}	
	public Member memberSearch(Member member) {		
		Member mem = dao.memberSelect(member);	
		if (mem == null) {
			System.out.println("Login Fail!!");
		} else {
			System.out.println("Login Success!!");
		}
		
		return mem;
	}
public Member memberModify(Member member) {
		
		int result = dao.memberUpdate(member);
		
		if(result == 0 ) {
			System.out.println("Modify Fail!!");
			return null;
		} else {
			System.out.println("Modify Success!!");
		}
		
		return member;
	}
	
	public int memberRemove(Member member) {
		
		int result = dao.memberDelete(member);
		
		if(result == 0 ) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
	}
}
