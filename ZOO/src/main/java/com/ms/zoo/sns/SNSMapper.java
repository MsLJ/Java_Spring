package com.ms.zoo.sns;

import java.util.List;

import com.ms.zoo.member.ZooMember;

public interface SNSMapper {

	public abstract int delete(SNSMsg sm);

	public abstract List<SNSMsg> getSNS(SNSPage sp);

	public abstract int getPage(SNSPage sp);

	public abstract int getwriterPage(ZooMember m);

	public abstract int update(SNSMsg sm);

	public abstract int write(SNSMsg sm);

}
