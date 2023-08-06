package com.oxygenxml.addon.doom.workspace;
//Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.cef.CefApp;

import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

/**
 * This is a simple example application using JCEF. It displays a JFrame with a
 * JTextField at its top and a CefBrowser in its center. The JTextField is used
 * to enter and assign an URL to the browser UI. No additional handlers or
 * callbacks are used in this example.
 *
 * The number of used JCEF classes is reduced (nearly) to its minimum and should
 * assist you to get familiar with JCEF.
 *
 * For a more feature complete example have also a look onto the example code
 * within the package "tests.detailed".
 */
public class MainFrame extends JPanel {

	private static final long serialVersionUID = -5570653778104813836L;

	/**
	 * To display a simple browser window, it suffices completely to create an
	 * instance of the class CefBrowser and to assign its UI component to your
	 * application (e.g. to your content pane). But to be more verbose, this CTOR
	 * keeps an instance of each object on the way to the browser UI.
	 */
	private MainFrame() {

	}

	public static void main(String[] args)
			throws UnsupportedPlatformException, CefInitializationException, IOException, InterruptedException {

		JFrame jf = new JFrame();
		JCEFBrowserPanel jp = new JCEFBrowserPanel("google.com");

		jf.getContentPane().add(jp.getBrowserUI_(), BorderLayout.CENTER);
		jf.pack();
		jf.setSize(800, 600);
		jf.setVisible(true);

		// (7) To take care of shutting down CEF accordingly, it's important to call
		// the method "dispose()" of the CefApp instance if the Java
		// application will be closed. Otherwise you'll get asserts from CEF.
		jf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CefApp.getInstance().dispose();
//				jf.dispose();
			}
		});
	}
}