package com.eg.baba.remote.natives;

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
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.eg.baba.remote.ClientProfile;

public class ECSMain extends AbstractMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ECSMain().perform();
	}

	public ECSMain() {
		init();
	}

	public void perform() {
		// TODO Auto-generated method stub

//		String instanceId = createInstance();
//
//		allocPublicIP(instanceId);
//
//		startInstance(instanceId);
//		stopInstance(instanceId);
//		releaseInstance(instanceId);
		
//		copyImage();
		
		snapshotInfo();

	}

	private void snapshotInfo() {
		// TODO Auto-generated method stub
		
		DescribeSnapshotsRequest req = new DescribeSnapshotsRequest();
		req.setRegionId("cn-shanghai");
		req.setInstanceId("i-uf6fbha9mr8dm6k46nze");

		try {

			DescribeSnapshotsResponse res = client.getAcsResponse(req);
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

	private void copyImage() {
		// TODO Auto-generated method stub

		CopyImageRequest req = new CopyImageRequest();
		req.setRegionId("cn-shanghai");
		req.setImageId("m-uf6ie8zk8pyppyb959rk");
		req.setDestinationRegionId("cn-hongkong");
		req.setDestinationImageName("LIXING_20171121_01");
		req.setDestinationDescription("Copied from "+req.getRegionId()+" at "+System.currentTimeMillis());

		try {

			CopyImageResponse res = client.getAcsResponse(req);
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

	private String createInstance() {
		// TODO Auto-generated method stub

		CreateInstanceRequest req = new CreateInstanceRequest();
		CreateInstanceResponse res = null;

		req.setZoneId("ap-northeast-1a");
		req.setImageId("centos_7_03_64_40G_alibase_20170625.vhd");
		req.setInstanceType("ecs.e4.large");
		req.setInstanceName("eg-jp-ecs-temp");
		req.setInternetChargeType("PayByTraffic"); // PayByBandwidth, PayByTraffic
		req.setInternetMaxBandwidthOut(100);
		req.setSystemDiskCategory("cloud_ssd"); // cloud_ssd, cloud_efficiency, cloud_efficiency, cloud
		req.setSystemDiskSize(40);
		req.setPassword("<your password>");
		req.setVSwitchId("vsw-6weqz29yrd3mds5vmrgpq");

		// req.setIoOptimized("ioOptimized");
		req.setHostName("eg-jp-ecs-temp");

		ClientProfile.printObject(req);

		try {

			res = client.getAcsResponse(req);
			ClientProfile.printObject(res);

			String instanceId = res.getInstanceId();
			return instanceId;

		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private boolean releaseInstance(String instanceId) {
		// TODO Auto-generated method stub

		DeleteInstanceRequest req = new DeleteInstanceRequest();
		req.setInstanceId(instanceId);

		try {

			DeleteInstanceResponse res = client.getAcsResponse(req);
			ClientProfile.printObject(res);

			return true;

		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	private boolean stopInstance(String instanceId) {
		// TODO Auto-generated method stub

		StopInstanceRequest req = new StopInstanceRequest();
		req.setInstanceId(instanceId);

		try {

			StopInstanceResponse res = client.getAcsResponse(req);
			ClientProfile.printObject(res);

			return true;

		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	private boolean startInstance(String instanceId) {
		// TODO Auto-generated method stub

		StartInstanceRequest req = new StartInstanceRequest();
		req.setInstanceId(instanceId);

		try {

			StartInstanceResponse res = client.getAcsResponse(req);
			ClientProfile.printObject(res);

			return true;

		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	private String allocPublicIP(String instanceId) {
		// TODO Auto-generated method stub

		AllocatePublicIpAddressRequest req = new AllocatePublicIpAddressRequest();
		req.setInstanceId(instanceId);

		try {

			AllocatePublicIpAddressResponse res = client.getAcsResponse(req);
			ClientProfile.printObject(res);

			return res.getIpAddress();

		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
