# baba-native-api-examples
Native API examples of Alibaba Cloud


To run this example

1. Create a gradle project from your Eclipse
2. Add following items to dependencies section in your gradle.build
3. Gradle refresh
4. Rename sample.clientprofile to .clientprofile and make some changes with valid info
5. Build the project
6. Run

    dependencies {
    ..
    // https://mvnrepository.com/artifact/com.aliyun/aliyun-java-sdk-core
    compile group: 'com.aliyun', name: 'aliyun-java-sdk-core', version: '3.2.4'
    // https://mvnrepository.com/artifact/com.aliyun/aliyun-java-sdk-ecs
    compile group: 'com.aliyun', name: 'aliyun-java-sdk-ecs', version: '3.3.0'
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    compile group: 'com.google.code.gson', name: 'gson', version: '2.8.1'    
    }

There will be an server exception when you run the example with no changes by password policy. Then you can make some changes to the password of the instances

	req.setInternetChargeType("PayByTraffic"); // PayByBandwidth, PayByTraffic
	req.setInternetMaxBandwidthOut(100);
	req.setSystemDiskCategory("cloud_ssd"); // cloud_ssd, cloud_efficiency, cloud_efficiency, cloud
	req.setSystemDiskSize(40);
	req.setPassword("<your password>");
	req.setVSwitchId("vsw-6weqz29yrd3mds5vmrgpq");