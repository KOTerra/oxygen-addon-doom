package com.oxygenxml.addon.doom.workspace;

import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefMessageRouter;

import me.friwi.jcefmaven.CefAppBuilder;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

public class JCEFBrowserPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2840067805245851269L;

	private final String NATIVES_PATH = "./jcef-bundle";

	private String address;

	private CefApp cefApp_;
	private CefSettings settings;
	private CefClient client_;
	private CefBrowser browser_;
	private static Component browserUI_;

	public JCEFBrowserPanel(String initialAddress)
			throws IOException, UnsupportedPlatformException, InterruptedException, CefInitializationException {
		this.address = initialAddress;

		// System.setProperty("java.library.path", NATIVES_PATH);

		// CefAppBuilder builder = new CefAppBuilder();
		// builder.setInstallDir(new File("./lib/jcef-bundle"));
		// cefApp_ = JCEFBuildUtil.buildJCEF(builder);
		// System.out.println(System.getProperty("java.library.path"));

		CefApp.startup();
		cefApp_ = CefApp.getInstance();
		
		settings=new CefSettings();
		settings.persist_session_cookies=true;
		settings.windowless_rendering_enabled=false;
		cefApp_.setSettings(settings);

		client_ = cefApp_.createClient();
		CefMessageRouter msgRouter = CefMessageRouter.create();
		client_.addMessageRouter(msgRouter);
		browser_ = client_.createBrowser(address, false, false);
		browserUI_ = browser_.getUIComponent();

	}

	public CefApp getCefApp_() {
		return cefApp_;
	}

	public CefBrowser getBrowser_() {
		return browser_;
	}

	public Component getBrowserUI_() {
		return browserUI_;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
