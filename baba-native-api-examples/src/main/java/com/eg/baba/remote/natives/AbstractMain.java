package com.eg.baba.remote.natives;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.eg.baba.remote.ClientProfile;

public abstract class AbstractMain {
	
	DefaultProfile profile;
	DefaultAcsClient client;
	
	public void init() {
		String region = ClientProfile.getEndpoint();
		String keyId = ClientProfile.getKeyId();
		String keySecret = ClientProfile.getKeySecret();
		
		profile = DefaultProfile.getProfile(region, keyId, keySecret);
		client = new DefaultAcsClient(profile);		
	}
	
}
