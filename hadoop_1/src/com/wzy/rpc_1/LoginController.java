package com.wzy.rpc_1;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import com.wzy.rpc.LoginServiceInterface;

public class LoginController {

	public static void main(String[] args) throws Exception {
		LoginServiceInterface proxy = RPC.getProxy(LoginServiceInterface.class, 1L, new InetSocketAddress("0.0.0.0", 5353), new Configuration());
		
		String result = proxy.login("wangzy", "123456");
		
		System.out.println(result);
	}
	
	
}
