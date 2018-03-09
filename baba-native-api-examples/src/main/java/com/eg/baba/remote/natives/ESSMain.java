package com.eg.baba.remote.natives;

import com.aliyuncs.AcsResponse;
import com.aliyuncs.ecs.model.v20140526.AllocatePublicIpAddressRequest;
import com.aliyuncs.ecs.model.v20140526.AllocatePublicIpAddressResponse;
import com.aliyuncs.ecs.model.v20140526.CopyImageRequest;
import com.aliyuncs.ecs.model.v20140526.CopyImageResponse;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceResponse;
import com.aliyuncs.ecs.model.v20140526.DeleteInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.DeleteInstanceResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeSnapshotsRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeSnapshotsResponse;
import com.aliyuncs.ecs.model.v20140526.StartInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.StartInstanceResponse;
import com.aliyuncs.ecs.model.v20140526.StopInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.StopInstanceResponse;
import com.aliyuncs.ess.model.v20140828.ExecuteScalingRuleRequest;
import com.aliyuncs.ess.model.v20140828.ExecuteScalingRuleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.HttpResponse;
import com.eg.baba.remote.ClientProfile;

public class ESSMain extends AbstractMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ESSMain().perform();
	}

	public ESSMain() {
		init();
	}

	public void perform() {
		// TODO Auto-generated method stub

		snapshotInfo();

	}

	private void snapshotInfo() {
		// TODO Auto-generated method stub
		
		ExecuteScalingRuleRequest req = new ExecuteScalingRuleRequest();
		//req.setRegionId("cn-beijing");
		req.setScalingRuleAri("ari:acs:ess:cn-beijing:5517809011627033:scalingrule/asr-2zef8e87t0al3vno22zw");	// Action ARI, scale-out

		try {

			ExecuteScalingRuleResponse res = client.getAcsResponse(req);
			ClientProfile.printObject(res);

			return;

		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
