package com.oxygenxml.addon.doom.workspace;

import java.awt.BorderLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.cef.CefApp;

import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

public class GameSelectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1181823225123423396L;
	private JButton button;
	JCEFBrowserPanel jcef;
	private boolean browserFocus_ = true;

	public GameSelectPanel()
			throws IOException, UnsupportedPlatformException, InterruptedException, CefInitializationException {
		setLayout(new BorderLayout());

		jcef = new JCEFBrowserPanel(GameUrls.DOOM);
		add(jcef.getBrowserUI_(), BorderLayout.CENTER);

		button = new JButton("select");
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jcef.setAddress(GameUrls.MORTAL_COMBAT);
			}
		});
		toolBar.add(button, BorderLayout.EAST);
		add(toolBar, BorderLayout.SOUTH);

		toolBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!browserFocus_)
					return;
				browserFocus_ = false;
				KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
				toolBar.requestFocus();
			}
		});

	}

	public static void main(String[] args)
			throws IOException, UnsupportedPlatformException, InterruptedException, CefInitializationException {

		JFrame jf = new JFrame();
		GameSelectPanel gs = new GameSelectPanel();

		jf.getContentPane().add(gs, BorderLayout.CENTER);
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

	public JCEFBrowserPanel getJcef() {
		return jcef;
	}

}
