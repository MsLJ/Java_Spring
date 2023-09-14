package com.ms.zoo.member;

import java.util.List;

public interface MemberMapper {

	public abstract int deleteMember(ZooMember m);

	public abstract int join(ZooMember m);

	public abstract int updateMember(ZooMember m);

	public abstract ZooMember getMemberByID(ZooMember m);
	public abstract List<ZooMember> get2(ZooMember m);

}
