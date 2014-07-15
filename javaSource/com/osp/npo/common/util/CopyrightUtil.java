package com.osp.npo.common.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import com.osp.npo.common.exception.CopyrightException;

/**
 * Copyright util class
 * 
 * @author haint
 * @version $Revision: 21772 $
 */
public class CopyrightUtil {

	private static final String REGEDIT_KEY_TRIAL_INVALID = "osp.uchi.trial.invalid";
	private static final String REGEDIT_KEY_UUID = "osp.uchi.uuid";
	
	/**
	 * Authenticate Copyright with customer ID
	 * 
	 * @param customerID Customer ID
	 * @param key Copyright key
	 * @return Authentication status
	 * @throws UnknownHostException
	 * @throws SocketException
	 * @throws CopyrightException
	 */
	public static boolean authenticate(String customerID, String key) throws UnknownHostException, SocketException, CopyrightException {
		String inputString = customerID + getUUID();
		return Crypter.matches(key, inputString);
	}
	
	/**
	 * Get RegistryTrialInvalid
	 * @return
	 */
	public static String getRegistryTrialInvalid() {
    	return getRegistry(REGEDIT_KEY_TRIAL_INVALID);
    }
    
	/**
	 * Get UUID from registry
	 * @return
	 */
    public static String getRegistryUuid() {
    	return getRegistry(REGEDIT_KEY_UUID);
    }
    
    /**
     * Set trial invalid
     * @param date
     */
    public static void setRegistryTrialInvalid(String trialInvalid) {
    	setRegistry(REGEDIT_KEY_TRIAL_INVALID, trialInvalid);
    }
    
    /**
     * Set UUID
     * @param uuid
     */
    public static void setRegistryUuid(String uuid) {
    	setRegistry(REGEDIT_KEY_UUID, uuid);
    }
    
	/**
	 * Get MAC address of localhost
	 * 
	 * @return MAC address
	 * @throws UnknownHostException
	 * @throws SocketException
	 * @throws CopyrightException
	 */
	private static String getUUID() throws UnknownHostException, SocketException, CopyrightException {
		
		String uuid = "";
        String os = System.getProperty("os.name");
        
        System.out.println("OS: " + os);
        
        try {
            if (os.startsWith("Windows")) {
                uuid = getRegistry(REGEDIT_KEY_UUID) + getMainboardId();
            } else if (os.startsWith("Linux")) {
                uuid = linuxParseMacAddress(linuxRunIfConfigCommand());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("UUID: " + uuid);
        
        return uuid;
	}
	
	
	/**
	 * Parse MAC address on Linux
	 * 
	 * @param ipConfigResponse
	 * @return MAC address
	 * @throws ParseException
	 */
	private static String linuxParseMacAddress(String ipConfigResponse) throws ParseException {
        String localHost = null;
        try {
            localHost = InetAddress.getLocalHost().getHostAddress();
        } catch (java.net.UnknownHostException ex) {
            ex.printStackTrace();
            throw new ParseException(ex.getMessage(), 0);
        }
        StringTokenizer tokenizer = new StringTokenizer(ipConfigResponse, "\n");
        String lastMacAddress = null;
        while (tokenizer.hasMoreTokens()) {
            String line = tokenizer.nextToken().trim();
            boolean containsLocalHost = line.indexOf(localHost) >= 0;
            if (containsLocalHost && lastMacAddress != null) {// see if line contains IP address
                return lastMacAddress;
            }
            int macAddressPosition = line.indexOf("HWaddr");// see if line contains MAC address
            if (macAddressPosition <= 0) {
                continue;
            }
            String macAddressCandidate = line.substring(macAddressPosition + 6).trim();
            if (linuxIsMacAddress(macAddressCandidate)) {
                lastMacAddress = macAddressCandidate;
                continue;
            }
        }
        ParseException ex = new ParseException("cannot read MAC address for " + localHost + " from [" + ipConfigResponse + "]", 0);
        ex.printStackTrace();
        throw ex;
    }

	/**
	 * Check is MAC address format
	 * 
	 * @param macAddressCandidate
	 * @return true if input string is MAC address
	 */
    private static boolean linuxIsMacAddress(String macAddressCandidate) {
        Pattern macPattern = Pattern.compile("[0-9a-fA-F]{2}[-:][0-9a-fA-F]{2}[-:][0-9a-fA-F]{2}[-:][0-9a-fA-F]{2}[-:][0 -9a-fA-F]{2}[-:][0-9a-fA-F]{2}");
        Matcher m = macPattern.matcher(macAddressCandidate);
        return m.matches();
    }
 
    /**
     * Run ifconfig command on linux
     * 
     * @return command response
     * @throws IOException
     */
    private static String linuxRunIfConfigCommand() throws IOException {
        Process p = Runtime.getRuntime().exec("/sbin/ifconfig");
        InputStream stdoutStream = new BufferedInputStream(p.getInputStream());
        StringBuilder buffer = new StringBuilder();
        for (;;) {
            int c = stdoutStream.read();
            if (c == -1) {
                break;
            }
            buffer.append((char) c);
        }
        String outputText = buffer.toString();
        stdoutStream.close();
        return outputText;
    }
    
    /**
     * Get mainboard id
     * 
     * @return
     */
    private static String getMainboardId() {
    	ComThread.InitMTA();
    	
    	String mainboardId = null; 
        try {
            ActiveXComponent wmi = new ActiveXComponent("winmgmts:\\\\.");
            Variant instances = wmi.invoke("InstancesOf", "Win32_BaseBoard");
            Enumeration<Variant> en = new EnumVariant(instances.getDispatch());
            while (en.hasMoreElements())
            {
                ActiveXComponent bb = new ActiveXComponent(en.nextElement().getDispatch());
                mainboardId = bb.getPropertyAsString("SerialNumber").trim();
                break;
            }
        } finally {
            ComThread.Release();
        }
        
		return mainboardId;
    }
    
    private static void setRegistry(String key, String value) {
    	Preferences systemPref = Preferences.systemRoot();
    	systemPref.put(key, value);
    }
    
    private static String getRegistry(String key) {
    	Preferences systemPref = Preferences.systemRoot();
    	return systemPref.get(key, null);
    }
    
}
