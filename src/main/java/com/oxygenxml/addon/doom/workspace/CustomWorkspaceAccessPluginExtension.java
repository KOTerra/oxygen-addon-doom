package com.oxygenxml.addon.doom.workspace;

import java.io.IOException;

import javax.swing.JComponent;

import org.cef.CefApp;

import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;
import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension;
import ro.sync.exml.workspace.api.standalone.StandalonePluginWorkspace;
import ro.sync.exml.workspace.api.standalone.ViewComponentCustomizer;
import ro.sync.exml.workspace.api.standalone.ViewInfo;
import ro.sync.ui.Icons;

/**
 * Plugin extension - workspace access extension.
 */
public class CustomWorkspaceAccessPluginExtension implements WorkspaceAccessPluginExtension {

	public void applicationStarted(final StandalonePluginWorkspace pluginWorkspaceAccess) {

		//System.loadLibrary("jcef");
		pluginWorkspaceAccess.addViewComponentCustomizer(new ViewComponentCustomizer() {

			public void customizeView(ViewInfo viewInfo) {
				if (
				// The view ID defined in the "plugin.xml"
				"DOOM".equals(viewInfo.getViewID())) {

					try {
						viewInfo.setComponent(new GameSelectPanel());
					} catch (IOException | UnsupportedPlatformException | InterruptedException
							| CefInitializationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					viewInfo.setTitle("DOOM");
					viewInfo.setIcon(Icons.getIcon(Icons.DOCKABLE_FRAME_SCHEMAS_DEPENDENCES_HIERARCHY));
				}
			}
		});

	}

	public boolean applicationClosing() {
		CefApp.getInstance().dispose();
		return true;
	}
}