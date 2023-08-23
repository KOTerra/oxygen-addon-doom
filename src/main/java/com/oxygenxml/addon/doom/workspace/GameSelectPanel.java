package com.oxygenxml.addon.doom.workspace;

import java.awt.BorderLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

public class GameSelectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1181823225123423396L;

	JCEFBrowserPanel jcef;
	private boolean browserFocus_ = true;

	public GameSelectPanel()
			throws IOException, UnsupportedPlatformException, InterruptedException, CefInitializationException {
		setLayout(new BorderLayout());

		jcef = new JCEFBrowserPanel("https://koterra.github.io/oxygen-addon-doom/");
		add(jcef.getBrowserUI_(), BorderLayout.CENTER);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setName("Select");

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);

		comboBox.addItem(GameUrls.DOOM);
		comboBox.addItem(GameUrls.MORTAL_KOMBAT);
		comboBox.addItem(GameUrls.GTA);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox.getSelectedItem();
				jcef.setAddress(GameUrls.getFor(selectedOption));
			}
		});

		toolBar.add(comboBox, BorderLayout.EAST);
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

	public JCEFBrowserPanel getJcef() {
		return jcef;
	}

}
