package com.ms.zoo.sns;

import java.util.List;

public interface SNSReplyMapper {
	public abstract int deletere(SNSReply sr);

	public abstract List<SNSReply> getre(SNSMsg sm);

	public abstract int writere(SNSReply sr);

}
